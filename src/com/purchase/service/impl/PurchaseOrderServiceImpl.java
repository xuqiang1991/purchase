package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.purchase.mapper.order.BizPurchaseOrderDetailMapper;
import com.purchase.mapper.order.BizPurchaseOrderMapper;
import com.purchase.pojo.order.BizPurchaseOrder;
import com.purchase.pojo.order.BizPurchaseOrderExample;
import com.purchase.service.PurchaseOrderService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.order.BizPurchaseOrderVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private BizPurchaseOrderDetailMapper purchaseOrderDetailMapper;

	@Autowired
	private BizPurchaseOrderMapper purchaseOrderMapper;

	@Override
	public ResultUtil getOrderList(Integer page, Integer limit, BizPurchaseOrder order) {
			PageHelper.startPage(page, limit);

			BizPurchaseOrderExample example=new BizPurchaseOrderExample();
			//设置按创建时间降序排序
			example.setOrderByClause("create_time DESC");
			BizPurchaseOrderExample.Criteria criteria = example.createCriteria();

			if(StringUtils.isNotEmpty(order.getPurchaseNo())){
				//注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
				criteria.andPurchaseNoLike("%"+order.getPurchaseNo()+"%");
			}
			if(order.getType() != null){
				criteria.andTypeEqualTo(order.getType());
			}
			if(order.getSupplierId() != null){
				criteria.andSupplierIdEqualTo(order.getSupplierId());
			}

			List<BizPurchaseOrderVo> users = purchaseOrderMapper.selectByExampleExt(example);
			PageInfo<BizPurchaseOrderVo> pageInfo = new PageInfo<>(users);
			ResultUtil resultUtil = new ResultUtil();
			resultUtil.setCode(0);
			resultUtil.setCount(pageInfo.getTotal());
			resultUtil.setData(pageInfo.getList());
			return resultUtil;
	}
}
