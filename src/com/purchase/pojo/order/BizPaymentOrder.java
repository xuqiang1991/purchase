package com.purchase.pojo.order;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class BizPaymentOrder {
    private String id;

    private String orderNo;

    private String purchaseNo;

    private String contractOrderNo;

    private Integer applyType;

    private Integer applyNature;

    private Long createUser;

    private Date createTime;

    private Long supplierId;

    private Long applyUser;

    private String applyUserPhone;

    private String projectId;

    private String contractId;

    private BigDecimal applyPrice;

    private BigDecimal approvalPrice;

    private BigDecimal guaranteePrice;

    private BigDecimal advancePrice;

    private BigDecimal otherPrice;

    private BigDecimal actualPrice;

    private Integer paymentType;

    private Integer spqxTerm;

    private Integer blqxTerm;

    private String paymentVoucherNo;

    private Double advanceRate;

    private Double costRate;

    private Double financialRate;

    private Double taxRate;

    private Double contractVolume;

    private Double finishMeasure;

    private Double amountPaid;

    private Double paidProportion;

    private Double paymentProportion;

    private Integer invoiceType;

    private Double specialTaxRate;

    private Integer qualityGrade;

    private Long qualityAssessor;

    private Integer status;

    private String summary;

    private Boolean managerDepartApproval;

    private Long managerDepartUser;

    private Date managerDepartDate;

    private String managerDepartOpinion;

    private Boolean financePaymentApproval;

    private Long financePaymentUser;

    private Date financePaymentDate;

    private String financePaymentOpinion;

    private Boolean reviewFail;

    private String reviewOpinion;

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

    public String getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(String purchaseNo) {
        this.purchaseNo = purchaseNo == null ? null : purchaseNo.trim();
    }

    public String getContractOrderNo() {
        return contractOrderNo;
    }

    public void setContractOrderNo(String contractOrderNo) {
        this.contractOrderNo = contractOrderNo == null ? null : contractOrderNo.trim();
    }

    public Integer getApplyType() {
        return applyType;
    }

    public void setApplyType(Integer applyType) {
        this.applyType = applyType;
    }

    public Integer getApplyNature() {
        return applyNature;
    }

    public void setApplyNature(Integer applyNature) {
        this.applyNature = applyNature;
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
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

    public Long getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(Long applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyUserPhone() {
        return applyUserPhone;
    }

    public void setApplyUserPhone(String applyUserPhone) {
        this.applyUserPhone = applyUserPhone == null ? null : applyUserPhone.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public BigDecimal getApplyPrice() {
        return applyPrice;
    }

    public void setApplyPrice(BigDecimal applyPrice) {
        this.applyPrice = applyPrice;
    }

    public BigDecimal getApprovalPrice() {
        return approvalPrice;
    }

    public void setApprovalPrice(BigDecimal approvalPrice) {
        this.approvalPrice = approvalPrice;
    }

    public BigDecimal getGuaranteePrice() {
        return guaranteePrice;
    }

    public void setGuaranteePrice(BigDecimal guaranteePrice) {
        this.guaranteePrice = guaranteePrice;
    }

    public BigDecimal getAdvancePrice() {
        return advancePrice;
    }

    public void setAdvancePrice(BigDecimal advancePrice) {
        this.advancePrice = advancePrice;
    }

    public BigDecimal getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(BigDecimal otherPrice) {
        this.otherPrice = otherPrice;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getSpqxTerm() {
        return spqxTerm;
    }

    public void setSpqxTerm(Integer spqxTerm) {
        this.spqxTerm = spqxTerm;
    }

    public Integer getBlqxTerm() {
        return blqxTerm;
    }

    public void setBlqxTerm(Integer blqxTerm) {
        this.blqxTerm = blqxTerm;
    }

    public String getPaymentVoucherNo() {
        return paymentVoucherNo;
    }

    public void setPaymentVoucherNo(String paymentVoucherNo) {
        this.paymentVoucherNo = paymentVoucherNo == null ? null : paymentVoucherNo.trim();
    }

    public Double getAdvanceRate() {
        return advanceRate;
    }

    public void setAdvanceRate(Double advanceRate) {
        this.advanceRate = advanceRate;
    }

    public Double getCostRate() {
        return costRate;
    }

    public void setCostRate(Double costRate) {
        this.costRate = costRate;
    }

    public Double getFinancialRate() {
        return financialRate;
    }

    public void setFinancialRate(Double financialRate) {
        this.financialRate = financialRate;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Double getContractVolume() {
        return contractVolume;
    }

    public void setContractVolume(Double contractVolume) {
        this.contractVolume = contractVolume;
    }

    public Double getFinishMeasure() {
        return finishMeasure;
    }

    public void setFinishMeasure(Double finishMeasure) {
        this.finishMeasure = finishMeasure;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Double getPaidProportion() {
        return paidProportion;
    }

    public void setPaidProportion(Double paidProportion) {
        this.paidProportion = paidProportion;
    }

    public Double getPaymentProportion() {
        return paymentProportion;
    }

    public void setPaymentProportion(Double paymentProportion) {
        this.paymentProportion = paymentProportion;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Double getSpecialTaxRate() {
        return specialTaxRate;
    }

    public void setSpecialTaxRate(Double specialTaxRate) {
        this.specialTaxRate = specialTaxRate;
    }

    public Integer getQualityGrade() {
        return qualityGrade;
    }

    public void setQualityGrade(Integer qualityGrade) {
        this.qualityGrade = qualityGrade;
    }

    public Long getQualityAssessor() {
        return qualityAssessor;
    }

    public void setQualityAssessor(Long qualityAssessor) {
        this.qualityAssessor = qualityAssessor;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
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

    public Boolean getFinancePaymentApproval() {
        return financePaymentApproval;
    }

    public void setFinancePaymentApproval(Boolean financePaymentApproval) {
        this.financePaymentApproval = financePaymentApproval;
    }

    public Long getFinancePaymentUser() {
        return financePaymentUser;
    }

    public void setFinancePaymentUser(Long financePaymentUser) {
        this.financePaymentUser = financePaymentUser;
    }

    public Date getFinancePaymentDate() {
        return financePaymentDate;
    }

    public void setFinancePaymentDate(Date financePaymentDate) {
        this.financePaymentDate = financePaymentDate;
    }

    public String getFinancePaymentOpinion() {
        return financePaymentOpinion;
    }

    public void setFinancePaymentOpinion(String financePaymentOpinion) {
        this.financePaymentOpinion = financePaymentOpinion == null ? null : financePaymentOpinion.trim();
    }

    public Boolean getReviewFail() {
        return reviewFail;
    }

    public void setReviewFail(Boolean reviewFail) {
        this.reviewFail = reviewFail;
    }

    public String getReviewOpinion() {
        return reviewOpinion;
    }

    public void setReviewOpinion(String reviewOpinion) {
        this.reviewOpinion = reviewOpinion == null ? null : reviewOpinion.trim();
    }
}