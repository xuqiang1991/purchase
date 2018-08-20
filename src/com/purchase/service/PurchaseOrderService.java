package com.purchase.service;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizPurchaseOrder;
import com.purchase.util.ResultUtil;
import com.purchase.vo.order.BizPurchaseOrderSearch;

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

}
