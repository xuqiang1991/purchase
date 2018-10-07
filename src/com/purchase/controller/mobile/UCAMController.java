package com.purchase.controller.mobile;

import com.alibaba.fastjson.JSON;
import com.purchase.annotation.SysLog;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.order.BizUncontractApplyMoney;
import com.purchase.pojo.order.BizUncontractApplyMoneyDetail;
import com.purchase.service.*;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.ChoseAdminVO;
import com.purchase.vo.admin.ChoseDeptVO;
import com.purchase.vo.admin.ChoseProjectVO;
import com.purchase.vo.admin.ChoseSupplierVO;
import com.purchase.vo.order.UCAMOrderDetialVo;
import com.purchase.vo.order.UCAMSearch;
import com.purchase.vo.order.UCAMVo;
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
        if(admin.getSupplierId() != null){
            TbSupplier supplier = supplierService.selSupplierById(admin.getSupplierId());
            admin.setSupplierName(supplier.getName());
        }
        List<ChoseAdminVO> admins = adminService.selectAdmin();
        logger.info("------:{}", JSON.toJSONString(admins));
        List<TbProjectManger> projectMangerList = projectMangerService.selectProjectMangerExample();
        req.setAttribute("admins", JSON.toJSONString(admins));
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

    @RequestMapping("/toDetails/{id}")
    @RequiresPermissions("mobile:UCAM:details")
    public String toDetails(@PathVariable("id") String id, Model model){
        UCAMOrderDetialVo detailsVo = ucamService.selUCAMDetail(id);
        model.addAttribute("detailsVo",detailsVo);
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
    public ResultUtil submitUCAMOrder(String id){
        return ucamService.submitUCAMOrder(id);
    }

    @SysLog(value="提交审核")
    @RequestMapping("submitReviewUCAMOrder")
    @RequiresPermissions("mobile:UCAM:save")
    @ResponseBody
    public ResultUtil submitReviewUCAMOrder(String id, Long userId){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        return ucamService.submitReviewUCAMOrder(admin, id, userId);
    }

    @SysLog(value="审核合同外请款单")
    @RequestMapping("reviewUCAMOrder/{id}")
    //@RequiresPermissions("mobile:UCAM:review")
    @ResponseBody
    public ResultUtil reviewUCAMOrder(@PathVariable("id") String id, Boolean auditResults, Long applyUser, String auditOpinion){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        return ucamService.reviewUCAMOrder(admin, id, auditResults,applyUser,auditOpinion);
    }


   /* @SysLog(value="成本部审核合同外请款单详情")
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
*/

    /*@SysLog(value="总经理审核合同外请款单详情")
    @RequestMapping("managerUCAMOrder")
    @RequiresPermissions("mobile:UCAM:managerReview")
    @ResponseBody
    public ResultUtil managerReviewUCAMOrder(String id){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        return ucamService.reviewUCAMOrder(admin, id);
    }*/


    @SysLog(value="新增合同外请款单单项")
    @RequestMapping("addUCAMItem/{orderNo}")
    @RequiresPermissions("mobile:UCAM:save")
    @ResponseBody
    public ResultUtil addUCAMItem(@PathVariable("orderNo") String orderNo, BizUncontractApplyMoneyDetail order){
        Date date = new Date();
        order.setUpdateDate(date);
        order.setCreateTime(date);
        order.setOrderNo(orderNo);
        return ucamService.addUCAMOrderDetail(order);
    }

    @SysLog(value="删除合同外请款单单项")
    @RequestMapping("deleteUCAMItem/{id}")
    @RequiresPermissions("mobile:UCAM:save")
    @ResponseBody
    public ResultUtil deleteUCAMItem(@PathVariable("id") String id){
        return ucamService.deleteUCAMItem(id);
    }



}
