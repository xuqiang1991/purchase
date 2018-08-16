package com.purchase.service;

import com.purchase.pojo.order.BizPurchaseOrder;
import com.purchase.util.ResultUtil;

/**
 * Created by xuqiang
 * 2018/8/15.
 */
public interface PurchaseOrderService {

    ResultUtil getOrderList(Integer page, Integer limit, BizPurchaseOrder order);
}
