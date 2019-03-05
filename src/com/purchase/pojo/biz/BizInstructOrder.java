package com.purchase.pojo.biz;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BizInstructOrder {
    private String id;

    private String pmId;

    private String instructNo;

    private Integer instructType;

    private String instructCentext;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date commandDate;

    private String commandUserName;

    private Date createDate;

    private Long createUser;

    private Date editDate;

    private Long editUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPmId() {
        return pmId;
    }

    public void setPmId(String pmId) {
        this.pmId = pmId == null ? null : pmId.trim();
    }

    public String getInstructNo() {
        return instructNo;
    }

    public void setInstructNo(String instructNo) {
        this.instructNo = instructNo == null ? null : instructNo.trim();
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
        this.instructCentext = instructCentext == null ? null : instructCentext.trim();
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
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
        this.commandUserName = commandUserName == null ? null : commandUserName.trim();
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public Long getEditUser() {
        return editUser;
    }

    public void setEditUser(Long editUser) {
        this.editUser = editUser;
    }
}