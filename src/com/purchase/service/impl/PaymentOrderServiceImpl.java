package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.admin.TbDepartmentMapper;
import com.purchase.mapper.order.BizContractApplyMoneyMapper;
import com.purchase.mapper.order.BizPaymentOrderMapper;
import com.purchase.mapper.order.BizPurchaseOrderMapper;
import com.purchase.mapper.order.BizUncontractApplyMoneyMapper;
import com.purchase.pojo.admin.*;
import com.purchase.pojo.order.*;
import com.purchase.service.PaymentOrderService;
import com.purchase.util.*;
import com.purchase.vo.admin.ChoseAdminVO;
import com.purchase.vo.order.BizPaymentOrderSearch;
import com.purchase.vo.order.BizPaymentOrderVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Auther: xuqiang
 * @Date: 2018/10/7
 * @Description:付款
 */
@Service
public class PaymentOrderServiceImpl implements PaymentOrderService {
    private static Logger logger = LoggerFactory.getLogger(PaymentOrderServiceImpl.class);

    @Autowired
    private BizPaymentOrderMapper bizPaymentOrderMapper;

    @Autowired
    private TbDepartmentMapper departmentMapper;

    @Autowired
    private TbAdminMapper adminMapper;

    @Autowired
    private BizPurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private BizContractApplyMoneyMapper contractApplyMoneyMapper;

    @Autowired
    private BizUncontractApplyMoneyMapper uContractApplyMoneyMapper;

    @Override
    public ResultUtil getOrderList(Integer page, Integer limit, BizPaymentOrderSearch search) {
        PageHelper.startPage(page, limit);

        BizPaymentOrderExample example=new BizPaymentOrderExample();
        //设置按创建时间降序排序
        example.setOrderByClause("create_time DESC");
        BizPaymentOrderExample.Criteria criteria = example.createCriteria();

        if(StringUtils.isNotEmpty(search.getOrderNo())){
            //注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
            criteria.andOrderNoLike("%"+search.getOrderNo()+"%");
        }
        if(search.getSupplierId() != null){
            criteria.andSupplierIdEqualTo(search.getSupplierId());
        }
        if(StringUtils.isNotBlank(search.getProjectId())){
            criteria.andProjectIdEqualTo(search.getProjectId());
        }
        if(search.getCreateUser() != null){
            criteria.andCreateUserEqualTo(search.getCreateUser());
        }
        if(search.getCreateTime() != null){
            criteria.andCreateTimeEqualTo(search.getCreateTime());
        }

        List<BizPaymentOrderVo> users = bizPaymentOrderMapper.selectByExampleExt(example, search);
        PageInfo<BizPaymentOrderVo> pageInfo = new PageInfo<>(users);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public BizPaymentOrderVo getPaymentOrderDetails(String id, TbAdmin admin) {
        BizPaymentOrderExample example=new BizPaymentOrderExample();
        BizPaymentOrderExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        BizPaymentOrderSearch search = new BizPaymentOrderSearch();
        search.setLoginId(admin.getId());
        List<BizPaymentOrderVo> users = bizPaymentOrderMapper.selectByExampleExt(example, search);
        BizPaymentOrderVo vo = users.get(0);

        //判断审核人
        if(admin.getDeptId() != null){
            TbAdminExample adminExample = new TbAdminExample();
            TbAdminExample.Criteria adminCriteria = adminExample.createCriteria();
            adminCriteria.andIdEqualTo(admin.getId());
            List<TbRoles> roles = adminMapper.selectRoleByExample(adminExample);
            List<String> roleNames = Lists.transform(roles, entity -> entity.getRoleName());

            if(roleNames.contains("总经理") && vo.getFinancePaymentUser() == null){
                vo.setReviewUserId(admin.getId());
                String roleName = "财务部";
                List<ChoseAdminVO> data = adminMapper.selectByRoleName(roleName);
                if(!CollectionUtils.isEmpty(data)){
                    Gson gson = new Gson();
                    String json = gson.toJson(data);
                    vo.setDeparts(json);
                }
            }else if(vo.getFinancePaymentUser() != null && vo.getFinancePaymentUser().compareTo(admin.getId()) == 0){
                vo.setFinanceUserId(admin.getId());
            }
        }

        return vo;
    }

    @Override
    public ResultUtil editPaymentOrder(BizPaymentOrder order) {
        bizPaymentOrderMapper.updateByPrimaryKeySelective(order);
        return ResultUtil.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultUtil reviewOrder(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion) {
        Date date = new Date();
        BizPaymentOrder order = bizPaymentOrderMapper.selectByPrimaryKey(id);
        Long userId = admin.getId();
        int status = order.getStatus();


        Long reviewer = null;
        Boolean reviewerResults = null;
        if(status == 0){//总经理审核
            TbAdminExample adminExample = new TbAdminExample();
            TbAdminExample.Criteria adminCriteria = adminExample.createCriteria();
            adminCriteria.andIdEqualTo(admin.getId());
            List<TbRoles> roles = adminMapper.selectRoleByExample(adminExample);
            if(!roles.contains("总经理")){
                return ResultUtil.error("没有审核权限!");
            }
            //判断审核人
            reviewer = order.getManagerDepartUser();
            reviewerResults = order.getManagerDepartApproval();
        }else if(status == 1){
            if(order.getFinancePaymentUser() != userId.longValue()){
                return ResultUtil.error("没有审核权限!");
            }
            reviewer = order.getFinancePaymentUser();
            reviewerResults = order.getFinancePaymentApproval();
        }else {
            return ResultUtil.error("订单不需要审核");
        }

        if(reviewer == null){
            return ResultUtil.error("审核人不存在");
        }
        if(reviewer.compareTo(userId) != 0){
            return ResultUtil.error("没有审核权限！");
        }
        if(reviewerResults != null && reviewerResults){
            return ResultUtil.error("请不要重新审核！");
        }


        //审核状态
        BizPaymentOrder tmp = new BizPaymentOrder();
        tmp.setId(order.getId());

        if(status == 0){
            tmp.setStatus(1);
            tmp.setManagerDepartApproval(auditResults);
            tmp.setManagerDepartDate(date);
            tmp.setManagerDepartOpinion(auditOpinion);
            tmp.setManagerDepartUser(userId);
            tmp.setFinancePaymentUser(applyUser);
        }else if(status == 1){
            tmp.setStatus(2);
            tmp.setFinancePaymentApproval(auditResults);
            tmp.setFinancePaymentDate(date);
            tmp.setFinancePaymentOpinion(auditOpinion);
            tmp.setFinancePaymentUser(userId);
        }

        //审核不通过
        if(!auditResults){
            tmp.setStatus(0);
        }

        bizPaymentOrderMapper.updateByPrimaryKeySelective(tmp);

        //财务付款
        if(tmp.getStatus() == 2){
            int applyType = order.getApplyType();
            String contractOrderNo = order.getContractOrderNo();
            if(applyType == 0){
                //回写采购单
                String purchaseNo = order.getPurchaseNo();
                BizPurchaseOrder purchaseOrder = purchaseOrderMapper.selectByPurchaseNo(purchaseNo);
                BizPurchaseOrder pTmp = new BizPurchaseOrder();
                pTmp.setId(purchaseOrder.getId());
                BigDecimal paymentAmount = purchaseOrder.getPaymentAmount();
                if(paymentAmount == null){
                    paymentAmount = new BigDecimal(0);
                }
                pTmp.setPaymentAmount(new BigDecimal(order.getAmountPaid()).add(paymentAmount));
                purchaseOrderMapper.updateByPrimaryKeySelective(pTmp);


                //回写请款单
                BizContractApplyMoney contractApplyMoney = contractApplyMoneyMapper.selectByOrderNo(contractOrderNo);
                BizContractApplyMoney cTmp = new BizContractApplyMoney();
                cTmp.setId(contractApplyMoney.getId());
                BigDecimal actualPrice = contractApplyMoney.getActualPrice();
                if(actualPrice == null){
                    actualPrice = new BigDecimal(0);
                }
                cTmp.setActualPrice(new BigDecimal(order.getAmountPaid()).add(actualPrice));
                contractApplyMoneyMapper.updateByPrimaryKey(cTmp);
            }else {
                //回写请款单
                BizUncontractApplyMoney uContractApplyMoney = uContractApplyMoneyMapper.selectByOrderNo(contractOrderNo);
                BizUncontractApplyMoney cTmp = new BizUncontractApplyMoney();
                cTmp.setId(uContractApplyMoney.getId());
                BigDecimal actualPrice = uContractApplyMoney.getActualPrice();
                if(actualPrice == null){
                    actualPrice = new BigDecimal(0);
                }
                cTmp.setActualPrice(new BigDecimal(order.getAmountPaid()).add(actualPrice));
                uContractApplyMoneyMapper.updateByPrimaryKey(cTmp);
            }
        }
        return ResultUtil.ok();
    }



    /**
     * 合同内生产付款单
     */
    public void generatePaymenyOrder(BizContractApplyMoney order){
        Date date = new Date();
        BizPaymentOrder paymentOrder = new BizPaymentOrder();

        String id = WebUtils.generateUUID();
        paymentOrder.setId(id);
        //生成订单号
        String yyddmm = DateUtil.formatDate(date, DateUtil.DateFormat3);
        String prefix = PaymentOrderUtil.prefix + yyddmm;
        String pn = bizPaymentOrderMapper.selMaxOrderNo(prefix);
        String purchaseNo = CAMUtil.generateOrderNo(pn);
        paymentOrder.setOrderNo(purchaseNo);


        paymentOrder.setCreateUser(order.getApplyUser());
        paymentOrder.setCreateTime(order.getCreateTime());
        paymentOrder.setSupplierId(order.getSupplierId());
        paymentOrder.setApplyType(0);
        paymentOrder.setContractOrderNo(order.getOrderNo());
        paymentOrder.setApplyUser(order.getApplyUser());

        TbAdmin applyAdmin = adminMapper.selectByPrimaryKey(order.getApplyUser());
        paymentOrder.setApplyUserPhone(applyAdmin.getPhone());

        paymentOrder.setProjectId(order.getProjectId());

        String sourceOrderId = order.getSourceOrderId();
        BizPurchaseOrder purchaseOrder = purchaseOrderMapper.selectByPrimaryKey(sourceOrderId);
        paymentOrder.setPurchaseNo(purchaseOrder.getPurchaseNo());
        paymentOrder.setContractId(purchaseOrder.getContractNo());

        paymentOrder.setApplyPrice(order.getApplyPrice());
        paymentOrder.setApprovalPrice(order.getActualPrice());

        //初始化总经理审核
        paymentOrder.setManagerDepartUser(getManagerAdminByDeptId());

        bizPaymentOrderMapper.insertSelective(paymentOrder);
    }

    /**
     * 合同外生产付款单
     */
    public void generatePaymenyOrder(BizUncontractApplyMoney order){
        Date date = new Date();
        BizPaymentOrder paymentOrder = new BizPaymentOrder();

        String id = WebUtils.generateUUID();
        paymentOrder.setId(id);
        //生成订单号
        String yyddmm = DateUtil.formatDate(date, DateUtil.DateFormat3);
        String prefix = PaymentOrderUtil.prefix + yyddmm;
        String pn = bizPaymentOrderMapper.selMaxOrderNo(prefix);
        String purchaseNo = CAMUtil.generateOrderNo(pn);
        paymentOrder.setOrderNo(purchaseNo);


        paymentOrder.setCreateUser(order.getApplyUser());
        paymentOrder.setCreateTime(order.getCreateTime());
        paymentOrder.setSupplierId(order.getSupplierId());
        paymentOrder.setApplyType(1);
        paymentOrder.setContractOrderNo(order.getOrderNo());
        paymentOrder.setApplyUser(order.getApplyUser());

        TbAdmin applyAdmin = adminMapper.selectByPrimaryKey(order.getApplyUser());
        paymentOrder.setApplyUserPhone(applyAdmin.getPhone());

        paymentOrder.setProjectId(order.getProjectId());

        paymentOrder.setApplyPrice(order.getApplyPrice());
        paymentOrder.setApprovalPrice(order.getActualPrice());

        //初始化总经理审核
        paymentOrder.setManagerDepartUser(getManagerAdminByDeptId());

        bizPaymentOrderMapper.insertSelective(paymentOrder);
    }


    /**
     * 获取总经理ID
     */
    private Long getManagerAdminByDeptId(){
        Long id = null;
        TbDepartmentExample example=new TbDepartmentExample();
        TbDepartmentExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo("总经理");
        List<TbDepartment> list = departmentMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(list)){
            TbDepartment department = list.get(0);
            Long deptId = department.getId();
            List<TbAdmin> admins = adminMapper.getAdminsByDeptId(String.valueOf(deptId));
            if(!CollectionUtils.isEmpty(admins)){
                TbAdmin admin = admins.get(0);
                id = admin.getId();
            }
        }
        return id;
    }


}
