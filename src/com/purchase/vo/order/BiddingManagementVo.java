package com.purchase.vo.order;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbArea;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.order.BizBiddingManagement;
import com.purchase.pojo.order.BizContractApplyMoney;
import com.purchase.vo.OrderHistory;

import java.util.List;

public class BiddingManagementVo extends BizBiddingManagement {

    private TbAdmin createAdmin;
    private TbAdmin bidAdmin;
    private TbArea cityArea;
    private TbSupplier supplier;

    public TbAdmin getCreateAdmin() {
        return createAdmin;
    }

    public void setCreateAdmin(TbAdmin createAdmin) {
        this.createAdmin = createAdmin;
    }

    public TbAdmin getBidAdmin() {
        return bidAdmin;
    }

    public void setBidAdmin(TbAdmin bidAdmin) {
        this.bidAdmin = bidAdmin;
    }

    public TbArea getCityArea() {
        return cityArea;
    }

    public void setCityArea(TbArea cityArea) {
        this.cityArea = cityArea;
    }

    public TbSupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(TbSupplier supplier) {
        this.supplier = supplier;
    }
}
