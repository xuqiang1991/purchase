package com.purchase.vo.order;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by xuqiang
 * 2018/9/07.
 */
public class BizPaymentOrderSearch {

    private Long loginId;
    private String id;
    private String orderNo;
    private Integer orderType;
    private Long supplierId;
    private String projectId;
    private Long createUser;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;
    private Integer status;
    private String createUserName;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startCreateTime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endCreateTime;
    private Long departUser;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date departDate;
    private String contractNo;
    private List<String> reviewRoles;

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Long getDepartUser() {
        return departUser;
    }

    public void setDepartUser(Long departUser) {
        this.departUser = departUser;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
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
        this.projectId = projectId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
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

    public List<String> getReviewRoles() {
        return reviewRoles;
    }

    public void setReviewRoles(List<String> reviewRoles) {
        this.reviewRoles = reviewRoles;
    }
}
