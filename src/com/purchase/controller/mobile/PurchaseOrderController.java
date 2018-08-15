package com.purchase.controller.mobile;

import com.purchase.pojo.order.TbPurchaseOrder;
import com.purchase.service.PurchaseOrderService;
import com.purchase.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xuqiang
 * 2018/8/15.
 */
@Controller
@RequestMapping("mobile/order")
public class PurchaseOrderController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @RequestMapping("getOrderList")
    @RequiresPermissions("mobile:order:list")
    @ResponseBody
    public ResultUtil getOrderList(Integer page, Integer limit, TbPurchaseOrder order){
        return purchaseOrderService.getOrderList(page,limit,order);
    }


}
