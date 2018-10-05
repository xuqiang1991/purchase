package com.purchase.controller.mobile;

import com.purchase.annotation.SysLog;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.order.BizContractApplyMoney;
import com.purchase.pojo.order.BizContractApplyMoneyDetail;
import com.purchase.service.AdminService;
import com.purchase.service.CAMService;
import com.purchase.service.PurchaseOrderService;
import com.purchase.service.SupplierService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.order.BizPurchaseOrderVo;
import com.purchase.vo.order.CAMDetailsVo;
import com.purchase.vo.order.CAMSearch;
import com.purchase.vo.order.CAMVo;
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
 * @Auther: zhoujb
 * @Date: 2018/8/24 20:57
 * @Description:合同内请款控制类
 */
@Controller
@RequestMapping("mobile/CAM")
public class CAMController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CAMService camService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @Autowired
    private SupplierService supplierService;

    @SysLog(value="进入合同内请款单")
    @RequestMapping("list")
    @RequiresPermissions("mobile:CAM:list")
    public String list(){
        return "page/mobile/CAM/list";
    }


    @SysLog(value="获取合同内请款单数据")
    @RequestMapping("getCAMList")
    @RequiresPermissions("mobile:CAM:list")
    @ResponseBody
    public ResultUtil getCAMOrderList(Integer page, Integer limit, CAMSearch search){
        return camService.getCAMOrderList(page,limit,search);
    }

    @RequestMapping("/toSave")
    @RequiresPermissions("mobile:CAM:save")
    public String toSave(Long id, Model model){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        if(admin.getSupplierId() != null){
            TbSupplier supplier = supplierService.selSupplierById(admin.getSupplierId());
            admin.setSupplierName(supplier.getName());
        }
        model.addAttribute("admin", admin);
        return "page/mobile/CAM/from";
    }

    @SysLog(value="新增合同内请款单详情")
    @RequestMapping("addCAMOrder")
    @RequiresPermissions("mobile:CAM:save")
    @ResponseBody
    public ResultUtil addCAMOrder(BizContractApplyMoney order){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        order.setCreateUser(admin.getId());
        return camService.addCAMOrder(order);
    }


    @RequestMapping("/toEdit")
    @RequiresPermissions("mobile:CAM:save")
    public String toUpdate(String id, Model model){
        CAMVo order = camService.getCAMOrder(id);
        model.addAttribute("order",order);
        return "page/mobile/CAM/from";
    }


    @SysLog(value="进入合同内请款单详情")
    @RequestMapping("/toDetails/{id}")
    @RequiresPermissions("mobile:CAM:list")
    public String toDetails(@PathVariable("id") String id, Model model){
        CAMDetailsVo detailsVo = camService.selCAMOrder(id);
        model.addAttribute("detailsVo",detailsVo);
        return "page/mobile/CAM/camDetails";
    }

    @SysLog(value="删除合同内请款单")
    @RequestMapping("delCAM")
    @RequiresPermissions("mobile:CAM:delete")
    @ResponseBody
    public ResultUtil delCAM(String id){
        return camService.delCAM(id);
    }


    @SysLog(value="删除合同内请款单项")
    @RequestMapping("delCAMItem/{itemId}")
    @RequiresPermissions("mobile:CAM:delete")
    @ResponseBody
    public ResultUtil delCAMItem(@PathVariable("itemId") String itemId){
        return camService.delCAMItem(itemId);
    }


    @SysLog(value="新增合同内请款单项")
    @RequestMapping("addCAMItem/{orderNo}")
    @RequiresPermissions("mobile:CAM:save")
    @ResponseBody
    public ResultUtil addCAMItem(@PathVariable("orderNo") String orderNo, BizContractApplyMoneyDetail order){
        Date date = new Date();
        order.setUpdateDate(date);
        order.setCreateTime(date);
        order.setOrderNo(orderNo);
        return camService.addCAMItem(order);
    }


    @SysLog(value="提交合同内请款单")
    @RequestMapping("submitCAMOrder")
    @RequiresPermissions("mobile:CAM:save")
    @ResponseBody
    public ResultUtil submitCAMOrder(String id){
        return camService.submitCAMOrder(id);
    }


    @SysLog(value="提交审核")
    @RequestMapping("submitReviewCAMOrder")
    @RequiresPermissions("mobile:CAM:save")
    @ResponseBody
    public ResultUtil submitReviewCAMOrder(String id, Long userId){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        return camService.submitReviewCAMOrder(admin, id, userId);
    }

    @SysLog(value="审核合同内请款单详情")
    @RequestMapping("reviewCAMOrder/{id}")
    @RequiresPermissions("mobile:CAM:review")
    @ResponseBody
    public ResultUtil reviewCAMOrder(@PathVariable("id") String id, Boolean auditResults, Long applyUser, String auditOpinion){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        return camService.reviewCAMOrder(admin, id, auditResults,applyUser,auditOpinion);
    }


    @SysLog(value="编辑合同内请款单详情")
    @RequestMapping("editCAMOrder")
    @RequiresPermissions("mobile:CAM:edit")
    @ResponseBody
    public ResultUtil editCAMOrder(BizContractApplyMoney order){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        order.setCreateUser(admin.getId());
        return camService.editCAMOrder(order);
    }
}
