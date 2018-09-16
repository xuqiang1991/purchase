package com.purchase.service.impl;

import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.admin.TbSupplierMapper;
import com.purchase.mapper.order.BizUncontractApplyMoneyMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizContractApplyMoney;
import com.purchase.pojo.order.BizUncontractApplyMoney;
import com.purchase.service.UCAMService;
import com.purchase.util.DateUtil;
import com.purchase.util.PurchaseUtil;
import com.purchase.util.ResultUtil;
import com.purchase.util.WebUtils;
import com.purchase.vo.order.UCAMSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/24 21:20
 * @Description:合同外请款单service层
 */
@Service
public class UCAMServiceImpl implements UCAMService {

    private static Logger logger = LoggerFactory.getLogger(UCAMServiceImpl.class);

    @Autowired
    private BizUncontractApplyMoneyMapper ucamMapper;

    @Autowired
    private TbSupplierMapper supplierMapper;

    @Autowired
    private TbAdminMapper adminMapper;


    @Override
    public ResultUtil getUCAMOrderList(Integer page, Integer limit, UCAMSearch search) {
        return null;
    }

    @Override
    public ResultUtil addUCAMOrder(BizUncontractApplyMoney order) {
        Date date = new Date();

        String id = WebUtils.generateUUID();
        order.setId(id);

        //生成采购单号
        String yyddmm = DateUtil.formatDate(date,DateUtil.DateFormat3);
        String prefix = PurchaseUtil.prefix + yyddmm;

        //参数补充
        order.setCostDepartDate(date);
        order.setUpdateDate(date);

        ucamMapper.insertSelective(order);

        return ResultUtil.ok();
    }

    @Override
    public ResultUtil editUCAMOrder(BizUncontractApplyMoney order) {
        return null;
    }

    @Override
    public ResultUtil selUCAMOrder(String orderNo) {
        return null;
    }

    @Override
    public ResultUtil delUCAMOrder(String id) {
        return null;
    }

    @Override
    public ResultUtil submitUCAMOrder(String id) {
        return null;
    }

    @Override
    public ResultUtil reviewUCAMOrder(TbAdmin admin, String id) {
        return null;
    }
}
