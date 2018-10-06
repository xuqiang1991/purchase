package com.purchase.vo;

import java.util.Date;

/**
 * @Auther: zhoujb
 * @Date: 2018/10/5 15:58
 * @Description:
 */
public class OrderHistory {

    private String name;
    private Date date;
    private String opinion;
    private Boolean approval;
    private int sort;

    public OrderHistory(String name, Date date, String opinion, Boolean approval, int sort) {
        this.name = name;
        this.date = date;
        this.opinion = opinion;
        this.approval = approval;
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Boolean getApproval() {
        return approval;
    }

    public void setApproval(Boolean approval) {
        this.approval = approval;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
