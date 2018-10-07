package com.purchase.controller.mobile;

import com.alibaba.fastjson.JSON;
import com.purchase.annotation.SysLog;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.order.BizProgrammeAcceptanceOrder;
import com.purchase.pojo.order.BizProgrammeAcceptanceOrderDetail;
import com.purchase.service.AdminService;
import com.purchase.service.ProgrammeAcceptanceService;
import com.purchase.service.ProjectMangerService;
import com.purchase.service.SupplierService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.ChoseAdminVO;
import com.purchase.vo.admin.ChoseDeptVO;
import com.purchase.vo.admin.ChoseSupplierVO;
import com.purchase.vo.order.ProgrammeAcceptanceDetialVo;
import com.purchase.vo.order.ProgrammeAcceptanceSearch;
import com.purchase.vo.order.ProgrammeAcceptanceVo;
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
 * @Description:工程验收控制类
 */
@Controller
@RequestMapping("mobile/programmeAcceptance")
public class ProgrammeAcceptanceController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProgrammeAcceptanceService paService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ProjectMangerService projectMangerService;

    @SysLog(value="进入工程验收")
    @RequestMapping("list")
    @RequiresPermissions("mobile:programmeAcceptance:list")
    public String list(HttpServletRequest req){
        List<ChoseAdminVO> admins = adminService.selectAdmin();
        List<ChoseSupplierVO> suppliers = supplierService.selectSupplier();
        List<ChoseDeptVO> depts = adminService.selectDeptAdmin();
        logger.info("------:{}", JSON.toJSONString(depts));
        req.setAttribute("admins", JSON.toJSONString(admins));
        req.setAttribute("suppliers", JSON.toJSONString(suppliers));
        req.setAttribute("depts", JSON.toJSONString(depts));
        return "page/mobile/programmeAcceptance/list";
    }



    @SysLog(value="进入工程验收详情")
    @RequestMapping("toEdit")
    @RequiresPermissions("mobile:programmeAcceptance:list")
    public String programmeAcceptanceDetails(HttpServletRequest req){
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

        ProgrammeAcceptanceVo paVo = new ProgrammeAcceptanceVo();
        if(!StringUtils.isEmpty(id)){
            paVo = paService.selPAOOrder(id);
        }
        req.setAttribute("paVo",paVo);
        return "page/mobile/programmeAcceptance/from";

    }

    @SysLog(value="获取工程验收数据")
    @RequestMapping("getProgrammeAcceptanceOrderList")
    @RequiresPermissions("mobile:programmeAcceptance:list")
    @ResponseBody
    public ResultUtil getProgrammeAcceptanceOrderList(Integer page, Integer limit, ProgrammeAcceptanceSearch search){
        return paService.getPAOOrderList(page,limit,search);
    }

    @SysLog(value="查询工程验收详情")
    @RequestMapping("selProgrammeAcceptanceOrder")
    @RequiresPermissions("mobile:programmeAcceptance:sel")
    @ResponseBody
    public ResultUtil selProgrammeAcceptanceOrder(String orderNo){
        return paService.selPAOOrderByOrder(orderNo);
    }


    @SysLog(value="新增工程验收详情")
    @RequestMapping("addProgrammeAcceptanceOrder")
    @RequiresPermissions("mobile:programmeAcceptance:save")
    @ResponseBody
    public ResultUtil addProgrammeAcceptanceOrder(BizProgrammeAcceptanceOrder order){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        order.setCreateUser(admin.getId());
        return paService.addPAOOrder(order);
    }

    @RequestMapping("/toDetails/{id}")
    @RequiresPermissions("mobile:programmeAcceptance:details")
    public String toDetails(@PathVariable("id") String id, Model model){
        ProgrammeAcceptanceDetialVo detailsVo = paService.selPAODetail(id);
        model.addAttribute("detailsVo",detailsVo);
        return "page/mobile/programmeAcceptance/details";
    }


    @SysLog(value="编辑工程验收详情")
    @RequestMapping("editProgrammeAcceptanceOrder")
    @RequiresPermissions("mobile:programmeAcceptance:edit")
    @ResponseBody
    public ResultUtil editProgrammeAcceptanceOrder(BizProgrammeAcceptanceOrder order){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        order.setCreateUser(admin.getId());
        return paService.editPAOOrder(order);
    }

    @SysLog(value="删除工程验收详情")
    @RequestMapping("delProgrammeAcceptanceOrder")
    @RequiresPermissions("mobile:programmeAcceptance:delete")
    @ResponseBody
    public ResultUtil delProgrammeAcceptanceOrder(String id){
        return paService.delPAOOrder(id);
    }


    @SysLog(value="提交工程验收详情")
    @RequestMapping("submitProgrammeAcceptanceOrder")
    @RequiresPermissions("mobile:programmeAcceptance:save")
    @ResponseBody
    public ResultUtil submitProgrammeAcceptanceOrder(String id){
        return paService.submitPAOOrder(id);
    }

    @SysLog(value="提交审核")
    @RequestMapping("submitReviewprogrammeAcceptanceOrder")
    @RequiresPermissions("mobile:programmeAcceptance:save")
    @ResponseBody
    public ResultUtil submitReviewprogrammeAcceptanceOrder(String id, Long userId){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        return paService.submitReviewPAOOrder(admin, id, userId);
    }

    @SysLog(value="审核工程验收")
    @RequestMapping("reviewProgrammeAcceptanceOrder/{id}")
    //@RequiresPermissions("mobile:programmeAcceptance:review")
    @ResponseBody
    public ResultUtil reviewProgrammeAcceptanceOrder(@PathVariable("id") String id, Boolean auditResults, Long applyUser, String auditOpinion){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        return paService.reviewPAOOrder(admin, id, auditResults,applyUser,auditOpinion);
    }


    @SysLog(value="新增工程验收单项")
    @RequestMapping("addProgrammeAcceptanceItem/{orderNo}")
    @RequiresPermissions("mobile:programmeAcceptance:save")
    @ResponseBody
    public ResultUtil addProgrammeAcceptanceItem(@PathVariable("orderNo") String orderNo, BizProgrammeAcceptanceOrderDetail order){
        Date date = new Date();
        /*order.setUpdateDate(date);
        order.setCreateTime(date);*/
        order.setOrderNo(orderNo);
        return paService.addPAOOrderDetail(order);
    }

    @SysLog(value="删除工程验收单项")
    @RequestMapping("deleteProgrammeAcceptanceItem/{id}")
    @RequiresPermissions("mobile:programmeAcceptance:save")
    @ResponseBody
    public ResultUtil deleteProgrammeAcceptanceItem(@PathVariable("id") String id){
        return paService.deletePAOItem(id);
    }



}