package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.purchase.mapper.order.BizPaymentOrderMapper;
import com.purchase.pojo.order.BizPaymentOrder;
import com.purchase.pojo.order.BizPaymentOrderExample;
import com.purchase.service.PaymentOrderService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.order.BizPaymentOrderSearch;
import com.purchase.vo.order.BizPaymentOrderVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: xuqiang
 * @Date: 2018/10/7
 * @Description:付款
 */
@Service
public class PaymentOrderServiceImpl implements PaymentOrderService {
    private static Logger logger = LoggerFactory.getLogger(PaymentOrderServiceImpl.class);

    @Autowired
    private BizPaymentOrderMapper bizPaymentOrderMapper;

    @Override
    public ResultUtil getOrderList(Integer page, Integer limit, BizPaymentOrderSearch search) {
        PageHelper.startPage(page, limit);

        BizPaymentOrderExample example=new BizPaymentOrderExample();
        //设置按创建时间降序排序
        example.setOrderByClause("create_time DESC");
        BizPaymentOrderExample.Criteria criteria = example.createCriteria();

        if(StringUtils.isNotEmpty(search.getOrderNo())){
            //注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
            criteria.andOrderNoLike("%"+search.getOrderNo()+"%");
        }
        if(search.getSupplierId() != null){
            criteria.andSupplierIdEqualTo(search.getSupplierId());
        }
        if(StringUtils.isNotBlank(search.getProjectId())){
            criteria.andProjectIdEqualTo(search.getProjectId());
        }
        if(search.getCreateUser() != null){
            criteria.andCreateUserEqualTo(search.getCreateUser());
        }
        if(search.getCreateTime() != null){
            criteria.andCreateTimeEqualTo(search.getCreateTime());
        }

        List<BizPaymentOrderVo> users = bizPaymentOrderMapper.selectByExampleExt(example, search);
        PageInfo<BizPaymentOrderVo> pageInfo = new PageInfo<>(users);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public BizPaymentOrderVo getPaymentOrderDetails(String id) {
        BizPaymentOrderExample example=new BizPaymentOrderExample();
        BizPaymentOrderExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        BizPaymentOrderSearch search = new BizPaymentOrderSearch();
        List<BizPaymentOrderVo> users = bizPaymentOrderMapper.selectByExampleExt(example, search);
        return users.get(0);
    }

    @Override
    public ResultUtil editPaymentOrder(BizPaymentOrder order) {
        bizPaymentOrderMapper.updateByPrimaryKeySelective(order);
        return ResultUtil.ok();
    }
}
