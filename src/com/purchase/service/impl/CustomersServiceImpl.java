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
import com.purchase.vo.admin.CustomersSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
	public ResultUtil selCustomers(Integer page, Integer limit, CustomersSearch search) {
		
		PageHelper.startPage(page, limit);
		TbCustomersExample example = new TbCustomersExample();
        example.setOrderByClause("add_date DESC");
        TbCustomersExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(search.getName())){
            //注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
            criteria.andFullNameLike("%"+search.getName()+"%");
            /*criteria.andShortNameLike("%"+search.getName()+"%");*/
        }
        if(search.getAreaId() != null){
            List<Long> areas = areaMapper.getAreaListById(search.getAreaId());
            criteria.andAreaIn(areas);
        }

        if(search.getIsForce() != null){
            criteria.andIsForceEqualTo(search.getIsForce());
        }

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
