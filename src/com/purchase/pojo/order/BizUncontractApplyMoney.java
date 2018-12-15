package com.purchase.pojo.order;

import java.math.BigDecimal;
import java.util.Date;

public class BizUncontractApplyMoney {
    private String id;

    private String orderNo;

    private Long createUser;

    private Date createTime;

    private Long applyUser;

    private Date applyDate;

    private String projectId;

    private String orderType;

    private Integer instructOrderFlag;

    private String instructOrderNo;

    private Integer status;

    private BigDecimal applyPrice;

    private BigDecimal actualPrice;

    private Date updateDate;

    private String summary;

    private Long supplierId;

    private Long nextReviewUser;

    private Long nextReviewRole;

    private String nextReviewRoleName;

    private Long lastReviewUser;

    private Date lastReviewDate;

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

    public Integer getInstructOrderFlag() {
        return instructOrderFlag;
    }

    public void setInstructOrderFlag(Integer instructOrderFlag) {
        this.instructOrderFlag = instructOrderFlag;
    }

    public String getInstructOrderNo() {
        return instructOrderNo;
    }

    public void setInstructOrderNo(String instructOrderNo) {
        this.instructOrderNo = instructOrderNo == null ? null : instructOrderNo.trim();
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

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
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

    public String getNextReviewRoleName() {
        return nextReviewRoleName;
    }

    public void setNextReviewRoleName(String nextReviewRoleName) {
        this.nextReviewRoleName = nextReviewRoleName == null ? null : nextReviewRoleName.trim();
    }

    public Long getLastReviewUser() {
        return lastReviewUser;
    }

    public void setLastReviewUser(Long lastReviewUser) {
        this.lastReviewUser = lastReviewUser;
    }

    public Date getLastReviewDate() {
        return lastReviewDate;
    }

    public void setLastReviewDate(Date lastReviewDate) {
        this.lastReviewDate = lastReviewDate;
    }
}