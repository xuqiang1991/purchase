package com.purchase.pojo.order;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BizProgrammeAcceptanceOrderDetail {
    private String id;

    private String orderNo;

    private String rectifyContent;

    private String rectifyMeasure;

    private Date playOverDate;

    private Integer rectifyFlag;

    private Date actualOverDate;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getRectifyContent() {
        return rectifyContent;
    }

    public void setRectifyContent(String rectifyContent) {
        this.rectifyContent = rectifyContent == null ? null : rectifyContent.trim();
    }

    public String getRectifyMeasure() {
        return rectifyMeasure;
    }

    public void setRectifyMeasure(String rectifyMeasure) {
        this.rectifyMeasure = rectifyMeasure == null ? null : rectifyMeasure.trim();
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    public Date getPlayOverDate() {
        return playOverDate;
    }

    public void setPlayOverDate(Date playOverDate) {
        this.playOverDate = playOverDate;
    }

    public Integer getRectifyFlag() {
        return rectifyFlag;
    }

    public void setRectifyFlag(Integer rectifyFlag) {
        this.rectifyFlag = rectifyFlag;
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    public Date getActualOverDate() {
        return actualOverDate;
    }

    public void setActualOverDate(Date actualOverDate) {
        this.actualOverDate = actualOverDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}