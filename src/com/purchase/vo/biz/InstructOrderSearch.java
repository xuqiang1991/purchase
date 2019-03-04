package com.purchase.vo.biz;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Title: InstructOrderService
 * @ProjectName purchase
 * @Description: 指令单查询参数类
 * @author zhoujb
 * @date 2019-03-0411:37
 */
public class InstructOrderSearch {

    private String id;

    private String pmId;

    private String instructNo;

    private Integer instructType;

    private String instructCentext;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date commandDate;

    private String commandUserName;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createDate;

    private String createUser;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date editDate;

    private String editUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPmId() {
        return pmId;
    }

    public void setPmId(String pmId) {
        this.pmId = pmId;
    }

    public String getInstructNo() {
        return instructNo;
    }

    public void setInstructNo(String instructNo) {
        this.instructNo = instructNo;
    }

    public Integer getInstructType() {
        return instructType;
    }

    public void setInstructType(Integer instructType) {
        this.instructType = instructType;
    }

    public String getInstructCentext() {
        return instructCentext;
    }

    public void setInstructCentext(String instructCentext) {
        this.instructCentext = instructCentext;
    }

    public Date getCommandDate() {
        return commandDate;
    }

    public void setCommandDate(Date commandDate) {
        this.commandDate = commandDate;
    }

    public String getCommandUserName() {
        return commandUserName;
    }

    public void setCommandUserName(String commandUserName) {
        this.commandUserName = commandUserName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public String getEditUser() {
        return editUser;
    }

    public void setEditUser(String editUser) {
        this.editUser = editUser;
    }
}
