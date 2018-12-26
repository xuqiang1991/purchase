package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.admin.TbRolesMapper;
import com.purchase.mapper.admin.TbSupplierMapper;
import com.purchase.mapper.order.*;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbRoles;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.order.*;
import com.purchase.service.CAMService;
import com.purchase.service.PaymentOrderService;
import com.purchase.service.PurchaseOrderService;
import com.purchase.util.*;
import com.purchase.vo.OrderHistory;
import com.purchase.vo.admin.ChoseAdminVO;
import com.purchase.vo.order.BizPurchaseOrderVo;
import com.purchase.vo.order.CAMDetailsVo;
import com.purchase.vo.order.CAMSearch;
import com.purchase.vo.order.CAMVo;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/24 21:20
 * @Description:合同内请款单service层
 */
@Service
public class CAMServiceImpl implements CAMService {

    private static Logger logger = LoggerFactory.getLogger(CAMServiceImpl.class);

    @Autowired
    private BizContractApplyMoneyMapper camMapper;

    @Autowired
    private BizContractApplyMoneyDetailMapper contractApplyMoneyDetailMapper;

    @Autowired
    private TbSupplierMapper supplierMapper;

    @Autowired
    private TbAdminMapper adminMapper;

    @Autowired
    private BizPurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private BizPurchaseOrderDetailMapper purchaseOrderDetailMapper;

    @Autowired
    private BizHistoryMapper historyMapper;

    @Autowired
    private TbRolesMapper rolesMapper;

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @Autowired
    private PaymentOrderService paymentOrderService;


    @Override
    public ResultUtil getCAMOrderList(Integer page, Integer limit, CAMSearch search) {
        PageHelper.startPage(page, limit);

        BizContractApplyMoneyExample example = new BizContractApplyMoneyExample();
        //设置按创建时间降序排序
        example.setOrderByClause("update_date DESC");
        BizContractApplyMoneyExample.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotEmpty(search.getOrderNo())) {
            //注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
            criteria.andOrderNoLike("%" + search.getOrderNo() + "%");
        }
        if (StringUtils.isNotBlank(search.getOrderType())) {
            criteria.andOrderTypeEqualTo(search.getOrderType());
        }
        if (search.getSupplierId() != null) {
            criteria.andSupplierIdEqualTo(search.getSupplierId());
        }

        if (search.getStartCreateTime() != null) {
            criteria.andCreateTimeGreaterThanOrEqualTo(search.getStartCreateTime());
        }
        if (search.getEndCreateTime() != null) {
            criteria.andCreateTimeLessThanOrEqualTo(search.getEndCreateTime());
        }

        List<CAMVo> users = camMapper.selectByExampleExt(example, search);
        PageInfo<CAMVo> pageInfo = new PageInfo<>(users);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public ResultUtil addCAMOrder(BizContractApplyMoney order) {
        Date date = new Date();

        String id = null;
        if(StringUtils.isBlank(order.getId())){
            id = WebUtils.generateUUID();
            order.setId(id);
            //生成订单号
            String yyddmm = DateUtil.formatDate(date, DateUtil.DateFormat3);
            String prefix = CAMUtil.prefix + yyddmm;
            String pn = camMapper.selMaxOrderNo(prefix);
            String purchaseNo = CAMUtil.generateOrderNo(pn);
            order.setOrderNo(purchaseNo);

            String sourceOrderId = order.getSourceOrderId();
            BizPurchaseOrder purchaseOrder = purchaseOrderMapper.selectByPrimaryKey(sourceOrderId);

            //所属项目
            String projectId = purchaseOrder.getProjectId();
            order.setProjectId(projectId);

            //单据类型
            String type = purchaseOrder.getType();
            order.setOrderType(type);

            //补充参数
            order.setCreateTime(date);
            order.setUpdateDate(date);

            camMapper.insertSelective(order);
        }else {
            id = order.getId();

            //查询付款单订单来源是否改变，如果改变了，清空明细
            String sourceOrderId = order.getSourceOrderId();
            BizContractApplyMoney contractApplyMoney = camMapper.selectByPrimaryKey(id);
            String oldSourceOrderId = contractApplyMoney.getSourceOrderId();
            if(sourceOrderId.equals(oldSourceOrderId)){
                BizContractApplyMoneyDetailExample example = new BizContractApplyMoneyDetailExample();
                example.createCriteria().andOrderNoEqualTo(id);
                contractApplyMoneyDetailMapper.deleteByExample(example);
            }

            BizPurchaseOrder purchaseOrder = purchaseOrderMapper.selectByPrimaryKey(sourceOrderId);
            //所属项目
            String projectId = purchaseOrder.getProjectId();
            order.setProjectId(projectId);

            //单据类型
            String type = purchaseOrder.getType();
            order.setOrderType(type);

            order.setUpdateDate(date);
            camMapper.updateByPrimaryKeySelective(order);
        }

        return ResultUtil.ok(id);
    }

    @Override
    public ResultUtil editCAMOrder(BizContractApplyMoney order) {
        return null;
    }

    @Override
    public CAMDetailsVo selCAMOrder(String id) {
        CAMDetailsVo detailsVo = new CAMDetailsVo();

        CAMVo vo = getCAMOrder(id);
        detailsVo.setOrder(vo);

        //获取合同内单详情
        String orderNo = vo.getOrderNo();
        BizContractApplyMoneyDetailExample example = new BizContractApplyMoneyDetailExample();
        BizContractApplyMoneyDetailExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<BizContractApplyMoneyDetail> detailList = contractApplyMoneyDetailMapper.selectByExample(example);
        detailsVo.setDetails(detailList);

        //过滤已添加过详情的合同订单详情
        List<BizPurchaseOrderDetail> details = vo.getDetails();
        if(!CollectionUtils.isEmpty(details) && !CollectionUtils.isEmpty(detailList)){
            for(int i = details.size() - 1; i >= 0; i--){
                BizPurchaseOrderDetail item = details.get(i);
                String itemId = item.getId();
                for (BizContractApplyMoneyDetail detail :detailList ){
                    String purchaseDetailId = detail.getPurchaseDetailId();
                    if(itemId.equals(purchaseDetailId)){
                        details.remove(item);
                        break;
                    }
                }
            }
        }

        //选择审核人
        String roleName = "工程部";
        Long reviewUserId = null;
        detailsVo.setReviewUserId(reviewUserId);
        if(roleName != null){
            List<ChoseAdminVO> data = adminMapper.selectByRoleName(roleName);
            if(!CollectionUtils.isEmpty(data)){
                Gson gson = new Gson();
                String json = gson.toJson(data);
                detailsVo.setDeparts(json);
            }
        }

        return detailsVo;
    }

    public CAMVo getCAMOrder(String id){
        //获取请款单
        BizContractApplyMoney order = camMapper.selectByPrimaryKey(id);
        CAMVo vo = new CAMVo();
        BeanUtils.copyProperties(order, vo);

        Long userId = order.getCreateUser();
        TbAdmin tbAdmin = adminMapper.selectByPrimaryKey(userId);
        vo.setAdmin(tbAdmin);


        Long applyuserId = order.getApplyUser();
        if (applyuserId != null) {
            TbAdmin applyAdmin = adminMapper.selectByPrimaryKey(applyuserId);
            vo.setApplyAdmin(applyAdmin);
        }

        Long supplierId = order.getSupplierId();
        if (supplierId != null) {
            TbSupplier supplier = supplierMapper.selectByPrimaryKey(supplierId);
            vo.setSupplier(supplier);
        }

        //来源订单
        String sourceOrderId = order.getSourceOrderId();
        if(sourceOrderId != null){
            BizPurchaseOrderVo purchaseOrderVo = purchaseOrderService.selPurchaseOrderById(sourceOrderId);
            vo.setPurchaseOrderVo(purchaseOrderVo);

            //获取合同订单详情
            String purchaseNo = purchaseOrderVo.getPurchaseNo();
            BizPurchaseOrderDetailExample example1 = new BizPurchaseOrderDetailExample();
            BizPurchaseOrderDetailExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andPurchaseNoEqualTo(purchaseNo);
            List<BizPurchaseOrderDetail> detailList1 = purchaseOrderDetailMapper.selectByExample(example1);
            vo.setDetails(detailList1);

        }

        Long applyUserId = order.getApplyUser();
        if(applyUserId != null){
            TbAdmin auAdmin = adminMapper.selectByPrimaryKey(applyUserId);
            vo.setAuAdmin(auAdmin);
        }

        return vo;
    }

    @Override
    public ResultUtil addCAMItem(BizContractApplyMoneyDetail order) {
        String id = MyUtil.getStrUUID();
        order.setId(id);
        contractApplyMoneyDetailMapper.insertSelective(order);

        BigDecimal price = order.getSettlePrice();

        //如有金额更新合同订单
        if (price != null) {
            String orderNo = order.getOrderNo();
            BizContractApplyMoney camOrder = camMapper.selectByOrderNo(orderNo);
            BigDecimal contractMoney = camOrder.getApplyPrice();
            if (contractMoney == null) {
                contractMoney = price;
            } else {
                contractMoney = contractMoney.add(price);
            }

            BizContractApplyMoney tmp = new BizContractApplyMoney();
            tmp.setId(camOrder.getId());
            tmp.setApplyPrice(contractMoney);
            tmp.setUpdateDate(order.getUpdateDate());
            camMapper.updateByPrimaryKeySelective(tmp);
        }

        return ResultUtil.ok();
    }


    @Override
    @Transactional
    public ResultUtil addCAMItems(String orderNo, String ids) {

        List<String> list = Arrays.asList(ids.trim().split(","));

        Date curTime = new Date();
        for (String purchaseDid : list){
            BizPurchaseOrderDetail detail = purchaseOrderDetailMapper.selectByPrimaryKey(purchaseDid);
            BizContractApplyMoneyDetail order = new BizContractApplyMoneyDetail();
            String id = MyUtil.getStrUUID();
            order.setId(id);
            order.setOrderNo(orderNo);
            order.setPurchaseDetailId(purchaseDid);
            order.setProjectContent(detail.getContent());
            order.setModel(detail.getModel());
            order.setUnit(detail.getUnit());
            order.setPrice(detail.getPrice());
            order.setContractCount(detail.getAmount());
            Double settleAmout;
            BigDecimal settlePrice = new BigDecimal(0);
            if(detail.getSettleAmout() == null){
                detail.setSettleAmout(0D);
            }

            settleAmout = detail.getAmount() - detail.getSettleAmout();
            if(settleAmout < 0){
                settleAmout = 0D;
            }
            settlePrice = new BigDecimal(settleAmout).multiply(detail.getPrice());

            order.setSettleAmout(settleAmout);
            order.setSettlePrice(settlePrice);
            order.setWarrantyDate(detail.getWarrantyDate());
            order.setDate(detail.getDate());
            order.setCreateTime(curTime);
            order.setUpdateDate(curTime);
            contractApplyMoneyDetailMapper.insertSelective(order);

            BigDecimal price = order.getSettlePrice();

            //如有金额更新合同订单
            if (price != null) {
                BizContractApplyMoney camOrder = camMapper.selectByOrderNo(orderNo);
                BigDecimal contractMoney = camOrder.getApplyPrice();
                if (contractMoney == null) {
                    contractMoney = price;
                } else {
                    contractMoney = contractMoney.add(price);
                }

                BizContractApplyMoney tmp = new BizContractApplyMoney();
                tmp.setId(camOrder.getId());
                tmp.setApplyPrice(contractMoney);
                tmp.setUpdateDate(order.getUpdateDate());
                camMapper.updateByPrimaryKeySelective(tmp);
            }

        }
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil editCAMItem(BizContractApplyMoneyDetail order) {

        BizContractApplyMoneyDetail detail = contractApplyMoneyDetailMapper.selectByPrimaryKey(order.getId());
        BigDecimal oldPrice = detail.getSettlePrice();

        order.setPurchaseDetailId(null);
        contractApplyMoneyDetailMapper.updateByPrimaryKeySelective(order);

        BigDecimal price = oldPrice.subtract(order.getSettlePrice());

        //如有金额更新合同订单
        if (price != null) {
            String orderNo = order.getOrderNo();
            BizContractApplyMoney camOrder = camMapper.selectByOrderNo(orderNo);
            BigDecimal contractMoney = camOrder.getApplyPrice();
            if (contractMoney == null) {
                contractMoney = price;
            } else {
                contractMoney = contractMoney.add(price);
            }

            BizContractApplyMoney tmp = new BizContractApplyMoney();
            tmp.setId(camOrder.getId());
            tmp.setApplyPrice(contractMoney);
            tmp.setUpdateDate(order.getUpdateDate());
            camMapper.updateByPrimaryKeySelective(tmp);
        }

        return ResultUtil.ok();
    }

    @Override
    public ResultUtil delCAM(String id) {
        BizContractApplyMoney order = camMapper.selectByPrimaryKey(id);
        if (!(CAMUtil.STATUS_0 == order.getStatus())) {
            return ResultUtil.error("非未提交状态的合同内请款单不能删除！");
        }
        camMapper.deleteByPrimaryKey(id);


        //删除请款单详情
        BizContractApplyMoneyDetailExample example = new BizContractApplyMoneyDetailExample();
        example.createCriteria().andOrderNoEqualTo(order.getOrderNo());
        List<BizContractApplyMoneyDetail> details = contractApplyMoneyDetailMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(details)){
            for (BizContractApplyMoneyDetail detail : details){
                delCAMItem(detail);
            }

        }

        return ResultUtil.ok();
    }

    @Override
    public ResultUtil delCAMItem(String id) {
        BizContractApplyMoneyDetail order = contractApplyMoneyDetailMapper.selectByPrimaryKey(id);
        return delCAMItem(order);
    }

    private ResultUtil delCAMItem(BizContractApplyMoneyDetail order) {
        String id = order.getId();
        BigDecimal price = order.getSettlePrice();

        //如有金额更新合同订单
        if (price != null) {
            String orderNo = order.getOrderNo();
            BizContractApplyMoney camOrder = camMapper.selectByOrderNo(orderNo);
            BigDecimal applyPrice = camOrder.getApplyPrice();
            BigDecimal tmpPrice = applyPrice.subtract(price);

            BizContractApplyMoney tmp = new BizContractApplyMoney();
            tmp.setId(camOrder.getId());
            tmp.setApplyPrice(tmpPrice);
            tmp.setUpdateDate(order.getUpdateDate());
            camMapper.updateByPrimaryKeySelective(tmp);
        }

        contractApplyMoneyDetailMapper.deleteByPrimaryKey(id);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil getCAMItem(String itemId) {
        BizContractApplyMoneyDetail order = contractApplyMoneyDetailMapper.selectByPrimaryKey(itemId);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setData(order);
        return resultUtil;
    }

    @Override
    public ResultUtil submitCAMOrder(String id, Long userId, Long roleId) {
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();

        BizContractApplyMoney order = camMapper.selectByPrimaryKey(id);

        BizContractApplyMoney tmp = new BizContractApplyMoney();
        tmp.setId(order.getId());
        tmp.setIsApproval(OrderUtils.IS_APPROVAL_YES);
        tmp.setLastReviewDate(new Date());
        tmp.setLastReviewUser(admin.getId());
        tmp.setNextReviewRole(roleId);
        tmp.setNextReviewUser(userId);
        tmp.setUpdateDate(new Date());
        tmp.setApplyDate(new Date());
        tmp.setUserItem(OrderUtils.getUserItem(order.getUserItem(),String.valueOf(userId)));
        tmp.setIsSaveSubmit(1);
        camMapper.updateByPrimaryKeySelective(tmp);

        BizHistory history = new BizHistory();
        history.setId(WebUtils.generateUUID());
        history.setIsApproval(OrderUtils.IS_APPROVAL_YES);
        history.setOrderId(order.getId());
        history.setApprovalDate(new Date());
        history.setApprovalUser(admin.getId());
        history.setApprovalUserName(admin.getFullname());
        TbRoles roles = rolesMapper.selectByPrimaryKey(order.getLastReviewRole());
        if(roles != null){
            history.setApprovalRoleName(roles.getRoleName());
        }
        history.setOpinion("提交审核");
        historyMapper.insert(history);
        return ResultUtil.ok(order);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultUtil reviewCAMOrder(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion, Long applyRole) {
        Date date = new Date();
        BizContractApplyMoney order = camMapper.selectByPrimaryKey(id);
        BizHistory history = new BizHistory();
        history.setId(WebUtils.generateUUID());
        //审核不通过
        if(!auditResults){
            order.setIsSaveSubmit(OrderUtils.IS_SAVE_SUBMIT_0);
            order.setIsApproval(OrderUtils.IS_APPROVAL_NO);
            order.setLastReviewRole(null);
            order.setLastReviewUser(null);
            order.setNextReviewUser(order.getCreateUser());//驳回则还原到创建人
            history.setIsApproval(OrderUtils.IS_APPROVAL_NO);
        }else{
            order.setIsSaveSubmit(OrderUtils.IS_SAVE_SUBMIT_1);
            order.setIsApproval(OrderUtils.IS_APPROVAL_YES);
            order.setLastReviewRole(order.getNextReviewRole());
            order.setLastReviewUser(admin.getId());
            order.setNextReviewUser(applyUser);
            order.setNextReviewRole(applyRole);
            history.setIsApproval(OrderUtils.IS_APPROVAL_YES);
        }
        order.setLastReviewDate(date);
        order.setUserItem(OrderUtils.getUserItem(order.getUserItem(),String.valueOf(applyUser)));
        order.setUpdateDate(date);

        history.setOrderId(order.getId());
        history.setApprovalDate(new Date());
        history.setApprovalUser(admin.getId());
        history.setApprovalUserName(admin.getFullname());
        TbRoles roles = rolesMapper.selectByPrimaryKey(order.getLastReviewRole());
        if(roles != null){
            history.setApprovalRoleName(roles.getRoleName());
        }
        history.setOpinion(auditOpinion);

        //总经理审核写入付款单
        if(auditResults && roles.getIsOverRole() == 1){
            paymentOrderService.generatePaymenyOrder(order);

            //回写主合同订单
            String sourceOrderId = order.getSourceOrderId();
            BizPurchaseOrder tmp1 = new BizPurchaseOrder();
            tmp1.setId(sourceOrderId);
            tmp1.setRequestAmount(order.getApplyPrice());
            purchaseOrderMapper.updateByPrimaryKeySelective(tmp1);

            //回写合同订单详情(已结算数量)
            String orderNo = order.getOrderNo();
            BizContractApplyMoneyDetailExample example = new BizContractApplyMoneyDetailExample();
            BizContractApplyMoneyDetailExample.Criteria criteria = example.createCriteria();
            criteria.andOrderNoEqualTo(orderNo);
            List<BizContractApplyMoneyDetail> detailList = contractApplyMoneyDetailMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(detailList)){
                for (BizContractApplyMoneyDetail detail : detailList){
                    Double settleAmout = detail.getSettleAmout();
                    String purchaseDetailId = detail.getPurchaseDetailId();
                    BizPurchaseOrderDetail detail1 = purchaseOrderDetailMapper.selectByPrimaryKey(purchaseDetailId);
                    Double oldSettleAmout = detail1.getSettleAmout();
                    if(oldSettleAmout == null){
                        oldSettleAmout = 0D;
                    }

                    BizPurchaseOrderDetail record = new BizPurchaseOrderDetail();
                    record.setId(purchaseDetailId);
                    record.setSettleAmout(oldSettleAmout + settleAmout);
                    purchaseOrderDetailMapper.updateByPrimaryKeySelective(record);
                }
            }
        }

        camMapper.updateByPrimaryKeySelective(order);
        historyMapper.insert(history);
        return ResultUtil.ok(order);
    }

    @Override
    public ResultUtil checkCAMItem(String purchaseDetailId) {
        Map<String,Object> map = new HashMap<>();

        //查询结算数量是否超标
        BizPurchaseOrderDetail detail = purchaseOrderDetailMapper.selectByPrimaryKey(purchaseDetailId);
        Double amount = detail.getAmount();
        Double allSettleAmount = contractApplyMoneyDetailMapper.checkCAMItemSettleAmout(purchaseDetailId);

        map.put("amount",amount - allSettleAmount);//结算数量

        //查询是否多条
        Long count = contractApplyMoneyDetailMapper.checkCAMItemCount(purchaseDetailId);
        map.put("count", count);

        return ResultUtil.ok(map);
    }

    @Override
    public ResultUtil checkCAM(String id) {
        BizContractApplyMoney contractApplyMoney = camMapper.selectByPrimaryKey(id);
        String sourceOrderId = contractApplyMoney.getSourceOrderId();
        String orderNo = contractApplyMoney.getOrderNo();
        Map<String,Object> map = new HashMap<>();

        //查询结算数量是否超标
        BizContractApplyMoneyDetailExample example = new BizContractApplyMoneyDetailExample();
        BizContractApplyMoneyDetailExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<BizContractApplyMoneyDetail> detailList = contractApplyMoneyDetailMapper.selectByExample(example);
        Double a = null;
        for (BizContractApplyMoneyDetail detail : detailList){
            String purchaseDetailId = detail.getPurchaseDetailId();
            Double settleAmount = detail.getSettleAmout();
            BizPurchaseOrderDetail purchaseDetail = purchaseOrderDetailMapper.selectByPrimaryKey(purchaseDetailId);
            Double amount = purchaseDetail.getAmount();

            Double as = amount - settleAmount;
            if(as < 0){
                a = as;
                break;
            }
        }

        map.put("amount",a);//结算数量

        //查询是否多条
        Long count = contractApplyMoneyDetailMapper.checkCAMCount(sourceOrderId);
        map.put("count", count);

        return ResultUtil.ok(map);
    }
}

