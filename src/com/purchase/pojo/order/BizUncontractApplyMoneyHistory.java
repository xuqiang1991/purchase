package com.purchase.pojo.order;

import java.util.Date;

public class BizUncontractApplyMoneyHistory {
    private String id;

    private String uncontractApplyMoneyId;

    private Integer status;

    private Integer isApproval;

    private String opinion;

    private Date approvalDate;

    private String approvalUser;

    private String approvalUserName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUncontractApplyMoneyId() {
        return uncontractApplyMoneyId;
    }

    public void setUncontractApplyMoneyId(String uncontractApplyMoneyId) {
        this.uncontractApplyMoneyId = uncontractApplyMoneyId == null ? null : uncontractApplyMoneyId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsApproval() {
        return isApproval;
    }

    public void setIsApproval(Integer isApproval) {
        this.isApproval = isApproval;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion == null ? null : opinion.trim();
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getApprovalUser() {
        return approvalUser;
    }

    public void setApprovalUser(String approvalUser) {
        this.approvalUser = approvalUser == null ? null : approvalUser.trim();
    }

    public String getApprovalUserName() {
        return approvalUserName;
    }

    public void setApprovalUserName(String approvalUserName) {
        this.approvalUserName = approvalUserName == null ? null : approvalUserName.trim();
    }
}