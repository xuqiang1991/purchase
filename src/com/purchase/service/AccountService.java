package com.purchase.service;

import com.purchase.pojo.admin.TbUsers;

public interface AccountService {
	
	//根据eCode和status查询用户
	public TbUsers selUserByCodeAndStatus(String eCode,String status);

	//更新用户状态
	public void updUserStatus(TbUsers user);
}
