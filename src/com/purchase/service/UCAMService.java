package com.purchase.service;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizUncontractApplyMoney;
import com.purchase.pojo.order.BizUncontractApplyMoneyDetail;
import com.purchase.util.ResultUtil;
import com.purchase.vo.order.UCAMOrderDetialVo;
import com.purchase.vo.order.UCAMSearch;
import com.purchase.vo.order.UCAMVo;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/24 21:16
 * @Description: 合同外请款单service接口
 */
public interface UCAMService {

    ResultUtil getUCAMOrderList(Integer page, Integer limit, UCAMSearch search);

    ResultUtil saveUCAMOrder(BizUncontractApplyMoney order);

    UCAMVo selUCAMOrder(String id);

    ResultUtil selUCAMOrderByOrder(String orderNo);

    ResultUtil delUCAMOrder(String id);

    ResultUtil submitUCAMOrder(String id);

    /*ResultUtil reviewUCAMOrder(TbAdmin admin, String id);*/

    UCAMOrderDetialVo selUCAMDetail(String id, Long adminId);

    ResultUtil addUCAMOrderDetail(BizUncontractApplyMoneyDetail ucamDetail);

    ResultUtil deleteUCAMItem(String id);

    ResultUtil submitReviewUCAMOrder(TbAdmin admin, String id, Long userId);

    ResultUtil reviewUCAMOrder(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion);
}
