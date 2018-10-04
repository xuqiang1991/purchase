package com.purchase.pojo.order;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class BizUncontractApplyMoney {
    private String id;

    private String orderNo;

    private Long createUser;

    private Date createTime;

    private Long applyUser;

    private String projectId;

    private String orderType;

    private Integer instructOrderFlag;

    private String instructOrderNo;

    private Integer status;

    private BigDecimal applyPrice;

    private BigDecimal actualPrice;

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

    private Long supplierId;

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

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
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

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}