package com.purchase.vo.admin;

public class AdminSearch {


    private String username;

    private String fullname;

    private Long deptId;

    private Long supplierId;

    private String keyWord;

    private Integer isOnJob;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getIsOnJob() {
        return isOnJob;
    }

    public void setIsOnJob(Integer isOnJob) {
        this.isOnJob = isOnJob;
    }
}
