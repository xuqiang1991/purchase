package com.purchase.vo.order;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/24 21:01
 * @Description:工程验收查询条件字段
 */
public class ProgrammeAcceptanceSearch {

    private String id;
    /*单号、供应商、所属项目、合同号、开单人、开单日期、单据状态*/
    private String orderNo;
    private Long supplierId;
    private String projectId;
    private Long createUser;
    private String createTime;
    private Integer status;

    public ProgrammeAcceptanceSearch() {
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
