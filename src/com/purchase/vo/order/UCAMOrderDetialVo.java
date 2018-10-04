package com.purchase.vo.order;

import com.purchase.pojo.order.BizUncontractApplyMoneyDetail;

import java.util.List;

/**
 * @Auther: zhoujb
 * @Date: 2018/9/29 11:21
 * @Description:
 */
public class UCAMOrderDetialVo {

    private UCAMVo ucamVo;

    private List<BizUncontractApplyMoneyDetail> ucamDetail;

    private Long reviewUserId;

    private String departs;

    public UCAMVo getUcamVo() {
        return ucamVo;
    }

    public void setUcamVo(UCAMVo ucamVo) {
        this.ucamVo = ucamVo;
    }

    public List<BizUncontractApplyMoneyDetail> getUcamDetail() {
        return ucamDetail;
    }

    public void setUcamDetail(List<BizUncontractApplyMoneyDetail> ucamDetail) {
        this.ucamDetail = ucamDetail;
    }

    public Long getReviewUserId() {
        return reviewUserId;
    }

    public void setReviewUserId(Long reviewUserId) {
        this.reviewUserId = reviewUserId;
    }

    public String getDeparts() {
        return departs;
    }

    public void setDeparts(String departs) {
        this.departs = departs;
    }
}
