package com.purchase.pojo.order;

import java.math.BigDecimal;
import java.util.Date;

public class BizContractApplyMoney {
    private String id;

    private String orderNo;

    private Long createUser;

    private Date createTime;

    private Long applyUser;

    private Date applyDate;

    private String sourceOrderId;

    private Long supplierId;

    private String projectId;

    private String orderType;

    private Integer status;

    private BigDecimal applyPrice;

    private BigDecimal actualPrice;

    private Date updateDate;

    private String summary;

    private Long nextReviewUser;

    private Long nextReviewRole;

    private Long lastReviewUser;

    private Long lastReviewRole;

    private Date lastReviewDate;

    private Integer isApproval;

    private Integer isSaveSubmit;

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

    public String getSourceOrderId() {
        return sourceOrderId;
    }

    public void setSourceOrderId(String sourceOrderId) {
        this.sourceOrderId = sourceOrderId == null ? null : sourceOrderId.trim();
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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getApplyPrice() {
        return applyPrice;
    }

    public void setApplyPrice(BigDecimal applyPrice) {
        this.applyPrice = applyPrice;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
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

    public Integer getIsSaveSubmit() {
        return isSaveSubmit;
    }

    public void setIsSaveSubmit(Integer isSaveSubmit) {
        this.isSaveSubmit = isSaveSubmit;
    }

    public String getUserItem() {
        return userItem;
    }

    public void setUserItem(String userItem) {
        this.userItem = userItem == null ? null : userItem.trim();
    }
}