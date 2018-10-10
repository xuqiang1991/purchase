package com.purchase.service;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizContractApplyMoney;
import com.purchase.pojo.order.BizPaymentOrder;
import com.purchase.pojo.order.BizUncontractApplyMoney;
import com.purchase.util.ResultUtil;
import com.purchase.vo.order.BizPaymentOrderSearch;
import com.purchase.vo.order.BizPaymentOrderVo;

/**
 * @Auther: xuqiang
 * @Date: 2018/10/7
 * @Description:工程验收service接口
 */
public interface PaymentOrderService {

    ResultUtil getOrderList(Integer page, Integer limit, BizPaymentOrderSearch search);

    BizPaymentOrderVo getPaymentOrderDetails(String id, TbAdmin admin);


    ResultUtil editPaymentOrder(BizPaymentOrder order);

    ResultUtil reviewOrder(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion);

    void generatePaymenyOrder(BizContractApplyMoney order);

    void generatePaymenyOrder(BizUncontractApplyMoney order);
}
