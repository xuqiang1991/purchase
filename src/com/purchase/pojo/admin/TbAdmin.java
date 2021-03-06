package com.purchase.pojo.admin;

import java.io.Serializable;
import java.util.List;

public class TbAdmin implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String salt;

    private String fullname;

    private String eMail;

    private String sex;

    private String birthday;

    private String address;

    private String phone;

    private String roleName;

    private String quarters;

    private String deptId;

    private String entryDate;

    private Integer isOnJob;

    private String remark;

    private String openId;

    private String wxNick;

    private Long supplierId;

    private String deptName;

    private String supplierName;

    private Integer userType;

    private Integer isAmountVisible;

    private List<Long> roleId;

    private List<String> roleNames;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
    
    public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public List<Long> getRoleId() {
        return roleId;
    }

    public void setRoleId(List<Long> roleId) {
        this.roleId = roleId;
    }

    public String getQuarters() {
        return quarters;
    }

    public String getDeptId() {
        return deptId;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public Integer getIsOnJob() {
        return isOnJob;
    }

    public String getRemark() {
        return remark;
    }

    public void setQuarters(String quarters) {
        this.quarters = quarters;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public void setIsOnJob(Integer isOnJob) {
        this.isOnJob = isOnJob;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getWxNick() {
        return wxNick;
    }

    public void setWxNick(String wxNick) {
        this.wxNick = wxNick;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getIsAmountVisible() {
        return isAmountVisible;
    }

    public void setIsAmountVisible(Integer isAmountVisible) {
        this.isAmountVisible = isAmountVisible;
    }

    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }

    @Override
	public String toString() {
		return "TbAdmin [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt
				+ ", fullname=" + fullname + ", eMail=" + eMail + ", sex=" + sex + ", birthday=" + birthday
				+ ", address=" + address + ", phone=" + phone + ", roleId=" + roleId + ", roleName=" + roleName  + ", quarters=" + quarters
                + ", deptId=" + deptId  + ", entryDate=" + entryDate + ", isOnJob=" + isOnJob  + ", openId=" + openId + ", wxNick=" + wxNick + ", remark=" + remark + "]";
	}
    
}