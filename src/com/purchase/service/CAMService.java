package com.purchase.service;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizContractApplyMoney;
import com.purchase.util.ResultUtil;
import com.purchase.vo.order.CAMSearch;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/24 21:16
 * @Description:
 */
public interface CAMService {

    ResultUtil getCAMOrderList(Integer page, Integer limit, CAMSearch search);

    ResultUtil addCAMOrder(BizContractApplyMoney order);

    ResultUtil editCAMOrder(BizContractApplyMoney order);

    ResultUtil selCAMOrder(String orderNo);

    ResultUtil delCAMOrder(String id);

    ResultUtil submitCAMOrder(String id);

    ResultUtil reviewCAMOrder(TbAdmin admin, String id);
}
