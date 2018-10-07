package com.purchase.service;

import com.purchase.pojo.order.BizBiddingManagement;
import com.purchase.pojo.order.BizUncontractApplyMoney;
import com.purchase.util.ResultUtil;
import com.purchase.vo.order.BiddingManagementSearch;
import com.purchase.vo.order.BiddingManagementVo;

public interface BiddingManagementService {

    ResultUtil getBiddingManagementOrderList(Integer page, Integer limit, BiddingManagementSearch search);

    ResultUtil saveBiddingManagementOrder(BizBiddingManagement order);

    BiddingManagementVo selBiddingManagementOrder(String id);

    ResultUtil selBiddingManagementOrderByOrder(String orderNo);

    ResultUtil delBiddingManagementOrder(String id);

}
