package com.purchase.service.impl;

import com.purchase.mapper.order.BizPurchaseOrderDetailMapper;
import com.purchase.mapper.order.BizPurchaseOrderMapper;
import com.purchase.pojo.order.BizPurchaseOrder;
import com.purchase.service.PurchaseOrderService;
import com.purchase.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private BizPurchaseOrderDetailMapper purchaseOrderDetailMapper;

	@Autowired
	private BizPurchaseOrderMapper purchaseOrderMapper;


	@Override
	public ResultUtil getOrderList(Integer page, Integer limit, BizPurchaseOrder order) {
		return null;
	}
}
