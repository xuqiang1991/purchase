package com.purchase.pojo.order;

import java.math.BigDecimal;
import java.util.Date;

public class BizProgrammeAcceptanceOrder {
    private String id;

    private String orderNo;

    private Long createUser;

    private Date createTime;

    private Long applyUser;

    private Date applyDate;

    private Long supplierId;

    private String projectId;

    private Long contractId;

    private BigDecimal contractMoney;

    private BigDecimal applyTotalPrice;

    private BigDecimal paymentTotalPrice;

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

    public BigDecimal getApplyTotalPrice() {
        return applyTotalPrice;
    }

    public void setApplyTotalPrice(BigDecimal applyTotalPrice) {
        this.applyTotalPrice = applyTotalPrice;
    }

    public BigDecimal getPaymentTotalPrice() {
        return paymentTotalPrice;
    }

    public void setPaymentTotalPrice(BigDecimal paymentTotalPrice) {
        this.paymentTotalPrice = paymentTotalPrice;
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