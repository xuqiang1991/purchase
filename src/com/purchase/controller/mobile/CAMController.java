package com.purchase.controller.mobile;

import com.alibaba.fastjson.JSON;
import com.purchase.annotation.SysLog;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizContractApplyMoney;
import com.purchase.pojo.order.BizPurchaseOrder;
import com.purchase.service.AdminService;
import com.purchase.service.CAMService;
import com.purchase.service.PurchaseOrderService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.SelectVO;
import com.purchase.vo.admin.ChoseAdminVO;
import com.purchase.vo.order.CAMSearch;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @SysLog(value="进入合同内请款单")
    @RequestMapping("list")
    @RequiresPermissions("mobile:CAM:list")
    public String list(){
        return "page/mobile/CAM/list";
    }

    @SysLog(value="进入合同内请款单详情")
    @RequestMapping("camDetails")
    @RequiresPermissions("mobile:CAM:list")
    public String camDetails(HttpServletRequest req){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        List<ChoseAdminVO> admins = adminService.selectAdmin();
        logger.info("------:{}", JSON.toJSONString(admins));
        List<BizPurchaseOrder> purchaseOrderList = purchaseOrderService.selectPurchaseOrder(6,admin.getSupplierId());
        Map<String,Object> purchaseMap = new HashMap<>();
        if(!CollectionUtils.isEmpty(purchaseOrderList)){
            List<SelectVO> poSelect = new ArrayList<>();
            for (BizPurchaseOrder po: purchaseOrderList) {
                poSelect.add(new SelectVO(po.getId(), po.getPurchaseNo().concat(po.getProjectId().toString())));
            }
            purchaseMap.put("poSelect", JSON.toJSONString(poSelect));
            purchaseMap.put("poItem",JSON.toJSONString(purchaseOrderList));
        }
        req.setAttribute("admins", JSON.toJSONString(admins));
        req.setAttribute("admin", admin);
        req.setAttribute("retMap",purchaseMap);
        return "page/mobile/CAM/camDetails";
    }

    @SysLog(value="获取合同内请款单数据")
    @RequestMapping("getCAMList")
    @RequiresPermissions("mobile:CAM:list")
    @ResponseBody
    public ResultUtil getCAMOrderList(Integer page, Integer limit, CAMSearch search){
        return camService.getCAMOrderList(page,limit,search);
    }

    @SysLog(value="查询合同内请款单详情")
    @RequestMapping("selCAMOrder")
    @RequiresPermissions("mobile:CAM:sel")
    @ResponseBody
    public ResultUtil selCAMOrder(String orderNo){
        return camService.selCAMOrder(orderNo);
    }


    @SysLog(value="新增合同内请款单详情")
    @RequestMapping("addCAMOrder")
    @RequiresPermissions("mobile:CAM:add")
    @ResponseBody
    public ResultUtil addCAMOrder(BizContractApplyMoney order){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        order.setCreateUser(admin.getId());
        return camService.addCAMOrder(order);
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

    @SysLog(value="删除合同内请款单详情")
    @RequestMapping("delCAMOrder")
    @RequiresPermissions("mobile:CAM:delete")
    @ResponseBody
    public ResultUtil delCAMOrder(String id){
        return camService.delCAMOrder(id);
    }


    @SysLog(value="提交合同内请款单详情")
    @RequestMapping("submitCAMOrder")
    @RequiresPermissions("mobile:CAM:add")
    @ResponseBody
    public ResultUtil submitCAMOrder(String id){
        return camService.submitCAMOrder(id);
    }



    @SysLog(value="成本部审核合同内请款单详情")
    @RequestMapping("costReviewCAMOrder")
    @RequiresPermissions("mobile:CAM:costReview")
    @ResponseBody
    public ResultUtil costReviewCAMOrder(String id){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        return camService.reviewCAMOrder(admin, id);
    }

    @SysLog(value="工程部合同内请款单详情")
    @RequestMapping("projectCAMOrder")
    @RequiresPermissions("mobile:CAM:projectReview")
    @ResponseBody
    public ResultUtil projectReviewCAMOrder(String id){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        return camService.reviewCAMOrder(admin, id);
    }


    @SysLog(value="总经理审核合同内请款单详情")
    @RequestMapping("managerCAMOrder")
    @RequiresPermissions("mobile:CAM:managerReview")
    @ResponseBody
    public ResultUtil managerReviewCAMOrder(String id){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        return camService.reviewCAMOrder(admin, id);
    }
}
