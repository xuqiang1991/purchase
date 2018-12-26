package com.purchase.vo.order;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by xuqiang
 * 2018/8/16.
 */
public class BizPurchaseOrderSearch{

    private String id;
    private Long loginId;
    private String purchaseNo;
    private Integer type;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
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

    public String getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(String purchaseNo) {
        this.purchaseNo = purchaseNo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
}
