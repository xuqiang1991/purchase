package com.purchase.controller.mobile;

import com.alibaba.fastjson.JSON;
import com.purchase.annotation.SysLog;
import com.purchase.mapper.admin.TbDepartmentMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizPaymentOrder;
import com.purchase.service.AdminService;
import com.purchase.service.PaymentOrderService;
import com.purchase.service.ProjectMangerService;
import com.purchase.service.SupplierService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.ChoseAdminVO;
import com.purchase.vo.admin.ChoseDeptVO;
import com.purchase.vo.admin.ChoseProjectVO;
import com.purchase.vo.admin.ChoseSupplierVO;
import com.purchase.vo.order.BizPaymentOrderSearch;
import com.purchase.vo.order.BizPaymentOrderVo;
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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: xuqiang
 * @Date: 2018/10/07
 * @Description:付款
 */
@Controller
@RequestMapping("mobile/paymentOrder")
public class PaymentOrderController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PaymentOrderService paymentOrderService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private ProjectMangerService projectMangerService;

    @RequestMapping("list")
    @RequiresPermissions("mobile:paymentOrder:list")
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
        return "page/mobile/payment/list";
    }

    @RequestMapping("getPurchaseList")
    @RequiresPermissions("mobile:paymentOrder:list")
    @ResponseBody
    public ResultUtil getOrderList(Integer page, Integer limit, BizPaymentOrderSearch search){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        search.setLoginId(admin.getId());
        return paymentOrderService.getOrderList(page,limit,search);
    }

    @RequestMapping("/toDetails/{id}")
    @RequiresPermissions("mobile:purchase:details")
    public String toDetails(@PathVariable("id") String id, Model model){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        BizPaymentOrderVo detailsVo = paymentOrderService.getPaymentOrderDetails(id,admin);
        model.addAttribute("detailsVo",detailsVo);
        return "page/mobile/payment/details";
    }

    @RequestMapping("editPaymentOrder")
    @RequiresPermissions("mobile:paymentOrder:update")
    @ResponseBody
    public ResultUtil editPaymentOrder(BizPaymentOrder order){
        return paymentOrderService.editPaymentOrder(order);
    }

    @SysLog(value="审核付款单")
    @RequestMapping("reviewOrder/{id}")
    @RequiresPermissions("mobile:paymentOrder:review")
    @ResponseBody
    public ResultUtil reviewOrder(@PathVariable("id") String id, Boolean auditResults, Long applyUser, String auditOpinion){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        return paymentOrderService.reviewOrder(admin, id, auditResults,applyUser,auditOpinion);
    }


}
