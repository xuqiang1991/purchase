package com.purchase.vo.order;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/24 21:01
 * @Description:合同内请款单查询条件字段
 */
public class UCAMSearch {

    private String id;
    /*单号、单据类型、供应商、所属项目、有无指令、指令单号、请款人、开单人、开单日期、单据状态*/
    private String orderNo;
    private String orderType;
    private Long supplierId;
    private String projectId;
    private Integer instructOrderFlag;
    private String instructOrderNo;
    private Long applyUser;
    private Long createUser;
    private String createTime;
    private Integer status;

    public UCAMSearch() {
    }

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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
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
        this.instructOrderNo = instructOrderNo;
    }

    public Long getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(Long applyUser) {
        this.applyUser = applyUser;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
