package com.purchase.vo.order;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.pojo.admin.TbRoles;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.order.BizHistory;
import com.purchase.pojo.order.BizProgrammeAcceptanceOrder;

import java.util.List;

/**
 *
 */
public class ProgrammeAcceptanceVo extends BizProgrammeAcceptanceOrder {

    private TbSupplier supplier;//所属供应商
    private TbProjectManger tpm;//所属项目

    private TbAdmin admin;//创建人
    private TbAdmin auAdmin;//申请人

    private TbAdmin nextAdmin;//下一个审批人
    private TbRoles nextRole;//下一个审批角色

    private TbAdmin lastUser;//上一步审核人或操作人
    private TbRoles lastRole;//上一步审核角色或操作角色

    private List<BizHistory> historyList;

    public TbSupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(TbSupplier supplier) {
        this.supplier = supplier;
    }

    public TbProjectManger getTpm() {
        return tpm;
    }

    public void setTpm(TbProjectManger tpm) {
        this.tpm = tpm;
    }

    public TbAdmin getAdmin() {
        return admin;
    }

    public void setAdmin(TbAdmin admin) {
        this.admin = admin;
    }

    public TbAdmin getAuAdmin() {
        return auAdmin;
    }

    public void setAuAdmin(TbAdmin auAdmin) {
        this.auAdmin = auAdmin;
    }

    public TbAdmin getNextAdmin() {
        return nextAdmin;
    }

    public void setNextAdmin(TbAdmin nextAdmin) {
        this.nextAdmin = nextAdmin;
    }

    public TbRoles getNextRole() {
        return nextRole;
    }

    public void setNextRole(TbRoles nextRole) {
        this.nextRole = nextRole;
    }

    public TbAdmin getLastUser() {
        return lastUser;
    }

    public void setLastUser(TbAdmin lastUser) {
        this.lastUser = lastUser;
    }

    public TbRoles getLastRole() {
        return lastRole;
    }

    public void setLastRole(TbRoles lastRole) {
        this.lastRole = lastRole;
    }

    public List<BizHistory> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<BizHistory> historyList) {
        this.historyList = historyList;
    }
}
