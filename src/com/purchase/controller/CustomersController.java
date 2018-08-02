package com.purchase.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.purchase.service.CustomersService;
import com.purchase.util.ResultUtil;

@Controller
@RequestMapping("customers")
public class CustomersController {
	
	private static Logger logger = LoggerFactory.getLogger(CustomersController.class);
	
	@Autowired
	private CustomersService customersService;
	
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
		return customersService.selCustomers(page, limit);
	}
}
