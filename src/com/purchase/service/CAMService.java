package com.purchase.service;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizContractApplyMoney;
import com.purchase.pojo.order.BizContractApplyMoneyDetail;
import com.purchase.util.ResultUtil;
import com.purchase.vo.order.CAMDetailsVo;
import com.purchase.vo.order.CAMSearch;
import com.purchase.vo.order.CAMVo;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/24 21:16
 * @Description:
 */
public interface CAMService {

    ResultUtil getCAMOrderList(Integer page, Integer limit, CAMSearch search);

    ResultUtil addCAMOrder(BizContractApplyMoney order);

    ResultUtil editCAMOrder(BizContractApplyMoney order);

    CAMDetailsVo selCAMOrder(String id);

    ResultUtil submitCAMOrder(String id);

    ResultUtil addCAMItem(BizContractApplyMoneyDetail order);

    ResultUtil editCAMItem(BizContractApplyMoneyDetail order);

    ResultUtil delCAMItem(String itemId);

    ResultUtil getCAMItem(String itemId);

    ResultUtil delCAM(String id);

    ResultUtil submitReviewCAMOrder(TbAdmin admin, String id, Long userId);

    ResultUtil reviewCAMOrder(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion);

    CAMVo getCAMOrder(String id);

    ResultUtil checkCAMItem(String purchaseDetailId);
}
