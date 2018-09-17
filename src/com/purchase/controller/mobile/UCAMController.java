package com.purchase.controller.mobile;

import com.alibaba.fastjson.JSON;
import com.purchase.annotation.SysLog;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.order.BizUncontractApplyMoney;
import com.purchase.service.*;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.ChoseAdminVO;
import com.purchase.vo.order.BizPurchaseOrderVo;
import com.purchase.vo.order.UCAMSearch;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/24 20:57
 * @Description:合同外请款控制类
 */
@Controller
@RequestMapping("mobile/UCAM")
public class UCAMController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UCAMService ucamService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ProjectMangerService projectMangerService;

    @SysLog(value="进入合同外请款单")
    @RequestMapping("list")
    @RequiresPermissions("mobile:UCAM:list")
    public String list(){
        return "page/mobile/UCAM/list";
    }

    @SysLog(value="进入合同外请款单详情")
    @RequestMapping("ucamDetails")
    @RequiresPermissions("mobile:UCAM:list")
    public String ucamDetails(HttpServletRequest req){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        if(admin.getSupplierId() != null){
            TbSupplier supplier = supplierService.selSupplierById(admin.getSupplierId());
            admin.setSupplierName(supplier.getName());
        }
        List<ChoseAdminVO> admins = adminService.selectAdmin();
        logger.info("------:{}", JSON.toJSONString(admins));
        List<TbProjectManger> projectMangerList = projectMangerService.selectProjectMangerExample();

        List<BizPurchaseOrderVo> purchaseOrderList = purchaseOrderService.selectPurchaseOrderExample(6,admin.getSupplierId());
        req.setAttribute("admins", JSON.toJSONString(admins));
        req.setAttribute("admin", admin);
        req.setAttribute("pmItem",JSON.toJSONString(projectMangerList));
        return "page/mobile/UCAM/ucamDetails";
    }

    @SysLog(value="获取合同外请款单数据")
    @RequestMapping("getUCAMList")
    @RequiresPermissions("mobile:UCAM:list")
    @ResponseBody
    public ResultUtil getUCAMOrderList(Integer page, Integer limit, UCAMSearch search){
        return ucamService.getUCAMOrderList(page,limit,search);
    }

    @SysLog(value="查询合同外请款单详情")
    @RequestMapping("selUCAMOrder")
    @RequiresPermissions("mobile:UCAM:sel")
    @ResponseBody
    public ResultUtil selUCAMOrder(String orderNo){
        return ucamService.selUCAMOrder(orderNo);
    }


    @SysLog(value="新增合同外请款单详情")
    @RequestMapping("addUCAMOrder")
    @RequiresPermissions("mobile:UCAM:save")
    @ResponseBody
    public ResultUtil addUCAMOrder(BizUncontractApplyMoney order){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        order.setCreateUser(admin.getId());
        return ucamService.addUCAMOrder(order);
    }

    @SysLog(value="编辑合同外请款单详情")
    @RequestMapping("editUCAMOrder")
    @RequiresPermissions("mobile:UCAM:edit")
    @ResponseBody
    public ResultUtil editUCAMOrder(BizUncontractApplyMoney order){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        order.setCreateUser(admin.getId());
        return ucamService.editUCAMOrder(order);
    }

    @SysLog(value="删除合同外请款单详情")
    @RequestMapping("delUCAMOrder")
    @RequiresPermissions("mobile:UCAM:delete")
    @ResponseBody
    public ResultUtil delUCAMOrder(String id){
        return ucamService.delUCAMOrder(id);
    }


    @SysLog(value="提交合同外请款单详情")
    @RequestMapping("submitUCAMOrder")
    @RequiresPermissions("mobile:UCAM:save")
    @ResponseBody
    public ResultUtil submitUCAMOrder(String id){
        return ucamService.submitUCAMOrder(id);
    }



    @SysLog(value="成本部审核合同外请款单详情")
    @RequestMapping("costReviewUCAMOrder")
    @RequiresPermissions("mobile:UCAM:costReview")
    @ResponseBody
    public ResultUtil costReviewUCAMOrder(String id){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        return ucamService.reviewUCAMOrder(admin, id);
    }

    @SysLog(value="工程部合同外请款单详情")
    @RequestMapping("projectUCAMOrder")
    @RequiresPermissions("mobile:UCAM:projectReview")
    @ResponseBody
    public ResultUtil projectReviewUCAMOrder(String id){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        return ucamService.reviewUCAMOrder(admin, id);
    }


    @SysLog(value="总经理审核合同外请款单详情")
    @RequestMapping("managerUCAMOrder")
    @RequiresPermissions("mobile:UCAM:managerReview")
    @ResponseBody
    public ResultUtil managerReviewUCAMOrder(String id){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        return ucamService.reviewUCAMOrder(admin, id);
    }
}
