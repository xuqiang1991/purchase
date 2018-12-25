package com.purchase.controller.mobile;

import com.alibaba.fastjson.JSON;
import com.purchase.annotation.SysLog;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.order.BizUncontractApplyMoney;
import com.purchase.pojo.order.BizUncontractApplyMoneyDetail;
import com.purchase.service.AdminService;
import com.purchase.service.ProjectMangerService;
import com.purchase.service.SupplierService;
import com.purchase.service.UCAMService;
import com.purchase.util.OrderUtils;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.*;
import com.purchase.vo.order.UCAMOrderDetialVo;
import com.purchase.vo.order.UCAMSearch;
import com.purchase.vo.order.UCAMVo;
import com.purchase.weixin.service.WeixinService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
    private SupplierService supplierService;

    @Autowired
    private ProjectMangerService projectMangerService;

    @Autowired
    private WeixinService weixinService;

    @SysLog(value="进入合同外请款单")
    @RequestMapping("list")
    @RequiresPermissions("mobile:UCAM:list")
    public String list(HttpServletRequest req){
        List<ChoseAdminVO> admins = adminService.selectAdmin();
        List<ChoseSupplierVO> suppliers = supplierService.selectSupplier();
        List<ChoseDeptVO> depts = adminService.selectDeptAdmin();
        List<ChoseProjectVO> projects = projectMangerService.selectProjectManger();
        req.setAttribute("projects", JSON.toJSONString(projects));
        req.setAttribute("admins", JSON.toJSONString(admins));
        req.setAttribute("suppliers", JSON.toJSONString(suppliers));
        req.setAttribute("depts", JSON.toJSONString(depts));
        return "page/mobile/UCAM/list";
    }



    @SysLog(value="进入合同外请款单详情")
    @RequestMapping("toEdit")
    @RequiresPermissions("mobile:UCAM:list")
    public String ucamDetails(HttpServletRequest req){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        /*if(admin.getSupplierId() != null){
            TbSupplier supplier = supplierService.selSupplierById(admin.getSupplierId());
            admin.setSupplierName(supplier.getName());
            //登录账户为供应商，获取当前供应商的用户为创建人
            List<ChoseAdminVO> admins = adminService.selectAdminBySupplierId(admin.getSupplierId());
            req.setAttribute("admins", JSON.toJSONString(admins));
        }else{
            List<ChoseSupplierVO> admins = adminService.selectAdminSupplierIdNotNull();
            req.setAttribute("admins", JSON.toJSONString(admins));
        }*/


        List<TbProjectManger> projectMangerList = projectMangerService.selectProjectMangerExample();
        req.setAttribute("admin", admin);
        req.setAttribute("pmItem",JSON.toJSONString(projectMangerList));
        String id = req.getParameter("id");
        UCAMVo ucamVo = new UCAMVo();
        if(!StringUtils.isEmpty(id)){
            ucamVo = ucamService.selUCAMOrder(id);
        }
        req.setAttribute("ucamVo",ucamVo);
        return "page/mobile/UCAM/from";

    }

    @SysLog(value="获取合同外请款单数据")
    @RequestMapping("getUCAMList")
    @RequiresPermissions("mobile:UCAM:list")
    @ResponseBody
    public ResultUtil getUCAMOrderList(Integer page, Integer limit, UCAMSearch search){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        search.setLoginId(admin.getId());
        return ucamService.getUCAMOrderList(page,limit,search);
    }

    @SysLog(value="查询合同外请款单详情")
    @RequestMapping("selUCAMOrder")
    @RequiresPermissions("mobile:UCAM:sel")
    @ResponseBody
    public ResultUtil selUCAMOrder(String orderNo){
        return ucamService.selUCAMOrderByOrder(orderNo);
    }


    @SysLog(value="新增合同外请款单")
    @RequestMapping("addUCAMOrder")
    @RequiresPermissions("mobile:UCAM:save")
    @ResponseBody
    public ResultUtil addUCAMOrder(BizUncontractApplyMoney order){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        order.setCreateUser(admin.getId());
        return ucamService.saveUCAMOrder(order);
    }

    @RequestMapping("/toDetails")
    @RequiresPermissions("mobile:UCAM:details")
    public String toDetails(HttpServletRequest req, Model model){
        String id = req.getParameter("id");
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        Long adminId = admin.getId();
        UCAMOrderDetialVo detailsVo = new UCAMOrderDetialVo();
        if(!StringUtils.isEmpty(id)){
            detailsVo = ucamService.selUCAMDetail(id,adminId);
            Boolean isOverRole = adminService.checkRoleIsOverRole(detailsVo.getUcamVo().getNextReviewRole());
            if(!isOverRole){
                List<ChoseAdminForRoleVO> reviewAdmins = adminService.selectRoleAdmin();
                model.addAttribute("reviewAdmins", JSON.toJSONString(reviewAdmins));
            }
            model.addAttribute("isOverRole",isOverRole);
        }

        if(admin.getUserType() == 1){
            TbSupplier supplier = supplierService.selSupplierById(admin.getSupplierId());
            admin.setSupplierName(supplier.getName());
            //登录账户为供应商，获取当前供应商的用户为创建人
            List<ChoseAdminVO> admins = adminService.selectAdminBySupplierId(admin.getSupplierId());
            req.setAttribute("admins", JSON.toJSONString(admins));
        }else{
            List<ChoseSupplierVO> admins = adminService.selectAdminSupplierIdNotNull();
            req.setAttribute("admins", JSON.toJSONString(admins));
        }

        model.addAttribute("detailsVo",detailsVo);
        model.addAttribute("admin",admin);
        return "page/mobile/UCAM/details";
    }


    @SysLog(value="编辑合同外请款单详情")
    @RequestMapping("editUCAMOrder")
    @RequiresPermissions("mobile:UCAM:update")
    @ResponseBody
    public ResultUtil editUCAMOrder(BizUncontractApplyMoney order){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        order.setCreateUser(admin.getId());
        return ucamService.saveUCAMOrder(order);
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
    public ResultUtil submitUCAMOrder(String id, Long userId, Long roleId){
        return ucamService.submitUCAMOrder(id,userId,roleId);
    }

    @SysLog(value="提交审核")
    @RequestMapping("submitReviewUCAMOrder")
    @RequiresPermissions("mobile:UCAM:save")
    @ResponseBody
    public ResultUtil submitReviewUCAMOrder(String id, Long userId, Long roleId){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        ResultUtil resultUtil = ucamService.submitUCAMOrder(id,userId,roleId);
        /*if(resultUtil.getCode() == 0){
            return ucamService.submitReviewUCAMOrder(admin, id, userId);
        }else {
            return resultUtil;
        }*/
        return resultUtil;
    }

    @SysLog(value="审核合同外请款单")
    @RequestMapping("reviewUCAMOrder/{id}")
    @RequiresPermissions("mobile:UCAM:review")
    @ResponseBody
    public ResultUtil reviewUCAMOrder(@PathVariable("id") String id, Boolean auditResults, Long applyUser, String auditOpinion,Long applyRole){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        ResultUtil resultUtil = ucamService.reviewUCAMOrder(admin, id, auditResults,applyUser,auditOpinion,applyRole);
        BizUncontractApplyMoney order = (BizUncontractApplyMoney) resultUtil.getData();
        TbAdmin tbAdmin = adminService.selAdminById(applyUser);
        String openId = tbAdmin.getOpenId();
        String url = OrderUtils.DOMAIN_NAME .concat("/mobile/UCAM/toDetails/?id=").concat(id);
        String title = "订单状态提醒";// 标题
        String desc = "";//"您好，".concat(tbAdmin.getFullname()).concat("。您有订单需要审核");//详情
        if(!auditResults){
            tbAdmin = adminService.selAdminById(order.getCreateUser());
            openId = tbAdmin.getOpenId();
            desc = "您好，".concat(tbAdmin.getFullname()).concat("。您的订单：【").concat(order.getOrderNo()).concat("】被驳回，请查询详细信息！");
        }else{
            boolean isOverRole = adminService.checkRoleIsOverRole(applyRole);
            if(isOverRole){
                tbAdmin = adminService.selAdminById(order.getCreateUser());
                openId = tbAdmin.getOpenId();
                desc = "您好，".concat(tbAdmin.getFullname()).concat("。订单：【").concat(order.getOrderNo()).concat("】审核通过，请查询详细信息！");
            }else{
                tbAdmin = adminService.selAdminById(applyUser);
                openId = tbAdmin.getOpenId();
                desc = "您好，".concat(tbAdmin.getFullname()).concat("。订单：【").concat(order.getOrderNo()).concat("】需要您审核，请查询详细信息！");
            }
        }
        if(!StringUtils.isEmpty(openId)){
           weixinService.sendKefuMessage(tbAdmin.getOpenId(),url,desc,title,null);
        }else{
            logger.info("审核人未绑定帐号，不能发送消息!");
        }
        return resultUtil;
    }


    @SysLog(value="新增合同外请款单单项")
    @RequestMapping("addUCAMItem/{orderNo}")
    @RequiresPermissions("mobile:UCAM:save")
    @ResponseBody
    public ResultUtil addUCAMItem(@PathVariable("orderNo") String orderNo, BizUncontractApplyMoneyDetail order){
        Date date = new Date();
        order.setUpdateDate(date);
        order.setCreateTime(date);
        order.setOrderNo(orderNo);
        return ucamService.editUCAMOrderDetail(order);
    }

    @SysLog(value="更新合同外请款单单项")
    @RequestMapping("editUCAMItem")
    @RequiresPermissions("mobile:UCAM:save")
    @ResponseBody
    public ResultUtil editUCAMItem(BizUncontractApplyMoneyDetail order){
        Date date = new Date();
        order.setUpdateDate(date);
        return ucamService.editUCAMOrderDetail(order);
    }

    @SysLog(value="删除合同外请款单单项")
    @RequestMapping("deleteUCAMItem/{id}")
    @RequiresPermissions("mobile:UCAM:save")
    @ResponseBody
    public ResultUtil deleteUCAMItem(@PathVariable("id") String id){
        return ucamService.deleteUCAMItem(id);
    }

    @SysLog(value="查询合同外请款单单项")
    @RequestMapping("getUCAMItem/{id}")
    @RequiresPermissions("mobile:UCAM:list")
    @ResponseBody
    public ResultUtil getUCAMItem(@PathVariable("id") String id){
        return ucamService.selUCAMItem(id);
    }

    @SysLog(value="填写指令单号")
    @RequestMapping("UCAMInstructOrderNo/{id}")
    @RequiresPermissions("mobile:UCAM:save")
    @ResponseBody
    public ResultUtil UCAMInstructOrderNo(@PathVariable("id") String id, String instructOrderNo){
        return ucamService.setInstructOrderNo(id,instructOrderNo);
    }

}
