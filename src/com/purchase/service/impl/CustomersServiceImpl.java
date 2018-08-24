package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.purchase.mapper.admin.TbAreaMapper;
import com.purchase.mapper.admin.TbCustomersMapper;
import com.purchase.pojo.admin.TbArea;
import com.purchase.pojo.admin.TbAreaExample;
import com.purchase.pojo.admin.TbCustomers;
import com.purchase.pojo.admin.TbCustomersExample;
import com.purchase.service.CustomersService;
import com.purchase.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomersServiceImpl implements CustomersService {
	@Autowired
	private TbCustomersMapper customersMapper;

	@Autowired
    private TbAreaMapper areaMapper;

    @Override
    public boolean checkCustomersFullName(TbCustomers customers) {
        TbCustomersExample example = new TbCustomersExample();
        com.purchase.pojo.admin.TbCustomersExample.Criteria criteria = example.createCriteria();
        criteria.andFullNameEqualTo(customers.getFullName());
        if(customers.getId() != null){
            criteria.andIdNotEqualTo(customers.getId());
        }
        List<TbCustomers> checkCustomers = customersMapper.selectByExample(example);
        if (checkCustomers != null && checkCustomers.size() > 0) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void editCustomers(TbCustomers customers) {
        if(customers.getId() != null){
            customersMapper.updateByPrimaryKey(customers);
        }else{
            customers.setAddDate(new Date());
            customersMapper.insert(customers);
        }
    }

    @Override
    public TbCustomers findById(Long id) {
        return customersMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TbCustomers> getCustomersList() {
        List<TbCustomers> list = customersMapper.selectByExample(null);
        return list;
        // return customersMapper.getCustomersList();
    }

    @Override
	public ResultUtil selCustomers(Integer page, Integer limit) {
		
		PageHelper.startPage(page, limit);
		TbCustomersExample example = new TbCustomersExample();
		List<TbCustomers> list = customersMapper.selectByExample(example);
		// 将areaName写进TbCustomers
        List<TbArea> areas = areaMapper.selectByExample(new TbAreaExample());
		for (TbCustomers customers : list) {
			for (TbArea area : areas) {
				if (area.getId() == customers.getArea()) {
                    customers.setAreaName(area.getName());
				}
			}
		}
		PageInfo<TbCustomers> pageInfo = new PageInfo<TbCustomers>(list);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCode(0);
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		return resultUtil;
	}

}
