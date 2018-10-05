package com.purchase.vo.order;

import com.purchase.pojo.order.BizContractApplyMoneyDetail;
import com.purchase.util.OrderTypeEnum;

import java.util.List;

/**
 * Created by xuqiang
 * 2018/9/27.
 */
public class CAMDetailsVo {

    private CAMVo order;

    private List<BizContractApplyMoneyDetail> details;

    private Long reviewUserId;

    private String departs;

    public CAMVo getOrder() {
        return order;
    }

    public void setOrder(CAMVo order) {
        this.order = order;
    }

    public List<BizContractApplyMoneyDetail> getDetails() {
        return details;
    }

    public void setDetails(List<BizContractApplyMoneyDetail> details) {
        this.details = details;
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

    public String getOrderType() {
        return OrderTypeEnum.getVisitorByCode(order.getOrderType()).getName();
    }
}
