package com.purchase.pojo.order;

import java.util.Date;

public class BizHistory {
    private String id;

    private String orderId;

    private Integer isApproval;

    private String opinion;

    private Date approvalDate;

    private Long approvalUser;

    private String approvalUserName;

    private String approvalRoleName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
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

    public Long getApprovalUser() {
        return approvalUser;
    }

    public void setApprovalUser(Long approvalUser) {
        this.approvalUser = approvalUser;
    }

    public String getApprovalUserName() {
        return approvalUserName;
    }

    public void setApprovalUserName(String approvalUserName) {
        this.approvalUserName = approvalUserName == null ? null : approvalUserName.trim();
    }

    public String getApprovalRoleName() {
        return approvalRoleName;
    }

    public void setApprovalRoleName(String approvalRoleName) {
        this.approvalRoleName = approvalRoleName == null ? null : approvalRoleName.trim();
    }
}