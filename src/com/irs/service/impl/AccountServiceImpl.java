package com.irs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irs.mapper.admin.TbUsersMapper;
import com.irs.pojo.admin.TbUsers;
import com.irs.pojo.admin.TbUsersExample;
import com.irs.pojo.admin.TbUsersExample.Criteria;
import com.irs.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private TbUsersMapper tbUsersMapper;

	@Override
	public TbUsers selUserByCodeAndStatus(String eCode,String status) {
		TbUsersExample example=new TbUsersExample();
		Criteria criteria = example.createCriteria();
		criteria.andECodeEqualTo(eCode);
		criteria.andStatusEqualTo(status);
		List<TbUsers> users = tbUsersMapper.selectByExample(example);
		if(users!=null&&users.size()>0){
			return users.get(0);
		}
		return null;
	}

	@Override
	public void updUserStatus(TbUsers user) {
		tbUsersMapper.updateByPrimaryKey(user);
	}

}
