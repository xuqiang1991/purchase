package com.purchase.vo.order;

import com.purchase.pojo.order.BizProgrammeAcceptanceOrderDetail;

import java.util.List;

/**
 * @Auther: zhoujb
 * @Date: 2018/9/29 11:21
 * @Description:
 */
public class PaoOrderDetialVo {

    private PaoVo paoVo;

    private List<BizProgrammeAcceptanceOrderDetail> paoDetail;

    private Long reviewUserId;

    private String departs;

    public PaoVo getPaoVo() {
        return paoVo;
    }

    public void setPaoVo(PaoVo paoVo) {
        this.paoVo = paoVo;
    }

    public List<BizProgrammeAcceptanceOrderDetail> getPaoDetail() {
        return paoDetail;
    }

    public void setPaoDetail(List<BizProgrammeAcceptanceOrderDetail> paoDetail) {
        this.paoDetail = paoDetail;
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
