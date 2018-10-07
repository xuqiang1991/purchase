package com.purchase.controller.mobile;

import com.alibaba.fastjson.JSON;
import com.purchase.annotation.SysLog;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbArea;
import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.service.*;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.ChoseAdminVO;
import com.purchase.vo.admin.ChoseDeptVO;
import com.purchase.vo.admin.ChoseProjectVO;
import com.purchase.vo.admin.ChoseSupplierVO;
import com.purchase.vo.order.BiddingManagementSearch;
import com.purchase.vo.order.BiddingManagementVo;
import com.purchase.vo.order.UCAMSearch;
import com.purchase.vo.order.UCAMVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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


    @SysLog(value="进入投标管理")
    @RequestMapping("list")
    @RequiresPermissions("mobile:biddingManagement:list")
    public String list(HttpServletRequest req){
        List<ChoseAdminVO> admins = adminService.selectAdmin();
        List<ChoseSupplierVO> suppliers = supplierService.selectSupplier();
        List<ChoseDeptVO> depts = adminService.selectDeptAdmin();
        List<ChoseProjectVO> projects = projectMangerService.selectProjectManger();
        req.setAttribute("projects", JSON.toJSONString(projects));
        req.setAttribute("admins", JSON.toJSONString(admins));
        req.setAttribute("suppliers", JSON.toJSONString(suppliers));
        req.setAttribute("depts", JSON.toJSONString(depts));
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
        logger.info("------:{}", JSON.toJSONString(admins));
        List<TbProjectManger> projectMangerList = projectMangerService.selectProjectMangerExample();
        req.setAttribute("admins", JSON.toJSONString(admins));
        req.setAttribute("admin", admin);
        req.setAttribute("pmItem",JSON.toJSONString(projectMangerList));
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
        return bmService.getBiddingManagementOrderList(page,limit,search);
    }

}
