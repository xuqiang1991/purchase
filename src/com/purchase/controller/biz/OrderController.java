package com.purchase.controller.biz;

import com.purchase.annotation.SysLog;
import com.purchase.service.AdminService;
import com.purchase.service.ProjectMangerService;
import com.purchase.service.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/24 20:57
 * @Description:订单管理
 */
@Controller
@RequestMapping("biz/order")
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminService adminService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ProjectMangerService projectMangerService;


    @SysLog(value="进入订单管理列表")
    @RequestMapping("list")
    public String list(HttpServletRequest req){
        /*List<ChoseAdminVO> admins = adminService.selectAdmin();
        List<ChoseSupplierVO> suppliers = supplierService.selectSupplier();
        List<ChoseDeptVO> depts = adminService.selectDeptAdmin();
        List<ChoseProjectVO> projects = projectMangerService.selectProjectManger();
        req.setAttribute("projects", JSON.toJSONString(projects));
        req.setAttribute("admins", JSON.toJSONString(admins));
        req.setAttribute("suppliers", JSON.toJSONString(suppliers));
        req.setAttribute("depts", JSON.toJSONString(depts));*/
        return "page/biz/order/list";
    }





}
