package com.purchase.controller.mobile;

import com.alibaba.fastjson.JSON;
import com.purchase.annotation.SysLog;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.order.BizContractApplyMoney;
import com.purchase.pojo.order.BizContractApplyMoneyDetail;
import com.purchase.service.*;
import com.purchase.util.OrderUtils;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.*;
import com.purchase.vo.order.CAMDetailsVo;
import com.purchase.vo.order.CAMSearch;
import com.purchase.vo.order.CAMVo;
import com.purchase.weixin.service.WeixinService;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    private ProjectMangerService projectMangerService;

    @Autowired
    private WeixinService weixinService;


    @SysLog(value="进入合同内请款单")
    @RequestMapping("list")
    @RequiresPermissions("mobile:CAM:list")
    public String list(HttpServletRequest req){
        List<ChoseAdminVO> admins = adminService.selectAdmin();
        List<ChoseSupplierVO> suppliers = supplierService.selectSupplier();
        List<ChoseDeptVO> depts = adminService.selectDeptAdmin();
        List<ChoseProjectVO> projects = projectMangerService.selectProjectManger();
        List<ChosePurchaseOrderVO> purchaseOrders = purchaseOrderService.selectChosePurchaseOrder();
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        logger.info("------:{}", JSON.toJSONString(depts));
        req.setAttribute("admins", JSON.toJSONString(admins));
        req.setAttribute("suppliers", JSON.toJSONString(suppliers));
        req.setAttribute("depts", JSON.toJSONString(depts));
        req.setAttribute("projects", JSON.toJSONString(projects));
        req.setAttribute("purchaseOrders", JSON.toJSONString(purchaseOrders));
        req.setAttribute("admin", admin);
        return "page/mobile/CAM/list";
    }


    @SysLog(value="获取合同内请款单数据")
    @RequestMapping("getCAMList")
    @RequiresPermissions("mobile:CAM:list")
    @ResponseBody
    public ResultUtil getCAMOrderList(Integer page, Integer limit, CAMSearch search){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        search.setLoginId(admin.getId());
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

        List<ChoseAdminVO> admins = adminService.selectAdmin();
        logger.info("------:{}", JSON.toJSONString(admins));
        model.addAttribute("admins", JSON.toJSONString(admins));

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
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        if(admin.getSupplierId() != null){
            TbSupplier supplier = supplierService.selSupplierById(admin.getSupplierId());
            admin.setSupplierName(supplier.getName());
        }
        List<ChoseAdminVO> admins = adminService.selectAdmin();
        logger.info("------:{}", JSON.toJSONString(admins));
        model.addAttribute("admins", JSON.toJSONString(admins));
        model.addAttribute("admin", admin);


        CAMVo order = camService.getCAMOrder(id);
        model.addAttribute("order",order);
        return "page/mobile/CAM/from";
    }


    @SysLog(value="进入合同内请款单详情")
    @RequestMapping("/toDetails")
    @RequiresPermissions("mobile:CAM:list")
    public String toDetails(HttpServletRequest req, Model model){
        String id = req.getParameter("id");
        CAMDetailsVo detailsVo = new CAMDetailsVo();
        if(StringUtils.isNotEmpty(id)){
            detailsVo = camService.selCAMOrder(id);
            Boolean isOverRole = adminService.checkRoleIsOverRole(detailsVo.getOrder().getNextReviewRole());
            if(!isOverRole){
                List<ChoseAdminForRoleVO> reviewAdmins = adminService.selectRoleAdmin();
                model.addAttribute("reviewAdmins", JSON.toJSONString(reviewAdmins));
            }
            model.addAttribute("isOverRole",isOverRole);
        }
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
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


    @SysLog(value="新增合同内请款单项")
    @RequestMapping("addCAMItems/{orderNo}")
    @RequiresPermissions("mobile:CAM:save")
    @ResponseBody
    public ResultUtil addCAMItems(HttpServletRequest req,@PathVariable("orderNo") String orderNo){
        String ids = req.getParameter("ids");
        return camService.addCAMItems(orderNo,ids);
    }

    @SysLog(value="查询合同内请款单详情")
    @RequestMapping("getCAMItem/{itemId}")
    @RequiresPermissions("mobile:CAM:list")
    @ResponseBody
    public ResultUtil getCAMItem(@PathVariable("itemId") String itemId){
        return camService.getCAMItem(itemId);
    }

    @SysLog(value="编辑合同内请款单项")
    @RequestMapping("editCAMItem")
    @RequiresPermissions("mobile:CAM:save")
    @ResponseBody
    public ResultUtil editCAMItem(BizContractApplyMoneyDetail order){
        Date date = new Date();
        order.setUpdateDate(date);
        return camService.editCAMItem(order);
    }


    @SysLog(value="提交审核")
    @RequestMapping("submitReviewCAMOrder")
    @RequiresPermissions("mobile:CAM:save")
    @ResponseBody
    public ResultUtil submitReviewCAMOrder(String id, Long userId, Long roleId){
        ResultUtil resultUtil = camService.submitCAMOrder(id,userId,roleId);
        BizContractApplyMoney order = (BizContractApplyMoney) resultUtil.getData();

        TbAdmin tbAdmin = adminService.selAdminById(userId);;
        boolean isOverRole = adminService.checkRoleIsOverRole(roleId);
        String url = OrderUtils.DOMAIN_NAME .concat("/mobile/CAM/toDetails/?id=").concat(id);
        weixinService.sendMSGUtils(tbAdmin,isOverRole,url,true,order.getOrderNo());
        return resultUtil;
    }

    @SysLog(value="审核合同内请款单详情")
    @RequestMapping("reviewCAMOrder/{id}")
    @RequiresPermissions("mobile:CAM:review")
    @ResponseBody
    public ResultUtil reviewCAMOrder(@PathVariable("id") String id, Boolean auditResults, Long applyUser, String auditOpinion,Long applyRole){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        ResultUtil resultUtil = camService.reviewCAMOrder(admin, id, auditResults,applyUser,auditOpinion,applyRole);
        BizContractApplyMoney order = (BizContractApplyMoney) resultUtil.getData();

        TbAdmin tbAdmin = null;
        boolean isOverRole = false;
        String url = OrderUtils.DOMAIN_NAME .concat("/mobile/CAM/toDetails/?id=").concat(id);
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
            }else {
                tbAdmin = adminService.selAdminById(order.getCreateUser());
            }

        }
        weixinService.sendMSGUtils(tbAdmin,isOverRole,url,auditResults,order.getOrderNo());
        return resultUtil;
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

    @RequestMapping("checkCAM/{id}")
    @ResponseBody
    public ResultUtil checkCAM(@PathVariable("id") String id){
        return camService.checkCAM(id);
    }

    @RequestMapping("checkCAMItem/{purchaseDetailId}")
    @ResponseBody
    public ResultUtil checkCAMItem(@PathVariable("purchaseDetailId") String purchaseDetailId){
        return camService.checkCAMItem(purchaseDetailId);
    }
}
