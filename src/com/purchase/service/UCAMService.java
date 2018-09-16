package com.purchase.service;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizContractApplyMoney;
import com.purchase.pojo.order.BizUncontractApplyMoney;
import com.purchase.util.ResultUtil;
import com.purchase.vo.order.UCAMSearch;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/24 21:16
 * @Description: 合同外请款单service接口
 */
public interface UCAMService {

    ResultUtil getUCAMOrderList(Integer page, Integer limit, UCAMSearch search);

    ResultUtil addUCAMOrder(BizUncontractApplyMoney order);

    ResultUtil editUCAMOrder(BizUncontractApplyMoney order);

    ResultUtil selUCAMOrder(String orderNo);

    ResultUtil delUCAMOrder(String id);

    ResultUtil submitUCAMOrder(String id);

    ResultUtil reviewUCAMOrder(TbAdmin admin, String id);
}
