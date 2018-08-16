package com.purchase.vo.order;

import com.purchase.pojo.order.BizPurchaseOrder;

/**
 * Created by xuqiang
 * 2018/8/16.
 */
public class BizPurchaseOrderVo extends BizPurchaseOrder {
    private String supplierName;
    private String userFullName;
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }
}
