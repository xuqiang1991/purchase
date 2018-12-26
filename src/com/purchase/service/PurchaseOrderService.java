package com.purchase.service;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizPurchaseOrder;
import com.purchase.pojo.order.BizPurchaseOrderDetail;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.ChosePurchaseOrderVO;
import com.purchase.vo.order.BizPurchaseOrderDetailsVo;
import com.purchase.vo.order.BizPurchaseOrderSearch;
import com.purchase.vo.order.BizPurchaseOrderVo;

import java.util.List;

/**
 * Created by xuqiang
 * 2018/8/15.
 */
public interface PurchaseOrderService {

    ResultUtil getOrderList(Integer page, Integer limit, BizPurchaseOrderSearch search);

    ResultUtil addPurchaseOrder(BizPurchaseOrder order);

    ResultUtil editPurchaseOrder(BizPurchaseOrder order);

    BizPurchaseOrderDetailsVo selPurchaseOrder(String id,Long adminId);

    ResultUtil delPurchaseOrder(String id);

    ResultUtil submitPurchaseOrder(String id);

    ResultUtil reviewPurchaseOrder(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion, Long applyRole);

    /**
     * 根据供应商和订单状态查询
     * @param status
     * @param supplier
     * @return
     */
    List<BizPurchaseOrder> selectPurchaseOrder(Integer status, Long supplier);

    List<BizPurchaseOrderVo> selectPurchaseOrderExample(Integer status, Long supplier);

    ResultUtil addPurchaseOrderItem(BizPurchaseOrderDetail order);

    ResultUtil editPurchaseOrderItem(BizPurchaseOrderDetail order);

    ResultUtil deletePurchaseOrderItem(String itemId);

    ResultUtil getPurchaseOrderItem(String itemId);

    ResultUtil submitReviewPurchaseOrder(TbAdmin admin, String id, Long userId);

    ResultUtil purchaseOrderContractNo(String id, String contractNo);

    BizPurchaseOrderVo selPurchaseOrderById(String id);

    List<ChosePurchaseOrderVO> selectChosePurchaseOrder();
}
