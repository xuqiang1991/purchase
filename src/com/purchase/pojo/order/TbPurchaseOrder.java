package com.purchase.pojo.order;

import java.math.BigDecimal;
import java.util.Date;

public class TbPurchaseOrder {
    private String id;

    private String type;

    private Long createUser;

    private Date createTime;

    private Long supplierId;

    private Long projectId;

    private Long contractId;

    private BigDecimal contractMoney;

    private Double paymentRatio;

    private BigDecimal requestAmount;

    private BigDecimal paymentAmount;

    private String status;

    private String summary;

    private Boolean costDepartApproval;

    private String costDepartUser;

    private Date costDepartDate;

    private String costDepartOpinion;

    private Boolean projectDepartApproval;

    private String projectDepartUser;

    private Date projectDepartDate;

    private String projectDepartOpinion;

    private Boolean managerDepartApproval;

    private String managerDepartUser;

    private Date managerDepartDate;

    private String managerDepartOpinion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getCostDepartUser() {
        return costDepartUser;
    }

    public void setCostDepartUser(String costDepartUser) {
        this.costDepartUser = costDepartUser == null ? null : costDepartUser.trim();
    }

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

    public String getProjectDepartUser() {
        return projectDepartUser;
    }

    public void setProjectDepartUser(String projectDepartUser) {
        this.projectDepartUser = projectDepartUser == null ? null : projectDepartUser.trim();
    }

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

    public String getManagerDepartUser() {
        return managerDepartUser;
    }

    public void setManagerDepartUser(String managerDepartUser) {
        this.managerDepartUser = managerDepartUser == null ? null : managerDepartUser.trim();
    }

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
}