package com.purchase.pojo.order;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class BizContractApplyMoneyDetail {
    private String id;

    private String orderNo;

    private String purchaseDetailId;

    private String constructionSite;

    private String projectContent;

    private String model;

    private String unit;

    private BigDecimal price;

    private Double contractCount;

    private Double settleAmout;

    private BigDecimal settlePrice;

    private Float warrantyDate;

    @DateTimeFormat(pattern="yyyy-MM-dd")
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

    public String getPurchaseDetailId() {
        return purchaseDetailId;
    }

    public void setPurchaseDetailId(String purchaseDetailId) {
        this.purchaseDetailId = purchaseDetailId == null ? null : purchaseDetailId.trim();
    }

    public String getConstructionSite() {
        return constructionSite;
    }

    public void setConstructionSite(String constructionSite) {
        this.constructionSite = constructionSite == null ? null : constructionSite.trim();
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent == null ? null : projectContent.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
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

    public Double getContractCount() {
        return contractCount;
    }

    public void setContractCount(Double contractCount) {
        this.contractCount = contractCount;
    }

    public Double getSettleAmout() {
        return settleAmout;
    }

    public void setSettleAmout(Double settleAmout) {
        this.settleAmout = settleAmout;
    }

    public BigDecimal getSettlePrice() {
        return settlePrice;
    }

    public void setSettlePrice(BigDecimal settlePrice) {
        this.settlePrice = settlePrice;
    }

    public Float getWarrantyDate() {
        return warrantyDate;
    }

    public void setWarrantyDate(Float warrantyDate) {
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