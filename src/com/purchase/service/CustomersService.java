package com.purchase.service;

import com.purchase.pojo.admin.TbCustomers;
import com.purchase.util.ResultUtil;

public interface CustomersService {
    /**
     * 获取客户集合
     * @param page
     * @param limit
     * @return
     */
	ResultUtil selCustomers(Integer page, Integer limit);

    /**
     * 检查客户名称是否唯一
     * @param customers
     * @return
     */
	boolean checkCustomersFullName(TbCustomers customers);

    /**
     * 新增/更新客户
     */
	void editCustomers(TbCustomers customers);

    /**
     * 根据ID查询客户信息
     * @param id
     * @return
     */
	TbCustomers findById(Long id);
}
