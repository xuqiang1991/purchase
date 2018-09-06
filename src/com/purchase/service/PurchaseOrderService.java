package com.purchase.service;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizPurchaseOrder;
import com.purchase.util.ResultUtil;
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

    ResultUtil selPurchaseOrder(String purchaseNo);

    ResultUtil delPurchaseOrder(String id);

    ResultUtil submitPurchaseOrder(String id);

    ResultUtil reviewPurchaseOrder(TbAdmin admin, String id);

    /**
     * 根据供应商和订单状态查询
     * @param status
     * @param supplier
     * @return
     */
    List<BizPurchaseOrder> selectPurchaseOrder(Integer status, Long supplier);

    List<BizPurchaseOrderVo> selectPurchaseOrderExample(Integer status, Long supplier);

}
