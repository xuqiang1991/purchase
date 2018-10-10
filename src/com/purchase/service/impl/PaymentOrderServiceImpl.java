package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.admin.TbDepartmentMapper;
import com.purchase.mapper.order.BizPaymentOrderMapper;
import com.purchase.mapper.order.BizPurchaseOrderMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbDepartment;
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
import org.springframework.util.CollectionUtils;

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
        List<BizPaymentOrderVo> users = bizPaymentOrderMapper.selectByExampleExt(example, search);
        BizPaymentOrderVo vo = users.get(0);

        if(admin.getDeptId() != null){
            TbDepartment department = departmentMapper.selectByPrimaryKey(Long.parseLong(admin.getDeptId()));
            if(department != null && "总经理".equals(department.getName())){
                vo.setReviewUserId(admin.getId());
                String depart = "财务部";
                List<ChoseAdminVO> data = adminMapper.selectByDeptName(depart);
                if(!CollectionUtils.isEmpty(data)){
                    Gson gson = new Gson();
                    String json = gson.toJson(data);
                    vo.setDeparts(json);
                }
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
    public ResultUtil reviewOrder(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion) {
        Date date = new Date();
        BizPaymentOrder order = bizPaymentOrderMapper.selectByPrimaryKey(id);
        Long userId = admin.getId();
        int status = order.getStatus();


        if(status == 0){//总经理审核
            TbDepartment department = departmentMapper.selectByPrimaryKey(userId);
            if(!(department != null && "总经理".equals(department.getName()))){
                return ResultUtil.error("没有审核权限!");
            }
        }else if(status == 1){
            if(order.getFinancePaymentUser() != userId.longValue()){
                return ResultUtil.error("没有审核权限!");
            }
        }else {
            return ResultUtil.error("订单不需要审核");
        }


        //判断审核人
        Long reviewer = order.getManagerDepartUser();
        Boolean reviewerResults = order.getManagerDepartApproval();

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
        paymentOrder.setApplyUser(order.getApplyUser());

        TbAdmin applyAdmin = adminMapper.selectByPrimaryKey(order.getApplyUser());
        paymentOrder.setApplyUserPhone(applyAdmin.getPhone());

        paymentOrder.setProjectId(order.getProjectId());

        String sourceOrderId = order.getSourceOrderId();
        BizPurchaseOrder purchaseOrder = purchaseOrderMapper.selectByPrimaryKey(sourceOrderId);
        paymentOrder.setContractId(purchaseOrder.getContractNo());

        paymentOrder.setApplyPrice(order.getApplyPrice());
        paymentOrder.setApprovalPrice(order.getActualPrice());

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
        paymentOrder.setApplyType(0);
        paymentOrder.setApplyUser(order.getApplyUser());

        TbAdmin applyAdmin = adminMapper.selectByPrimaryKey(order.getApplyUser());
        paymentOrder.setApplyUserPhone(applyAdmin.getPhone());

        paymentOrder.setProjectId(order.getProjectId());

        paymentOrder.setApplyPrice(order.getApplyPrice());
        paymentOrder.setApprovalPrice(order.getActualPrice());

        bizPaymentOrderMapper.insertSelective(paymentOrder);
    }


}
