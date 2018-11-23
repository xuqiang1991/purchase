package com.purchase.pojo.order;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class BizPurchaseOrder {
    private String id;

    private String purchaseNo;

    private String contractNo;

    private String type;

    private Long createUser;

    private Date createTime;

    private Long applyUser;

    private Date applyDate;

    private Long supplierId;

    private String projectId;

    private BigDecimal contractMoney;

    private Double paymentRatio;

    private BigDecimal requestAmount;

    private BigDecimal paymentAmount;

    private Integer status;

    private Date updateDate;

    private String summary;

    private Boolean costDepartApproval;

    private Long costDepartUser;

    private Date costDepartDate;

    private String costDepartOpinion;

    private Boolean projectDepartApproval;

    private Long projectDepartUser;

    private Date projectDepartDate;

    private String projectDepartOpinion;

    private Boolean managerDepartApproval;

    private Long managerDepartUser;

    private Date managerDepartDate;

    private String managerDepartOpinion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(String purchaseNo) {
        this.purchaseNo = purchaseNo == null ? null : purchaseNo.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
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

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
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

    public BigDecimal getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(BigDecimal contractMoney) {
        this.contractMoney = contractMoney;
    }

    public Double getPaymentRatio() {
        return paymentRatio;
    }

    public void setPaymentRatio(Double paymentRatio) {
        this.paymentRatio = paymentRatio;
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

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
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

    public Boolean getCostDepartApproval() {
        return costDepartApproval;
    }

    public void setCostDepartApproval(Boolean costDepartApproval) {
        this.costDepartApproval = costDepartApproval;
    }

    public Long getCostDepartUser() {
        return costDepartUser;
    }

    public void setCostDepartUser(Long costDepartUser) {
        this.costDepartUser = costDepartUser;
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCostDepartDate() {
        return costDepartDate;
    }

    public void setCostDepartDate(Date costDepartDate) {
        this.costDepartDate = costDepartDate;
    }

    public String getCostDepartOpinion() {
        return costDepartOpinion;
    }

    public void setCostDepartOpinion(String costDepartOpinion) {
        this.costDepartOpinion = costDepartOpinion == null ? null : costDepartOpinion.trim();
    }

    public Boolean getProjectDepartApproval() {
        return projectDepartApproval;
    }

    public void setProjectDepartApproval(Boolean projectDepartApproval) {
        this.projectDepartApproval = projectDepartApproval;
    }

    public Long getProjectDepartUser() {
        return projectDepartUser;
    }

    public void setProjectDepartUser(Long projectDepartUser) {
        this.projectDepartUser = projectDepartUser;
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getProjectDepartDate() {
        return projectDepartDate;
    }

    public void setProjectDepartDate(Date projectDepartDate) {
        this.projectDepartDate = projectDepartDate;
    }

    public String getProjectDepartOpinion() {
        return projectDepartOpinion;
    }

    public void setProjectDepartOpinion(String projectDepartOpinion) {
        this.projectDepartOpinion = projectDepartOpinion == null ? null : projectDepartOpinion.trim();
    }

    public Boolean getManagerDepartApproval() {
        return managerDepartApproval;
    }

    public void setManagerDepartApproval(Boolean managerDepartApproval) {
        this.managerDepartApproval = managerDepartApproval;
    }

    public Long getManagerDepartUser() {
        return managerDepartUser;
    }

    public void setManagerDepartUser(Long managerDepartUser) {
        this.managerDepartUser = managerDepartUser;
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getManagerDepartDate() {
        return managerDepartDate;
    }

    public void setManagerDepartDate(Date managerDepartDate) {
        this.managerDepartDate = managerDepartDate;
    }

    public String getManagerDepartOpinion() {
        return managerDepartOpinion;
    }

    public void setManagerDepartOpinion(String managerDepartOpinion) {
        this.managerDepartOpinion = managerDepartOpinion == null ? null : managerDepartOpinion.trim();
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }
}