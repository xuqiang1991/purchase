package com.purchase.vo.Search;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Title: BizOrderDetailSearch
 * @ProjectName purchase
 * @Description: TODO
 * @author zhoujb
 * @date 2019-03-0721:46
 */
public class BizOrderDetailSearch {
    private String id;

    private String orderId;

    private String content;

    private String model;

    private String unit;

    private BigDecimal price;

    private Double amount;

    private BigDecimal totalPrice;

    private Double settleAmout;

    private String remark;

    private Date createTime;

    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getSettleAmout() {
        return settleAmout;
    }

    public void setSettleAmout(Double settleAmout) {
        this.settleAmout = settleAmout;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
