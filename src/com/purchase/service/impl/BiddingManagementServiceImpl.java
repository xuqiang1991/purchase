package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.admin.TbAreaMapper;
import com.purchase.mapper.order.BizBiddingManagementMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizBiddingManagement;
import com.purchase.pojo.order.BizBiddingManagementExample;
import com.purchase.service.BiddingManagementService;
import com.purchase.util.DateUtil;
import com.purchase.util.ResultUtil;
import com.purchase.util.WebUtils;
import com.purchase.vo.order.BiddingManagementSearch;
import com.purchase.vo.order.BiddingManagementVo;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/24 21:20
 * @Description:投标管理service层
 */
@Service
public class BiddingManagementServiceImpl implements BiddingManagementService {
    private static Logger logger = LoggerFactory.getLogger(BiddingManagementServiceImpl.class);

    @Autowired
    private BizBiddingManagementMapper bmMapper;

    @Autowired
    private TbAdminMapper adminMapper;

    @Autowired
    private TbAreaMapper areaMapper;


    @Override
    public ResultUtil getBiddingManagementOrderList(Integer page, Integer limit, BiddingManagementSearch search) {
        PageHelper.startPage(page, limit);

        BizBiddingManagementExample example = new BizBiddingManagementExample();
        //设置按创建时间降序排序
        example.setOrderByClause("create_time DESC");
        BizBiddingManagementExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(search.getOrderNo())){
            //注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
            criteria.andOrderNoLike("%"+search.getOrderNo()+"%");
        }

        if(search.getSupplierId() != null){
            criteria.andCustomersIdEqualTo(search.getSupplierId());
        }


        if(!StringUtils.isEmpty(search.getProjectName())){
            criteria.andProjectNameLike("%"+search.getProjectName()+"%");
        }

        if(search.getAreaId() != null){
            criteria.andAreaIdEqualTo(search.getAreaId());
        }

        if(search.getCreateUser() != null){
            criteria.andCreateUserEqualTo(search.getCreateUser());
        }

        if(search.getStartCreateTime() != null){
            criteria.andCreateTimeGreaterThanOrEqualTo(search.getStartCreateTime());
        }

        if(search.getEndCreateTime() != null){
            criteria.andCreateTimeLessThanOrEqualTo(search.getStartCreateTime());
        }

        if(search.getOpenBidInfo() != null){
            criteria.andOpenBidInfoEqualTo(search.getOpenBidInfo());
        }

        if(search.getBidCause() != null){
            criteria.andBidCauseEqualTo(search.getBidCause());
        }

        List<BiddingManagementVo> bmList = bmMapper.selectByExampleExt(example,search);
        PageInfo<BiddingManagementVo> pageInfo = new PageInfo<>(bmList);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public ResultUtil saveBiddingManagementOrder(BizBiddingManagement order) {
        Date date = new Date();
        if(StringUtils.isEmpty(order.getId())){
            order.setId(WebUtils.generateUUID());
            //生成合同订单号
            String yyddmm = DateUtil.formatDate(date,DateUtil.DateFormat8);
            String maxNo = bmMapper.selMaxNo(yyddmm);
            if(StringUtils.isEmpty(maxNo)){
                maxNo = "0";
            }else{
                maxNo = maxNo.substring(maxNo.length() - 4);
            }
            maxNo = String.format("%04d", Integer.parseInt(maxNo) + 1);
            String ucamNo = "[" + yyddmm + "]-" + maxNo;

            order.setOrderNo(ucamNo);
            //参数补充
            order.setCreateTime(date);
            bmMapper.insertSelective(order);
        }else{
            bmMapper.updateByPrimaryKeySelective(order);
        }
        return ResultUtil.ok();
    }

    @Override
    public BiddingManagementVo selBiddingManagementOrder(String id) {
        BizBiddingManagementExample example = new BizBiddingManagementExample();
        //设置按创建时间降序排序
        example.setOrderByClause("create_time DESC");
        BizBiddingManagementExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        BiddingManagementSearch search = new BiddingManagementSearch();
        search.setId(id);
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        search.setLoginId(admin.getId());
        List<BiddingManagementVo> ucamList = bmMapper.selectByExampleExt(example,search);
        if(!CollectionUtils.isEmpty(ucamList)){
            return ucamList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public ResultUtil selBiddingManagementOrderByOrder(String orderNo) {
        BizBiddingManagementExample example = new BizBiddingManagementExample();
        BizBiddingManagementExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        BiddingManagementSearch search = new BiddingManagementSearch();
        search.setId(orderNo);
        List<BiddingManagementVo> list = bmMapper.selectByExampleExt(example,search);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        if(!CollectionUtils.isEmpty(list)){
            resultUtil.setData(list.get(0));
        }
        return resultUtil;
    }

    @Override
    public ResultUtil delBiddingManagementOrder(String id) {
        bmMapper.deleteByPrimaryKey(id);
        return ResultUtil.ok();
    }
}
