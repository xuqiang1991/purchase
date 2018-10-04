package com.purchase.pojo.order;

import java.math.BigDecimal;
import java.util.Date;

public class BizUncontractApplyMoneyDetail {
    private String id;

    private String orderNo;

    private String projectContent;

    private Double quantities;

    private Double applyCompletionRate;

    private Double approvalCompletionRate;

    private String unit;

    private BigDecimal price;

    private BigDecimal applyPrice;

    private BigDecimal approvalPrice;

    private BigDecimal warrantyDate;

    private Date date;

    private String remark;

    private Date createTime;

    private Date updateDate;

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

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent == null ? null : projectContent.trim();
    }

    public Double getQuantities() {
        return quantities;
    }

    public void setQuantities(Double quantities) {
        this.quantities = quantities;
    }

    public Double getApplyCompletionRate() {
        return applyCompletionRate;
    }

    public void setApplyCompletionRate(Double applyCompletionRate) {
        this.applyCompletionRate = applyCompletionRate;
    }

    public Double getApprovalCompletionRate() {
        return approvalCompletionRate;
    }

    public void setApprovalCompletionRate(Double approvalCompletionRate) {
        this.approvalCompletionRate = approvalCompletionRate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public BigDecimal getWarrantyDate() {
        return warrantyDate;
    }

    public void setWarrantyDate(BigDecimal warrantyDate) {
        this.warrantyDate = warrantyDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}