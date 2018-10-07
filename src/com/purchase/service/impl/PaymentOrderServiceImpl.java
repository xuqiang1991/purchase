package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.purchase.mapper.admin.TbDepartmentMapper;
import com.purchase.mapper.order.BizPaymentOrderMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbDepartment;
import com.purchase.pojo.order.BizPaymentOrder;
import com.purchase.pojo.order.BizPaymentOrderExample;
import com.purchase.pojo.order.BizPurchaseOrder;
import com.purchase.service.PaymentOrderService;
import com.purchase.util.PurchaseUtil;
import com.purchase.util.ResultUtil;
import com.purchase.vo.order.BizPaymentOrderSearch;
import com.purchase.vo.order.BizPaymentOrderVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private TbDepartmentMapper departmentMapper;

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
    public BizPaymentOrderVo getPaymentOrderDetails(String id, TbAdmin admin) {
        BizPaymentOrderExample example=new BizPaymentOrderExample();
        BizPaymentOrderExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        BizPaymentOrderSearch search = new BizPaymentOrderSearch();
        List<BizPaymentOrderVo> users = bizPaymentOrderMapper.selectByExampleExt(example, search);
        BizPaymentOrderVo vo = users.get(0);

        if(admin.getDeptId() != null){
            TbDepartment department = departmentMapper.selectByPrimaryKey(Long.parseLong(admin.getDeptId()));
            if(department != null && "总经理".equals(department.getName())){
                vo.setReviewUserId(admin.getId());
            }
        }

        return vo;
    }

    @Override
    public ResultUtil editPaymentOrder(BizPaymentOrder order) {
        bizPaymentOrderMapper.updateByPrimaryKeySelective(order);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil reviewOrder(TbAdmin admin, String id, Boolean auditResults, String auditOpinion) {
        Date date = new Date();
        BizPaymentOrder order = bizPaymentOrderMapper.selectByPrimaryKey(id);
        Long userId = admin.getId();
        int status = order.getStatus();

        if(status != 0){
            return ResultUtil.error("订单不需要审核");
        }

        TbDepartment department = departmentMapper.selectByPrimaryKey(userId);
        if(!(department != null && "总经理".equals(department.getName()))){
            return ResultUtil.error("没有审核权限!");
        }

        //判断审核人
        Long reviewer = order.getManagerDepartUser();
        Boolean reviewerResults = order.getManagerDepartApproval();

        if(reviewer == null){
            return ResultUtil.error("审核人不存在");
        }
        if(reviewer.compareTo(userId) != 0){
            return ResultUtil.error("没有审核权限！");
        }
        if(reviewerResults != null && reviewerResults){
            return ResultUtil.error("请不要重新审核！");
        }

        //审核状态
        BizPaymentOrder tmp = new BizPaymentOrder();
        tmp.setId(order.getId());
        tmp.setManagerDepartApproval(auditResults);
        tmp.setManagerDepartDate(date);
        tmp.setManagerDepartOpinion(auditOpinion);
        tmp.setManagerDepartUser(userId);
        //审核不通过
        if(!auditResults){
            tmp.setStatus(0);
        }
        bizPaymentOrderMapper.updateByPrimaryKeySelective(tmp);

        return ResultUtil.ok();

    }
}
