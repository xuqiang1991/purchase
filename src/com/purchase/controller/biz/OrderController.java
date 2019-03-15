package com.purchase.controller.biz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.purchase.annotation.SysLog;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.pojo.admin.TbRoles;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.biz.BizOrder;
import com.purchase.pojo.biz.BizOrderDetail;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    @SysLog(value="保存订单")
    @RequestMapping("save")
    @ResponseBody
    public ResultUtil save(BizOrder order){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        //search.setLoginId(admin.getId());
        return orderService.save(order,admin);
    }

    @SysLog(value="提交订单")
    @RequestMapping("submit")
    @ResponseBody
    public ResultUtil submit(String id, Long userId, Long roleId){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        //search.setLoginId(admin.getId());
        return orderService.submit(id,userId,roleId);
    }

    @SysLog(value="获取订单明细数据")
    @RequestMapping("getItemList")
    @ResponseBody
    public ResultUtil getItemList(BizOrderDetailSearch search){
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        //search.setLoginId(admin.getId());
        return orderService.getItemList(search);
    }

    @SysLog(value="保存订单明细数据")
    @RequestMapping("saveItemList")
    @ResponseBody
    public ResultUtil saveItemList(@RequestBody String param){
        logger.info("param:{}", param);
        JSONObject map = JSON.parseObject(param);
        ResultUtil result = new ResultUtil();
        String jsonItem, orderId = "";
        List<BizOrderDetail> list = new ArrayList<>();
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        try {
            if(map.containsKey("orderId") && map.containsKey("list")){
                orderId = map.get("orderId").toString();
                jsonItem = map.get("list").toString();
                list = JSON.parseArray(jsonItem,BizOrderDetail.class);
                logger.info("orderId:{}, jsonItem:{}", orderId,jsonItem);
            }else{
                return ResultUtil.error("网络异常，请稍候再试");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        //search.setLoginId(admin.getId());
        return orderService.saveItemList(list,orderId,admin);
    }


    @SysLog(value="进入提交订单页面")
    @RequestMapping("toSubmit")
    public String toSubmit(HttpServletRequest req, String id, String type){
        logger.info("进入提交订单页面");
        List<TbRoles> roleList = adminService.selRoles();
        req.setAttribute("roleList", roleList);
        req.setAttribute("id", id);
        req.setAttribute("type", type);
        return "page/biz/submitOrder";
    }
}
