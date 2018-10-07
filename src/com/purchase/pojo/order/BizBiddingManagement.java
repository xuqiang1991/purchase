package com.purchase.pojo.order;

import java.math.BigDecimal;
import java.util.Date;

public class BizBiddingManagement {
    private String id;

    private String orderNo;

    private Long createUser;

    private Date createTime;

    private Long bidUser;

    private Long areaId;

    private String projectName;

    private Long customersId;

    private Double projectAcreage;

    private BigDecimal projectPriceBudge;

    private BigDecimal finalBid;

    private Date estimateStartTime;

    private Date bidMarkTime;

    private Integer openBidInfo;

    private Integer bidCause;

    private String remark;

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

    public Long getBidUser() {
        return bidUser;
    }

    public void setBidUser(Long bidUser) {
        this.bidUser = bidUser;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Long getCustomersId() {
        return customersId;
    }

    public void setCustomersId(Long customersId) {
        this.customersId = customersId;
    }

    public Double getProjectAcreage() {
        return projectAcreage;
    }

    public void setProjectAcreage(Double projectAcreage) {
        this.projectAcreage = projectAcreage;
    }

    public BigDecimal getProjectPriceBudge() {
        return projectPriceBudge;
    }

    public void setProjectPriceBudge(BigDecimal projectPriceBudge) {
        this.projectPriceBudge = projectPriceBudge;
    }

    public BigDecimal getFinalBid() {
        return finalBid;
    }

    public void setFinalBid(BigDecimal finalBid) {
        this.finalBid = finalBid;
    }

    public Date getEstimateStartTime() {
        return estimateStartTime;
    }

    public void setEstimateStartTime(Date estimateStartTime) {
        this.estimateStartTime = estimateStartTime;
    }

    public Date getBidMarkTime() {
        return bidMarkTime;
    }

    public void setBidMarkTime(Date bidMarkTime) {
        this.bidMarkTime = bidMarkTime;
    }

    public Integer getOpenBidInfo() {
        return openBidInfo;
    }

    public void setOpenBidInfo(Integer openBidInfo) {
        this.openBidInfo = openBidInfo;
    }

    public Integer getBidCause() {
        return bidCause;
    }

    public void setBidCause(Integer bidCause) {
        this.bidCause = bidCause;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}