package com.purchase.pojo.biz;

import java.math.BigDecimal;
import java.util.Date;

public class BizOrder {
    private String id;

    private String orderNo;

    private String type;

    private Long createUser;

    private Date createTime;

    private Long applyUser;

    private Date applyDate;

    private Long supplierId;

    private String projectId;

    private String contractNo;

    private Date contractSignDate;

    private BigDecimal contractMoney;

    private Date warrantyDate;

    private Double paymentRatio;

    private BigDecimal unsubscribedAmount;

    private BigDecimal requestAmount;

    private BigDecimal paymentAmount;

    private Integer status;

    private Date updateDate;

    private String summary;

    private Long nextReviewUser;

    private Long nextReviewRole;

    private Long lastReviewUser;

    private Long lastReviewRole;

    private Date lastReviewDate;

    private Integer isApproval;

    private String userItem;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(Long applyUser) {
        this.applyUser = applyUser;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public Date getContractSignDate() {
        return contractSignDate;
    }

    public void setContractSignDate(Date contractSignDate) {
        this.contractSignDate = contractSignDate;
    }

    public BigDecimal getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(BigDecimal contractMoney) {
        this.contractMoney = contractMoney;
    }

    public Date getWarrantyDate() {
        return warrantyDate;
    }

    public void setWarrantyDate(Date warrantyDate) {
        this.warrantyDate = warrantyDate;
    }

    public Double getPaymentRatio() {
        return paymentRatio;
    }

    public void setPaymentRatio(Double paymentRatio) {
        this.paymentRatio = paymentRatio;
    }

    public BigDecimal getUnsubscribedAmount() {
        return unsubscribedAmount;
    }

    public void setUnsubscribedAmount(BigDecimal unsubscribedAmount) {
        this.unsubscribedAmount = unsubscribedAmount;
    }

    public BigDecimal getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(BigDecimal requestAmount) {
        this.requestAmount = requestAmount;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Long getNextReviewUser() {
        return nextReviewUser;
    }

    public void setNextReviewUser(Long nextReviewUser) {
        this.nextReviewUser = nextReviewUser;
    }

    public Long getNextReviewRole() {
        return nextReviewRole;
    }

    public void setNextReviewRole(Long nextReviewRole) {
        this.nextReviewRole = nextReviewRole;
    }

    public Long getLastReviewUser() {
        return lastReviewUser;
    }

    public void setLastReviewUser(Long lastReviewUser) {
        this.lastReviewUser = lastReviewUser;
    }

    public Long getLastReviewRole() {
        return lastReviewRole;
    }

    public void setLastReviewRole(Long lastReviewRole) {
        this.lastReviewRole = lastReviewRole;
    }

    public Date getLastReviewDate() {
        return lastReviewDate;
    }

    public void setLastReviewDate(Date lastReviewDate) {
        this.lastReviewDate = lastReviewDate;
    }

    public Integer getIsApproval() {
        return isApproval;
    }

    public void setIsApproval(Integer isApproval) {
        this.isApproval = isApproval;
    }

    public String getUserItem() {
        return userItem;
    }

    public void setUserItem(String userItem) {
        this.userItem = userItem == null ? null : userItem.trim();
    }
}