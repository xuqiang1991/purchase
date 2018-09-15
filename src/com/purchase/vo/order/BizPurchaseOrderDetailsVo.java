package com.purchase.vo.order;

import com.purchase.pojo.order.BizPurchaseOrderDetail;

import java.util.List;

/**
 * Created by xuqiang
 * 2018/8/16.
 */
public class BizPurchaseOrderDetailsVo {

    private BizPurchaseOrderVo purchaseOrder;

    private List<BizPurchaseOrderDetail> details;

    public BizPurchaseOrderVo getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(BizPurchaseOrderVo purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public List<BizPurchaseOrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<BizPurchaseOrderDetail> details) {
        this.details = details;
    }
}
