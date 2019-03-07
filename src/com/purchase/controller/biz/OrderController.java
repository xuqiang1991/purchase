package com.purchase.controller.biz;

import com.purchase.annotation.SysLog;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.service.AdminService;
import com.purchase.service.ProjectMangerService;
import com.purchase.service.SupplierService;
import com.purchase.service.biz.OrderService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.Search.BizOrderDetailSearch;
import com.purchase.vo.Search.BizOrderSearch;
import com.purchase.vo.biz.BizOrderVo;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @Autowired
    private OrderService orderService;

    @SysLog(value="进入订单管理列表")
    @RequestMapping("list")
    public String list(HttpServletRequest req){
        List<TbAdmin> adminList = adminService.getAdmins(1);
        req.setAttribute("adminList", adminList);
        List<TbSupplier> supplierList = supplierService.selSuppliersAll();
        req.setAttribute("supplierList", supplierList);
        List<TbProjectManger> projectMangerList = projectMangerService.selectProjectMangerExample();
        req.setAttribute("projectMangerList", projectMangerList);
        return "page/biz/order/list";
    }

    @SysLog(value="获取订单数据")
    @RequestMapping("getList")
    @ResponseBody
    public ResultUtil getList(Integer page, Integer limit, BizOrderSearch search){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        search.setLoginId(admin.getId());
        return orderService.getList(page,limit,search);
    }

    @SysLog(value="进入订单管理详情")
    @RequestMapping("toEdit")
    public String toEdit(HttpServletRequest req){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        BizOrderVo orderVo = new BizOrderVo();
        try {
            String id = req.getParameter("id");
            if(!StringUtils.isEmpty(id)){
                orderVo = orderService.selInfo(id,admin.getId());
            }
            req.setAttribute("orderVo",orderVo);
            req.setAttribute("admin",admin);
            List<TbAdmin> adminList = adminService.getAdmins(1);
            req.setAttribute("adminList", adminList);
            List<TbSupplier> supplierList = supplierService.selSuppliersAll();
            req.setAttribute("supplierList", supplierList);
            List<TbProjectManger> projectMangerList = projectMangerService.selectProjectMangerExample();
            req.setAttribute("projectMangerList", projectMangerList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "page/biz/order/form";

    }

    @SysLog(value="获取订单明细数据")
    @RequestMapping("getItemList")
    @ResponseBody
    public ResultUtil getItemList(BizOrderDetailSearch search){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        //search.setLoginId(admin.getId());
        return orderService.getItemList(search);
    }


}
