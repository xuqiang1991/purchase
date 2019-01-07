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
import com.purchase.util.OrderUtils;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.*;
import com.purchase.vo.order.ProgrammeAcceptanceDetialVo;
import com.purchase.vo.order.ProgrammeAcceptanceSearch;
import com.purchase.vo.order.ProgrammeAcceptanceVo;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Autowired
    private WeixinService weixinService;

    @SysLog(value="进入工程验收")
    @RequestMapping("list")
    @RequiresPermissions("mobile:programmeAcceptance:list")
    public String list(HttpServletRequest req){
        List<ChoseAdminVO> admins = adminService.selectAdmin();
        List<ChoseSupplierVO> suppliers = supplierService.selectSupplier();
        List<ChoseDeptVO> depts = adminService.selectDeptAdmin();
        List<ChoseProjectVO> projects = projectMangerService.selectProjectManger();
        req.setAttribute("projects", JSON.toJSONString(projects));
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
            Long adminId = admin.getId();
            paVo = paService.selPAOOrder(id,adminId);
        }
        req.setAttribute("paVo",paVo);
        return "page/mobile/programmeAcceptance/from";

    }

    @SysLog(value="获取工程验收数据")
    @RequestMapping("getProgrammeAcceptanceOrderList")
    @RequiresPermissions("mobile:programmeAcceptance:list")
    @ResponseBody
    public ResultUtil getProgrammeAcceptanceOrderList(Integer page, Integer limit, ProgrammeAcceptanceSearch search){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        search.setLoginId(admin.getId());
        return paService.getPAOOrderList(page,limit,search);
    }

    @SysLog(value="查询工程验收详情")
    @RequestMapping("selProgrammeAcceptanceOrder")
    @RequiresPermissions("mobile:programmeAcceptance:sel")
    @ResponseBody
    public ResultUtil selProgrammeAcceptanceOrder(String orderNo){
        return paService.selPAOOrderByOrder(orderNo);
    }


    @SysLog(value="新增工程验收")
    @RequestMapping("addProgrammeAcceptanceOrder")
    @RequiresPermissions("mobile:programmeAcceptance:save")
    @ResponseBody
    public ResultUtil addProgrammeAcceptanceOrder(BizProgrammeAcceptanceOrder order){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        order.setCreateUser(admin.getId());
        return paService.savePAOOrder(order);
    }

    @RequestMapping("/toDetails")
    @RequiresPermissions("mobile:programmeAcceptance:details")
    public String toDetails(HttpServletRequest req, Model model){
        String id = req.getParameter("id");
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        Long adminId = admin.getId();

        ProgrammeAcceptanceDetialVo detailsVo = new ProgrammeAcceptanceDetialVo();
        if(!StringUtils.isEmpty(id)){
            detailsVo = paService.selPAODetail(id,adminId);
            Boolean isOverRole = adminService.checkRoleIsOverRole(detailsVo.getPaoVo().getNextReviewRole());
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
        return "page/mobile/programmeAcceptance/details";
    }


    @SysLog(value="编辑工程验收")
    @RequestMapping("editProgrammeAcceptanceOrder")
    @RequiresPermissions("mobile:programmeAcceptance:update")
    @ResponseBody
    public ResultUtil editProgrammeAcceptanceOrder(BizProgrammeAcceptanceOrder order){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        return paService.savePAOOrder(order);
    }

    @SysLog(value="删除工程验收")
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
    public ResultUtil submitProgrammeAcceptanceOrder(String id, Long userId, Long roleId){
        return paService.submitPAOOrder(id,userId,roleId);
    }

    @SysLog(value="提交审核")
    @RequestMapping("submitReviewprogrammeAcceptanceOrder")
    @RequiresPermissions("mobile:programmeAcceptance:save")
    @ResponseBody
    public ResultUtil submitReviewprogrammeAcceptanceOrder(String id, Long userId, Long roleId){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        ResultUtil resultUtil = paService.submitPAOOrder(id,userId,roleId);
        BizProgrammeAcceptanceOrder order = (BizProgrammeAcceptanceOrder) resultUtil.getData();
        TbAdmin tbAdmin = adminService.selAdminById(userId);;
        boolean isOverRole = adminService.checkRoleIsOverRole(roleId);
        String url = OrderUtils.DOMAIN_NAME .concat("/mobile/UCAM/toDetails/?id=").concat(id);
        weixinService.sendMSGUtils(tbAdmin,isOverRole,url,true,order.getOrderNo());
        return resultUtil;
    }

    @SysLog(value="审核工程验收")
    @RequestMapping("reviewProgrammeAcceptanceOrder/{id}")
    @RequiresPermissions("mobile:programmeAcceptance:review")
    @ResponseBody
    public ResultUtil reviewProgrammeAcceptanceOrder(@PathVariable("id") String id, Boolean auditResults, Long applyUser, String auditOpinion,Long applyRole){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        ResultUtil resultUtil = paService.reviewPAOOrder(admin, id, auditResults,applyUser,auditOpinion,applyRole);
        BizProgrammeAcceptanceOrder order = (BizProgrammeAcceptanceOrder) resultUtil.getData();
        TbAdmin tbAdmin = null;
        boolean isOverRole = false;
        String url = OrderUtils.DOMAIN_NAME .concat("/mobile/programmeAcceptance/toDetails/?id=").concat(id);
        if(!auditResults){
            tbAdmin = adminService.selAdminById(order.getCreateUser());
        }else{
            if(applyRole != null && applyUser != null && applyRole != 0 && applyUser != 0){
                isOverRole = adminService.checkRoleIsOverRole(applyRole);
                if(isOverRole){
                    tbAdmin = adminService.selAdminById(order.getCreateUser());
                }else{
                    tbAdmin = adminService.selAdminById(applyUser);
                }
            }else{
                tbAdmin = adminService.selAdminById(order.getCreateUser());
            }
        }
        weixinService.sendMSGUtils(tbAdmin,isOverRole,url,auditResults,order.getOrderNo());
        return resultUtil;
    }


    @SysLog(value="新增工程验收单项")
    @RequestMapping("addProgrammeAcceptanceItem")
    @RequiresPermissions("mobile:programmeAcceptance:save")
    @ResponseBody
    public ResultUtil addProgrammeAcceptanceItem(String orderNo, String rectifyContent, String rectifyMeasure, String playOverDate, Integer rectifyFlag, String actualOverDate, String remark){
        BizProgrammeAcceptanceOrderDetail order = new BizProgrammeAcceptanceOrderDetail();
        order.setRectifyContent(rectifyContent);
        order.setRectifyMeasure(rectifyMeasure);
        order.setRectifyFlag(rectifyFlag);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if(!StringUtils.isEmpty(playOverDate)) {
                order.setPlayOverDate(sdf.parse(playOverDate));
            }
            if(!StringUtils.isEmpty(actualOverDate)) {
                order.setActualOverDate(sdf.parse(actualOverDate));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        order.setRemark(remark);
        order.setOrderNo(orderNo);
        return paService.addPAOOrderDetail(order);
    }

    @SysLog(value="更新工程验收单项")
    @RequestMapping("editProgrammeAcceptanceItem")
    @RequiresPermissions("mobile:programmeAcceptance:save")
    @ResponseBody
    public ResultUtil editProgrammeAcceptanceItem(String id,String orderNo, String rectifyContent, String rectifyMeasure, String playOverDate, Integer rectifyFlag, String actualOverDate, String remark){
        BizProgrammeAcceptanceOrderDetail order = new BizProgrammeAcceptanceOrderDetail();
        order.setRectifyFlag(rectifyFlag);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if(!StringUtils.isEmpty(actualOverDate)) {
                order.setActualOverDate(sdf.parse(actualOverDate));
            }
            if(!StringUtils.isEmpty(playOverDate)) {
                order.setPlayOverDate(sdf.parse(playOverDate));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        order.setRectifyContent(rectifyContent);
        order.setRectifyMeasure(rectifyMeasure);
        order.setRectifyFlag(rectifyFlag);
        order.setRemark(remark);
        order.setOrderNo(orderNo);
        order.setId(id);
        return paService.editPAOOrderDetail(order);
    }

    @SysLog(value="删除工程验收单项")
    @RequestMapping("deleteProgrammeAcceptanceItem/{id}")
    @RequiresPermissions("mobile:programmeAcceptance:save")
    @ResponseBody
    public ResultUtil deleteProgrammeAcceptanceItem(@PathVariable("id") String id){
        return paService.deletePAOItem(id);
    }

    @SysLog(value="查询工程验收单项")
    @RequestMapping("getProgrammeAcceptanceItem/{id}")
    @RequiresPermissions("mobile:programmeAcceptance:list")
    @ResponseBody
    public ResultUtil getProgrammeAcceptanceItem(@PathVariable("id") String id){
        return paService.selPAOItem(id);
    }

}
