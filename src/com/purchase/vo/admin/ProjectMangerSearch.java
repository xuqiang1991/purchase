package com.purchase.vo.admin;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/24 17:32
 * @Description:
 */
public class ProjectMangerSearch {
    private String name;
    private Long projectManager;
    private String developer;
    private String consignor;
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Long projectManager) {
        this.projectManager = projectManager;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getConsignor() {
        return consignor;
    }

    public void setConsignor(String consignor) {
        this.consignor = consignor;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
