package com.purchase.controller.mobile;

import com.alibaba.fastjson.JSON;
import com.purchase.annotation.SysLog;
import com.purchase.mapper.admin.TbAreaMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.order.BizBiddingManagement;
import com.purchase.pojo.order.BizUncontractApplyMoney;
import com.purchase.service.AdminService;
import com.purchase.service.BiddingManagementService;
import com.purchase.service.ProjectMangerService;
import com.purchase.service.SupplierService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.*;
import com.purchase.vo.order.BiddingManagementSearch;
import com.purchase.vo.order.BiddingManagementVo;
import com.purchase.vo.order.UCAMOrderDetialVo;
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
import java.util.List;

@Controller
@RequestMapping("mobile/biddingManagement")
public class BiddingManagementController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BiddingManagementService bmService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ProjectMangerService projectMangerService;

    @Autowired
    private TbAreaMapper areaMapper;

    @SysLog(value="进入投标管理")
    @RequestMapping("list")
    @RequiresPermissions("mobile:biddingManagement:list")
    public String list(HttpServletRequest req){
        List<ChoseAdminVO> admins = adminService.selectAdmin();
        List<ChoseSupplierVO> suppliers = supplierService.selectSupplier();
        List<ChoseAreaVO> areas = adminService.selectArea();
        /*List<ChoseProjectVO> projects = projectMangerService.selectProjectManger();
        req.setAttribute("projects", JSON.toJSONString(projects));*/
        req.setAttribute("admins", JSON.toJSONString(admins));
        req.setAttribute("suppliers", JSON.toJSONString(suppliers));
        req.setAttribute("areas", JSON.toJSONString(areas));
        return "page/mobile/biddingManagement/list";
    }



    @SysLog(value="进入投标管理详情")
    @RequestMapping("toEdit")
    @RequiresPermissions("mobile:biddingManagement:list")
    public String bmDetails(HttpServletRequest req){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        if(admin.getSupplierId() != null){
            TbSupplier supplier = supplierService.selSupplierById(admin.getSupplierId());
            admin.setSupplierName(supplier.getName());
        }
        List<ChoseAdminVO> admins = adminService.selectAdmin();
        List<ChoseSupplierVO> suppliers = supplierService.selectSupplier();
        List<ChoseAreaVO> areas = adminService.selectArea();
        req.setAttribute("admins", JSON.toJSONString(admins));
        req.setAttribute("admin", admin);
        req.setAttribute("suppliers", JSON.toJSONString(suppliers));
        req.setAttribute("areas", JSON.toJSONString(areas));
        String id = req.getParameter("id");
        BiddingManagementVo bmVo = new BiddingManagementVo();
        if(!StringUtils.isEmpty(id)){
            bmVo = bmService.selBiddingManagementOrder(id);
        }
        req.setAttribute("bmVo",bmVo);
        return "page/mobile/biddingManagement/from";

    }

    @SysLog(value="获取投标管理数据")
    @RequestMapping("getBMList")
    @RequiresPermissions("mobile:biddingManagement:list")
    @ResponseBody
    public ResultUtil getBMOrderList(Integer page, Integer limit, BiddingManagementSearch search){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        search.setLoginId(admin.getId());
        return bmService.getBiddingManagementOrderList(page,limit,search);
    }


    @SysLog(value="新增投标管理")
    @RequestMapping("addBMOrder")
    @RequiresPermissions("mobile:biddingManagement:save")
    @ResponseBody
    public ResultUtil addBMOrder(BizBiddingManagement order){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        order.setCreateUser(admin.getId());
        return bmService.saveBiddingManagementOrder(order);
    }


    @SysLog(value="编辑投标管理")
    @RequestMapping("editBMOrder")
    @RequiresPermissions("mobile:biddingManagement:update")
    @ResponseBody
    public ResultUtil editBMOrder(BizBiddingManagement order){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        order.setCreateUser(admin.getId());
        return bmService.saveBiddingManagementOrder(order);
    }
}
