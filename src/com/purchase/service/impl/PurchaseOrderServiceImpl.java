package com.purchase.service.impl;

import com.purchase.mapper.order.TbPurchaseOrderDetailMapper;
import com.purchase.mapper.order.TbPurchaseOrderMapper;
import com.purchase.pojo.order.TbPurchaseOrder;
import com.purchase.service.PurchaseOrderService;
import com.purchase.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private TbPurchaseOrderDetailMapper purchaseOrderDetailMapper;

	@Autowired
	private TbPurchaseOrderMapper purchaseOrderMapper;


	@Override
	public ResultUtil getOrderList(Integer page, Integer limit, TbPurchaseOrder order) {
		return null;
	}
}
