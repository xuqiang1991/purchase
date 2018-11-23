package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.admin.TbSupplierMapper;
import com.purchase.mapper.order.BizContractApplyMoneyDetailMapper;
import com.purchase.mapper.order.BizContractApplyMoneyMapper;
import com.purchase.mapper.order.BizPurchaseOrderDetailMapper;
import com.purchase.mapper.order.BizPurchaseOrderMapper;
import com.purchase.pojo.admin.TbAdmin;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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

        //过滤已添加过详情的采购单详情
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

        //审核历史
        List<OrderHistory> historyList = new ArrayList<OrderHistory>();
        int status = vo.getStatus();
        if(PurchaseUtil.STATUS_0 == status){
            historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,PurchaseUtil.STATUS_0));
        }else if(PurchaseUtil.STATUS_1 == status){
            historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,PurchaseUtil.STATUS_0));
            historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,PurchaseUtil.STATUS_1));
        }else if(PurchaseUtil.STATUS_2 == status){
            historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,PurchaseUtil.STATUS_0));
            historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,PurchaseUtil.STATUS_1));
            historyList.add(new OrderHistory(vo.getCostAdmin().getFullname(),vo.getCostDepartDate(),vo.getCostDepartOpinion(),vo.getCostDepartApproval(),PurchaseUtil.STATUS_2));
        }else if(PurchaseUtil.STATUS_3 == status){
            historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,PurchaseUtil.STATUS_0));
            historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,PurchaseUtil.STATUS_1));
            historyList.add(new OrderHistory(vo.getCostAdmin().getFullname(),vo.getCostDepartDate(),vo.getCostDepartOpinion(),vo.getCostDepartApproval(),PurchaseUtil.STATUS_2));
            historyList.add(new OrderHistory(vo.getProjectAdmin().getFullname(),vo.getProjectDepartDate(),vo.getProjectDepartOpinion(),vo.getProjectDepartApproval(),PurchaseUtil.STATUS_3));
        }else if(PurchaseUtil.STATUS_4 == status){
            historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,PurchaseUtil.STATUS_0));
            historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,PurchaseUtil.STATUS_1));
            historyList.add(new OrderHistory(vo.getCostAdmin().getFullname(),vo.getCostDepartDate(),vo.getCostDepartOpinion(),vo.getCostDepartApproval(),PurchaseUtil.STATUS_2));
            historyList.add(new OrderHistory(vo.getProjectAdmin().getFullname(),vo.getProjectDepartDate(),vo.getProjectDepartOpinion(),vo.getProjectDepartApproval(),PurchaseUtil.STATUS_3));
            historyList.add(new OrderHistory(vo.getManagerAdmin().getFullname(),vo.getManagerDepartDate(),vo.getManagerDepartOpinion(),vo.getManagerDepartApproval(),PurchaseUtil.STATUS_4));
        }
        Collections.reverse(historyList);
        vo.setHistoryList(historyList);

        //选择审核人
        String roleName = "成本部";
        Long reviewUserId = null;
        switch (vo.getStatus()){
            case PurchaseUtil.STATUS_1:
                reviewUserId = vo.getCostDepartUser(); roleName = "工程部";
                break;
            case PurchaseUtil.STATUS_2:
                reviewUserId = vo.getProjectDepartUser(); roleName = "总经理";
                break;
            case PurchaseUtil.STATUS_3:
                reviewUserId = vo.getManagerDepartUser();
                break;
            default:
                logger.info("不在处理流程内，不做修改");
                break;
        }
        detailsVo.setReviewUserId(reviewUserId);

        if (roleName != null) {
            List<ChoseAdminVO> data = adminMapper.selectByRoleName(roleName);
            if (!CollectionUtils.isEmpty(data)) {
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

        Long costUserId = order.getCostDepartUser();
        if (costUserId != null) {
            TbAdmin costAdmin = adminMapper.selectByPrimaryKey(costUserId);
            vo.setCostAdmin(costAdmin);
        }

        Long projectUserId = order.getProjectDepartUser();
        if (projectUserId != null) {
            TbAdmin projectAdmin = adminMapper.selectByPrimaryKey(projectUserId);
            vo.setProjectAdmin(projectAdmin);
        }

        Long managerUserId = order.getManagerDepartUser();
        if (managerUserId != null) {
            TbAdmin managerAdmin = adminMapper.selectByPrimaryKey(managerUserId);
            vo.setManagerAdmin(managerAdmin);
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

            //获取采购单详情
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
        contractApplyMoneyDetailMapper.insert(order);

        BigDecimal price = order.getSettlePrice();

        //如有金额更新采购单
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
    public ResultUtil editCAMItem(BizContractApplyMoneyDetail order) {

        BizContractApplyMoneyDetail detail = contractApplyMoneyDetailMapper.selectByPrimaryKey(order.getId());
        BigDecimal oldPrice = detail.getSettlePrice();

        order.setPurchaseDetailId(null);
        contractApplyMoneyDetailMapper.updateByPrimaryKeySelective(order);

        BigDecimal price = oldPrice.subtract(order.getSettlePrice());

        //如有金额更新采购单
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

        BizContractApplyMoneyDetailExample example = new BizContractApplyMoneyDetailExample();
        example.createCriteria().andOrderNoEqualTo(id);
        contractApplyMoneyDetailMapper.deleteByExample(example);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil delCAMItem(String id) {
        BizContractApplyMoneyDetail order = contractApplyMoneyDetailMapper.selectByPrimaryKey(id);

        BigDecimal price = order.getSettlePrice();

        //如有金额更新采购单
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
    public ResultUtil submitCAMOrder(String id) {
        BizContractApplyMoney order = camMapper.selectByPrimaryKey(id);

        int status = order.getStatus();
        if (!(CAMUtil.STATUS_0 == status)) {
            return ResultUtil.error("非未提交状态的采购单不能提交！");
        }

        BizContractApplyMoney tmp = new BizContractApplyMoney();
        tmp.setId(order.getId());
        tmp.setStatus(CAMUtil.STATUS_1);
        tmp.setApplyDate(new Date());
        camMapper.updateByPrimaryKeySelective(tmp);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil submitReviewCAMOrder(TbAdmin admin, String id, Long userId) {
        BizContractApplyMoney order = camMapper.selectByPrimaryKey(id);

        int status = order.getStatus();
        if (CAMUtil.STATUS_1 != status) {
            return ResultUtil.error("非未提交状态的采购单不能选择成本部审核！");
        }
        Date date = new Date();
        BizContractApplyMoney tmp = new BizContractApplyMoney();
        tmp.setId(order.getId());
        tmp.setCostDepartUser(userId);
        tmp.setUpdateDate(date);

        camMapper.updateByPrimaryKeySelective(tmp);
        return ResultUtil.ok();
    }


    @Override
    public ResultUtil reviewCAMOrder(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion) {
        Date date = new Date();
        BizContractApplyMoney order = camMapper.selectByPrimaryKey(id);
        Long userId = admin.getId();
        int status = order.getStatus();

        //判断审核人
        Long reviewer = null;
        Boolean reviewerResults = null;
        if (CAMUtil.STATUS_1 == status) {
            reviewer = order.getCostDepartUser();
            reviewerResults = order.getCostDepartApproval();
        } else if (CAMUtil.STATUS_2 == status) {
            reviewer = order.getProjectDepartUser();
            reviewerResults = order.getProjectDepartApproval();
        } else if (CAMUtil.STATUS_3 == status) {
            reviewer = order.getManagerDepartUser();
            reviewerResults = order.getManagerDepartApproval();
        }
        if (reviewer == null) {
            return ResultUtil.error("审核人不存在");
        }
        if (reviewer.compareTo(userId) != 0) {
            return ResultUtil.error("没有审核权限！");
        }
        if (reviewerResults != null && reviewerResults) {
            return ResultUtil.error("请不要重新审核！");
        }

        //审核状态
        BizContractApplyMoney tmp = new BizContractApplyMoney();
        tmp.setId(id);
        if (CAMUtil.STATUS_1 == status) {
            tmp.setStatus(CAMUtil.STATUS_2);
            tmp.setCostDepartApproval(auditResults);
            tmp.setCostDepartDate(date);
            tmp.setCostDepartOpinion(auditOpinion);
            tmp.setProjectDepartUser(applyUser);
        } else if (CAMUtil.STATUS_2 == status) {
            tmp.setStatus(CAMUtil.STATUS_3);
            tmp.setProjectDepartApproval(auditResults);
            tmp.setProjectDepartDate(date);
            tmp.setProjectDepartOpinion(auditOpinion);
            tmp.setManagerDepartUser(applyUser);
        } else if (CAMUtil.STATUS_3 == status) {
            tmp.setStatus(CAMUtil.STATUS_4);
            tmp.setManagerDepartApproval(auditResults);
            tmp.setManagerDepartDate(date);
            tmp.setManagerDepartOpinion(auditOpinion);
        } else if (CAMUtil.STATUS_4 == status) {
            tmp.setStatus(CAMUtil.STATUS_5);
        }
        //审核不通过
        if(!auditResults){
            tmp.setStatus(0);
        }
        tmp.setUpdateDate(date);

        camMapper.updateByPrimaryKeySelective(tmp);

        //总经理审核写入付款单
        if(PurchaseUtil.STATUS_3 == status){
            paymentOrderService.generatePaymenyOrder(order);


            //回写主采购单
           String sourceOrderId = order.getSourceOrderId();
            BizPurchaseOrder tmp1 = new BizPurchaseOrder();
            tmp1.setId(sourceOrderId);
            tmp1.setRequestAmount(order.getApplyPrice());
            purchaseOrderMapper.updateByPrimaryKeySelective(tmp1);

            //回写采购单详情(已结算数量)
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

                    BizPurchaseOrderDetail record = new BizPurchaseOrderDetail();
                    record.setId(purchaseDetailId);
                    record.setSettleAmout(oldSettleAmout + settleAmout);
                    purchaseOrderDetailMapper.updateByPrimaryKeySelective(record);
                }
            }
        }

        return ResultUtil.ok();
    }

    @Override
    public ResultUtil checkCAMItem(String purchaseDetailNo) {
        Long count = contractApplyMoneyDetailMapper.checkCAMItem(purchaseDetailNo);
        return ResultUtil.ok(String.valueOf(count));
    }
}

