package com.purchase.vo.order;

import com.purchase.pojo.order.BizPurchaseOrderDetail;
import com.purchase.util.OrderTypeEnum;

import java.util.List;

/**
 * Created by xuqiang
 * 2018/8/16.
 */
public class BizPurchaseOrderDetailsVo {

    private BizPurchaseOrderVo purchaseOrder;

    private List<BizPurchaseOrderDetail> details;

    private Long reviewUserId;

    private String departs;

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

    public String getDeparts() {
        return departs;
    }

    public void setDeparts(String departs) {
        this.departs = departs;
    }

    public Long getReviewUserId() {
        return reviewUserId;
    }

    public void setReviewUserId(Long reviewUserId) {
        this.reviewUserId = reviewUserId;
    }

    public String getType() {
        return OrderTypeEnum.getVisitorByCode(purchaseOrder.getType()).getName();
    }

}
