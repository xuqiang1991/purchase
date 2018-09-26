package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.admin.TbSupplierMapper;
import com.purchase.mapper.order.BizContractApplyMoneyMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizContractApplyMoney;
import com.purchase.pojo.order.BizContractApplyMoneyExample;
import com.purchase.pojo.order.BizPurchaseOrderExample;
import com.purchase.service.CAMService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.order.BizPurchaseOrderVo;
import com.purchase.vo.order.CAMSearch;
import com.purchase.vo.order.CAMVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        PageHelper.startPage(page, limit);

        BizContractApplyMoneyExample example=new BizContractApplyMoneyExample();
        //设置按创建时间降序排序
        example.setOrderByClause("update_date DESC");
        BizContractApplyMoneyExample.Criteria criteria = example.createCriteria();

        if(StringUtils.isNotEmpty(search.getOrderNo())){
            //注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
            criteria.andOrderNoLike("%"+search.getOrderNo()+"%");
        }
        if(StringUtils.isNotBlank(search.getOrderType())){
            criteria.andOrderTypeEqualTo(search.getOrderType());
        }
        if(search.getSupplierId() != null){
            criteria.andSupplierIdEqualTo(search.getSupplierId());
        }

        if(search.getStartCreateTime() != null){
            criteria.andCreateTimeGreaterThanOrEqualTo(search.getStartCreateTime());
        }
        if(search.getEndCreateTime() != null){
            criteria.andCreateTimeLessThanOrEqualTo(search.getEndCreateTime());
        }

        List<CAMVo> users = camMapper.selectByExampleExt(example, search);
        PageInfo<CAMVo> pageInfo = new PageInfo<>(users);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
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
