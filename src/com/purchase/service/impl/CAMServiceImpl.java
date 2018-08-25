package com.purchase.service.impl;

import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.admin.TbSupplierMapper;
import com.purchase.mapper.order.BizContractApplyMoneyMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizContractApplyMoney;
import com.purchase.service.CAMService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.order.CAMSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/24 21:20
 * @Description:合同内请款单service层
 */
@Service
public class CAMServiceImpl implements CAMService {

    private static Logger logger = LoggerFactory.getLogger(CAMServiceImpl.class);

    @Autowired
    private BizContractApplyMoneyMapper camMapper;

    @Autowired
    private TbSupplierMapper supplierMapper;

    @Autowired
    private TbAdminMapper adminMapper;


    @Override
    public ResultUtil getCAMOrderList(Integer page, Integer limit, CAMSearch search) {
        return null;
    }

    @Override
    public ResultUtil addCAMOrder(BizContractApplyMoney order) {
        return null;
    }

    @Override
    public ResultUtil editCAMOrder(BizContractApplyMoney order) {
        return null;
    }

    @Override
    public ResultUtil selCAMOrder(String orderNo) {
        return null;
    }

    @Override
    public ResultUtil delCAMOrder(String id) {
        return null;
    }

    @Override
    public ResultUtil submitCAMOrder(String id) {
        return null;
    }

    @Override
    public ResultUtil reviewCAMOrder(TbAdmin admin, String id) {
        return null;
    }
}
