package com.purchase.vo.order;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/24 21:01
 * @Description:投标管理查询条件字段
 */
public class BiddingManagementSearch {
    private String id;

    /*单号、发展商、所属项目、城市、开单人、开单日期（开始、结束）、开标信息、投标原因*/
    private String orderNo;
    private Long supplierId;
    private String projectName;
    private Long areaId;
    private Long createUser;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startCreateTime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endCreateTime;
    private Integer openBidInfo;
    private Integer bidCause;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getStartCreateTime() {
        return startCreateTime;
    }

    public void setStartCreateTime(Date startCreateTime) {
        this.startCreateTime = startCreateTime;
    }

    public Date getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(Date endCreateTime) {
        this.endCreateTime = endCreateTime;
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
}
