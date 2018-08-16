package com.purchase.controller.mobile;

import com.purchase.pojo.order.BizPurchaseOrder;
import com.purchase.service.PurchaseOrderService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.order.BizPurchaseOrderSearch;
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
@RequestMapping("mobile/purchase")
public class PurchaseOrderController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @RequestMapping("getPurchaseList")
    @RequiresPermissions("mobile:purchase:list")
    @ResponseBody
    public ResultUtil getOrderList(Integer page, Integer limit, BizPurchaseOrderSearch search){
        return purchaseOrderService.getOrderList(page,limit,search);
    }

    @RequestMapping("selPurchaseOrder")
    @RequiresPermissions("mobile:purchase:sel")
    @ResponseBody
    public ResultUtil selPurchaseOrder(String purchaseNo){
        return purchaseOrderService.selPurchaseOrder(purchaseNo);
    }


    @RequestMapping("addPurchaseOrder")
    @RequiresPermissions("mobile:purchase:add")
    @ResponseBody
    public ResultUtil addPurchaseOrder(BizPurchaseOrder order){
        return purchaseOrderService.addPurchaseOrder(order);
    }

    @RequestMapping("editPurchaseOrder")
    @RequiresPermissions("mobile:purchase:edit")
    @ResponseBody
    public ResultUtil editPurchaseOrder(BizPurchaseOrder order){
        return purchaseOrderService.editPurchaseOrder(order);
    }



}
