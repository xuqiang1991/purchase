package com.purchase.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.purchase.annotation.SysLog;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbArea;
import com.purchase.pojo.admin.TbCustomers;
import com.purchase.service.AdminService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.purchase.service.CustomersService;
import com.purchase.util.ResultUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomersController {
	
	private static Logger logger = LoggerFactory.getLogger(CustomersController.class);
	
	@Autowired
	private CustomersService customersService;

	@Autowired
	private AdminService adminServiceImpl;

	@RequestMapping(value="/customersList")
	@RequiresPermissions("sys:customers:list")
	public String list() {
		logger.info("进入客户管理列表页面");
		return "page/customers/customersList";
	}
	
	/**
	 * 客户列表
	 * @return
	 */
	@RequestMapping("/getCustomersList")
	@RequiresPermissions("sys:customers:list")
	@ResponseBody
	public ResultUtil getCustomersList(Integer page,Integer limit) {
		logger.info("请求客户数据");
        ResultUtil result = new ResultUtil();
           try {
                result = customersService.selCustomers(page, limit);
           }catch (Exception e){
               e.printStackTrace();
           }
		return result;
	}

	@RequestMapping(value = "/configCustomers")
	@RequiresPermissions("sys:customers:save")
	public String configCustomers(HttpServletRequest req){
	    TbCustomers customers = new TbCustomers();
	    try {
            String id = req.getParameter("id");
            if(!StringUtils.isEmpty(id)){
                customers = customersService.findById(Long.parseLong(id));
                if(customers.getArea() != null){
                	TbArea area = adminServiceImpl.selAreaById(customers.getArea());
                	customers.setAreaName(area.getName());
				}

            }
            req.setAttribute("customers",customers);
            List<TbArea> areas = adminServiceImpl.selAreaByParentId(null);
            req.setAttribute("areas",areas);
        }catch (Exception e){
	        e.printStackTrace();
        }
		return "page/customers/configCustomers";
	}

    /**
     * 客户名称唯一性检测
     * @param customers
     * @return
     */
    /*@RequestMapping("/checkCustomersFullName")
    @ResponseBody
    public ResultUtil checkCustomersFullName(@RequestBody TbCustomers customers) {
        logger.info("客户名称唯一性检测,入参:{}", JSONUtils.toJSONString(customers));
        boolean flag = customersService.checkCustomersFullName(customers);
        if(flag){
            return new ResultUtil(500,"客户已存在！");
        }
        return new ResultUtil(0);
    }*/

    @SysLog(value="添加客户")
    @RequestMapping("/editCustomers")
    @RequiresPermissions("sys:admin:save")
    @ResponseBody
    public ResultUtil editCustomers(TbCustomers customers) {
        //防止浏览器提交
        boolean flag = customersService.checkCustomersFullName(customers);
        if(flag){
            return new ResultUtil(500,"客户已存在！");
        }
        customersService.editCustomers(customers);
        return ResultUtil.ok();
    }
}
