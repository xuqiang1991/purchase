package com.purchase.vo.order;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.order.BizUncontractApplyMoney;
import com.purchase.vo.OrderHistory;

import java.util.List;

/**
 *
 */
public class UCAMVo extends BizUncontractApplyMoney {

    private TbSupplier supplier;
    private TbAdmin admin;
    private TbProjectManger tpm;
    private TbAdmin auAdmin;
    private TbAdmin nrAdmin;
    private TbAdmin lrAdmin;
    private List<OrderHistory> historyList;

    public TbSupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(TbSupplier supplier) {
        this.supplier = supplier;
    }

    public TbAdmin getAdmin() {
        return admin;
    }

    public void setAdmin(TbAdmin admin) {
        this.admin = admin;
    }



    public TbProjectManger getTpm() {
        return tpm;
    }

    public void setTpm(TbProjectManger tpm) {
        this.tpm = tpm;
    }

    public TbAdmin getAuAdmin() {
        return auAdmin;
    }

    public void setAuAdmin(TbAdmin auAdmin) {
        this.auAdmin = auAdmin;
    }

    public TbAdmin getNrAdmin() {
        return nrAdmin;
    }

    public void setNrAdmin(TbAdmin nrAdmin) {
        this.nrAdmin = nrAdmin;
    }

    public TbAdmin getLrAdmin() {
        return lrAdmin;
    }

    public void setLrAdmin(TbAdmin lrAdmin) {
        this.lrAdmin = lrAdmin;
    }

    public List<OrderHistory> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<OrderHistory> historyList) {
        this.historyList = historyList;
    }
}
