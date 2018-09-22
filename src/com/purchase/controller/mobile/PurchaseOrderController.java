package com.purchase.controller.mobile;

import com.purchase.annotation.SysLog;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizPurchaseOrder;
import com.purchase.pojo.order.BizPurchaseOrderDetail;
import com.purchase.service.PurchaseOrderService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.order.BizPurchaseOrderDetailsVo;
import com.purchase.vo.order.BizPurchaseOrderSearch;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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


    @RequestMapping("list")
    @RequiresPermissions("mobile:purchase:list")
    public String list(){
        return "page/mobile/purchaseOrder/list";
    }

    @RequestMapping("getPurchaseList")
    @RequiresPermissions("mobile:purchase:list")
    @ResponseBody
    public ResultUtil getOrderList(Integer page, Integer limit, BizPurchaseOrderSearch search){
        return purchaseOrderService.getOrderList(page,limit,search);
    }

    @RequestMapping("/toDetails/{purchaseNo}")
    @RequiresPermissions("mobile:purchase:details")
    public String toDetails(@PathVariable("purchaseNo") String purchaseNo, Model model){
        BizPurchaseOrderDetailsVo detailsVo = purchaseOrderService.selPurchaseOrder(purchaseNo);
        model.addAttribute("detailsVo",detailsVo);
        return "page/mobile/purchaseOrder/details";
    }


    @RequestMapping("/toSave")
    @RequiresPermissions("mobile:purchase:save")
    public String toSave(Long id, Model model){
        return "page/mobile/purchaseOrder/from";
    }

    @SysLog(value="新增采购单")
    @RequestMapping("addPurchaseOrder")
    @RequiresPermissions("mobile:purchase:save")
    @ResponseBody
    public ResultUtil addPurchaseOrder(BizPurchaseOrder order){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        order.setCreateUser(admin.getId());
        return purchaseOrderService.addPurchaseOrder(order);
    }

    @SysLog(value="编辑采购单")
    @RequestMapping("editPurchaseOrder")
    @RequiresPermissions("mobile:purchase:edit")
    @ResponseBody
    public ResultUtil editPurchaseOrder(BizPurchaseOrder order){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        order.setCreateUser(admin.getId());
        return purchaseOrderService.editPurchaseOrder(order);
    }

    @SysLog(value="删除采购单")
    @RequestMapping("delPurchaseOrder")
    @RequiresPermissions("mobile:purchase:delete")
    @ResponseBody
    public ResultUtil delPurchaseOrder(String id){
        return purchaseOrderService.delPurchaseOrder(id);
    }


    @SysLog(value="提交采购单")
    @RequestMapping("submitPurchaseOrder")
    @RequiresPermissions("mobile:purchase:save")
    @ResponseBody
    public ResultUtil submitPurchaseOrder(String id){
        return purchaseOrderService.submitPurchaseOrder(id);
    }


    @SysLog(value="提交审核")
    @RequestMapping("submitReviewPurchaseOrder")
    @RequiresPermissions("mobile:purchase:save")
    @ResponseBody
    public ResultUtil submitReviewPurchaseOrder(String id, Long userId){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        return purchaseOrderService.submitReviewPurchaseOrder(admin, id, userId);
    }

    @SysLog(value="审核采购单")
    @RequestMapping("reviewPurchaseOrder/{id}")
    @RequiresPermissions("mobile:purchase:review")
    @ResponseBody
    public ResultUtil reviewPurchaseOrder(@PathVariable("id") String id, Boolean auditResults, Long applyUser, String auditOpinion){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        return purchaseOrderService.reviewPurchaseOrder(admin, id, auditResults,applyUser,auditOpinion);
    }

//    @SysLog(value="工程部审核采购单")
//    @RequestMapping("projectReviewPurchaseOrder")
//    @RequiresPermissions("mobile:purchase:projectReview")
//    @ResponseBody
//    public ResultUtil projectReviewPurchaseOrder(String id){
//        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
//        return purchaseOrderService.reviewPurchaseOrder(admin, id);
//    }
//
//
//    @SysLog(value="总经理审核采购单")
//    @RequestMapping("managerReviewPurchaseOrder")
//    @RequiresPermissions("mobile:purchase:managerReview")
//    @ResponseBody
//    public ResultUtil managerReviewPurchaseOrder(String id){
//        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
//        return purchaseOrderService.reviewPurchaseOrder(admin, id);
//    }

    @SysLog(value="新增采购单项")
    @RequestMapping("addPurchaseOrderItem/{purchaseNo}")
    @RequiresPermissions("mobile:purchase:save")
    @ResponseBody
    public ResultUtil addPurchaseOrderItem(@PathVariable("purchaseNo") String purchaseNo, BizPurchaseOrderDetail order){
        Date date = new Date();
        order.setUpdateDate(date);
        order.setCreateTime(date);
        order.setPurchaseNo(purchaseNo);
        return purchaseOrderService.addPurchaseOrderItem(order);
    }

    @SysLog(value="删除采购单项")
    @RequestMapping("deletePurchaseOrderItem/{itemId}")
    @RequiresPermissions("mobile:purchase:save")
    @ResponseBody
    public ResultUtil deletePurchaseOrderItem(@PathVariable("itemId") String itemId){
        return purchaseOrderService.deletePurchaseOrderItem(itemId);
    }

}
