package com.purchase.controller.mobile;

import com.alibaba.fastjson.JSON;
import com.purchase.annotation.SysLog;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.order.BizPurchaseOrder;
import com.purchase.pojo.order.BizPurchaseOrderDetail;
import com.purchase.service.AdminService;
import com.purchase.service.ProjectMangerService;
import com.purchase.service.PurchaseOrderService;
import com.purchase.service.SupplierService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.ChoseAdminVO;
import com.purchase.vo.admin.ChoseDeptVO;
import com.purchase.vo.admin.ChoseProjectVO;
import com.purchase.vo.admin.ChoseSupplierVO;
import com.purchase.vo.order.BizPurchaseOrderDetailsVo;
import com.purchase.vo.order.BizPurchaseOrderSearch;
import com.purchase.vo.order.BizPurchaseOrderVo;
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

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private ProjectMangerService projectMangerService;

    @RequestMapping("list")
    @RequiresPermissions("mobile:purchase:list")
    public String list(HttpServletRequest req){
        List<ChoseAdminVO> admins = adminService.selectAdmin();
        List<ChoseSupplierVO> suppliers = supplierService.selectSupplier();
        List<ChoseDeptVO> depts = adminService.selectDeptAdmin();
        List<ChoseProjectVO> projects = projectMangerService.selectProjectManger();
        logger.info("------:{}", JSON.toJSONString(depts));
        req.setAttribute("admins", JSON.toJSONString(admins));
        req.setAttribute("suppliers", JSON.toJSONString(suppliers));
        req.setAttribute("depts", JSON.toJSONString(depts));
        req.setAttribute("projects", JSON.toJSONString(projects));
        return "page/mobile/purchaseOrder/list";
    }

    @RequestMapping("getPurchaseList")
    @RequiresPermissions("mobile:purchase:list")
    @ResponseBody
    public ResultUtil getOrderList(Integer page, Integer limit, BizPurchaseOrderSearch search){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        search.setLoginId(admin.getId());
        return purchaseOrderService.getOrderList(page,limit,search);
    }

    @RequestMapping("/toDetails/{id}")
    @RequiresPermissions("mobile:purchase:details")
    public String toDetails(@PathVariable("id") String id, Model model){
        BizPurchaseOrderDetailsVo detailsVo = purchaseOrderService.selPurchaseOrder(id);
        model.addAttribute("detailsVo",detailsVo);
        return "page/mobile/purchaseOrder/details";
    }


    @RequestMapping("/toSave")
    @RequiresPermissions("mobile:purchase:save")
    public String toSave(Model model){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        if(admin.getSupplierId() != null){
            TbSupplier supplier = supplierService.selSupplierById(admin.getSupplierId());
            admin.setSupplierName(supplier.getName());
        }
        List<ChoseAdminVO> admins = adminService.selectAdmin();
        logger.info("------:{}", JSON.toJSONString(admins));
        model.addAttribute("admins", JSON.toJSONString(admins));
        model.addAttribute("admin", admin);
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


    @RequestMapping("/toEdit")
    @RequiresPermissions("mobile:purchase:save")
    public String toUpdate(String id, Model model){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        if(admin.getSupplierId() != null){
            TbSupplier supplier = supplierService.selSupplierById(admin.getSupplierId());
            admin.setSupplierName(supplier.getName());
        }
        List<ChoseAdminVO> admins = adminService.selectAdmin();
        logger.info("------:{}", JSON.toJSONString(admins));
        model.addAttribute("admins", JSON.toJSONString(admins));
        model.addAttribute("admin", admin);

        BizPurchaseOrderVo order = purchaseOrderService.selPurchaseOrderById(id);
        model.addAttribute("order",order);

        return "page/mobile/purchaseOrder/from";
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

    @SysLog(value="填写合同")
    @RequestMapping("purchaseOrderContractNo/{id}")
    @RequiresPermissions("mobile:purchase:save")
    @ResponseBody
    public ResultUtil purchaseOrderContractNo(@PathVariable("id") String id, String contractNo){
        return purchaseOrderService.purchaseOrderContractNo(id,contractNo);
    }

    @SysLog(value="提交审核")
    @RequestMapping("submitReviewPurchaseOrder")
    @RequiresPermissions("mobile:purchase:save")
    @ResponseBody
    public ResultUtil submitReviewPurchaseOrder(String id, Long userId){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        ResultUtil resultUtil = purchaseOrderService.submitPurchaseOrder(id);

        if(resultUtil.getCode() == 0){
            return purchaseOrderService.submitReviewPurchaseOrder(admin, id, userId);
        }else {
            return resultUtil;
        }
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


    /**
     * 不需要权限，查询采购单列表（合同内订单来源）
     * @param page
     * @param limit
     * @param search
     * @return
     */
    @RequestMapping("findPurchaseOrderList")
    @ResponseBody
    public ResultUtil findPurchaseOrderList(Integer page, Integer limit, BizPurchaseOrderSearch search){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        search.setLoginId(admin.getId());
        return purchaseOrderService.getOrderList(page,limit,search);
    }

}
