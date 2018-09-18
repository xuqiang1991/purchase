package com.purchase.vo.order;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.order.BizUncontractApplyMoney;

/**
 *
 */
public class UCAMVo extends BizUncontractApplyMoney {

    private TbAdmin admin;
    private TbAdmin costAdmin;
    private TbAdmin projectAdmin;
    private TbAdmin managerAdmin;
    private TbProjectManger tpm;

    public TbAdmin getAdmin() {
        return admin;
    }

    public void setAdmin(TbAdmin admin) {
        this.admin = admin;
    }

    public TbAdmin getCostAdmin() {
        return costAdmin;
    }

    public void setCostAdmin(TbAdmin costAdmin) {
        this.costAdmin = costAdmin;
    }

    public TbAdmin getProjectAdmin() {
        return projectAdmin;
    }

    public void setProjectAdmin(TbAdmin projectAdmin) {
        this.projectAdmin = projectAdmin;
    }

    public TbAdmin getManagerAdmin() {
        return managerAdmin;
    }

    public void setManagerAdmin(TbAdmin managerAdmin) {
        this.managerAdmin = managerAdmin;
    }

    public TbProjectManger getTpm() {
        return tpm;
    }

    public void setTpm(TbProjectManger tpm) {
        this.tpm = tpm;
    }
}
