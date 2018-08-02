package com.purchase.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.purchase.mapper.admin.TbCustomersMapper;
import com.purchase.pojo.admin.TbCustomers;
import com.purchase.pojo.admin.TbCustomersExample;
import com.purchase.service.CustomersService;
import com.purchase.util.ResultUtil;

@Service
public class CustomersServiceImpl implements CustomersService {
	@Autowired
	private TbCustomersMapper customersMapper;

	@Override
	public ResultUtil selCustomers(Integer page, Integer limit) {
		
		PageHelper.startPage(page, limit);
		TbCustomersExample example = new TbCustomersExample();
		List<TbCustomers> list = customersMapper.selectByExample(example);
//		// 将roleName写进TbAdmin
//		for (TbCustomers tbAdmin : list) {
//			// tbAdmin.setRoleName();
//			List<TbRoles> roles = selRoles();
//			for (TbRoles tbRole : roles) {
//				if (tbRole.getRoleId() == tbAdmin.getRoleId()) {
//					tbAdmin.setRoleName(tbRole.getRoleName());
//				}
//			}
//		}
		PageInfo<TbCustomers> pageInfo = new PageInfo<TbCustomers>(list);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCode(0);
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		return resultUtil;
	}

}
