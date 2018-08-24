package com.purchase.vo.admin;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/24 17:32
 * @Description:
 */
public class CustomersSearch {
    private String name;
    private Long areaId;
    private Integer isForce;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Integer getIsForce() {
        return isForce;
    }

    public void setIsForce(Integer isForce) {
        this.isForce = isForce;
    }
}
