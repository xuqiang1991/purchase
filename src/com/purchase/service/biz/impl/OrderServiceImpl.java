package com.purchase.service.biz.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.purchase.mapper.admin.TbRolesMapper;
import com.purchase.mapper.biz.BizOrderDetailMapper;
import com.purchase.mapper.biz.BizOrderMapper;
import com.purchase.mapper.order.BizHistoryMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbRoles;
import com.purchase.pojo.biz.BizOrder;
import com.purchase.pojo.biz.BizOrderDetail;
import com.purchase.pojo.biz.BizOrderDetailExample;
import com.purchase.pojo.biz.BizOrderExample;
import com.purchase.pojo.order.BizHistory;
import com.purchase.pojo.order.BizHistoryExample;
import com.purchase.pojo.order.BizPurchaseOrderDetail;
import com.purchase.service.biz.OrderService;
import com.purchase.util.*;
import com.purchase.vo.Search.BizOrderDetailSearch;
import com.purchase.vo.Search.BizOrderSearch;
import com.purchase.vo.biz.BizOrderVo;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @Title: OrderServiceImpl
 * @ProjectName purchase
 * @Description: 订单业务实现类
 * @author zhoujb
 * @date 2019-03-0614:18
 */
@Service
public class OrderServiceImpl implements OrderService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BizOrderMapper orderMapper;

    @Autowired
    private BizOrderDetailMapper orderDetailMapper;

    @Autowired
    private BizHistoryMapper historyMapper;

    @Autowired
    private TbRolesMapper rolesMapper;

    @Override
    public ResultUtil getList(Integer page, Integer limit, BizOrderSearch search) {
        /*单号、订单类型、供应商、所属项目、合同号、开单人、开单日期、单据状态单号、订单类型、供应商、所属项目、合同号、开单人、开单日期、单据状态*/
        PageHelper.startPage(page, limit);

        BizOrderExample example=new BizOrderExample();
        //设置按创建时间降序排序
        example.setOrderByClause("update_date DESC");
        BizOrderExample.Criteria criteria = example.createCriteria();

        if(StringUtils.isNotEmpty(search.getPurchaseNo())){
            //注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
            criteria.andOrderNoLike("%"+search.getPurchaseNo()+"%");
        }
        if(search.getType() != null){
            criteria.andTypeEqualTo(String.valueOf(search.getType()));
        }
        if(search.getSupplierId() != null){
            criteria.andSupplierIdEqualTo(search.getSupplierId());
        }
        if(StringUtils.isNotBlank(search.getProjectId())){
            criteria.andProjectIdEqualTo(search.getProjectId());
        }
        if(StringUtils.isNotBlank(search.getContractNo())){
            criteria.andContractNoLike("%"+search.getContractNo()+"%");
        }
        if(search.getCreateUser() != null){
            criteria.andCreateUserEqualTo(search.getCreateUser());
        }
        if(search.getCreateTime() != null){
            criteria.andCreateTimeEqualTo(search.getCreateTime());
        }
        if(search.getStatus()!= null){
            criteria.andStatusEqualTo(search.getStatus());
        }

        List<BizOrderVo> users = orderMapper.selectByExampleExt(example, search);
        PageInfo<BizOrderVo> pageInfo = new PageInfo<>(users);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public ResultUtil save(BizOrder order,TbAdmin admin) {
        Date date = new Date();
        String id = null;
        if(StringUtils.isBlank(order.getId())){
            id = WebUtils.generateUUID();
            order.setId(id);
            //生成合同订单号
            String prefix = OrderUtils.PREFIX_PO + DateUtil.formatDate(date,DateUtil.DateFormat3);
            String pn = orderMapper.selMaxOrderNo(prefix);
            String maxNo = PurchaseUtil.generatePurchaseNo(pn);
            order.setOrderNo(maxNo);

            //参数补充
            order.setCreateTime(date);
            order.setCreateUser(admin.getId());
            order.setStatus(OrderUtils.STATUS_0);
            order.setLastReviewUser(order.getCreateUser());
            order.setLastReviewDate(new Date());
            order.setIsApproval(OrderUtils.IS_APPROVAL_NO);
            orderMapper.insertSelective(order);
        }else {
            id = order.getId();
            order.setUpdateDate(date);
            order.setStatus(OrderUtils.STATUS_0);
            order.setLastReviewUser(order.getCreateUser());
            order.setLastReviewDate(new Date());
            orderMapper.updateByPrimaryKeySelective(order);
        }
        return ResultUtil.ok(id);
    }

    @Override
    public BizOrderVo selInfo(String id, Long adminId) {
        BizOrderSearch search = new BizOrderSearch();
        search.setLoginId(adminId);
        BizOrderVo vo = new BizOrderVo();
        BizOrderExample example = new BizOrderExample();
        BizOrderExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<BizOrderVo> list = orderMapper.selectByExampleExt(example,search);
        if(!CollectionUtils.isEmpty(list)){
            vo = list.get(0);

            BizHistoryExample historyExample = new BizHistoryExample();
            BizHistoryExample.Criteria historyCriteria = historyExample.createCriteria();
            historyCriteria.andOrderIdEqualTo(id);
            List<BizHistory> historyList = historyMapper.selectByExample(historyExample);
            if(!CollectionUtils.isEmpty(historyList)){
                vo.setHistoryList(historyList);
            }
        }
        return vo;
    }

    @Override
    public ResultUtil delOrder(String id) {
        /*BizOrder order = orderMapper.selectByPrimaryKey(id);
        if(!(PurchaseUtil.STATUS_0 == order.getStatus())){
            return ResultUtil.error("非未提交状态的合同订单不能删除！");
        }*/


        BizOrderDetailExample example = new BizOrderDetailExample();
        example.createCriteria().andOrderIdEqualTo(id);
        orderDetailMapper.deleteByExample(example);
        orderMapper.deleteByPrimaryKey(id);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil submit(String id, Long userId, Long roleId) {
        ResultUtil ru = new ResultUtil();
        BizOrder order = orderMapper.selectByPrimaryKey(id);
        if(order == null){
            ru = ResultUtil.error("订单不存在");
        }else{
            TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
            BizOrder tmp = new BizOrder();
            tmp.setId(order.getId());
            tmp.setIsApproval(OrderUtils.IS_APPROVAL_YES);
            tmp.setLastReviewDate(new Date());
            //tmp.setLastReviewRole(order.getLastReviewRole());
            tmp.setLastReviewUser(admin.getId());
            tmp.setNextReviewRole(roleId);
            tmp.setNextReviewUser(userId);
            tmp.setUpdateDate(new Date());
            tmp.setApplyDate(new Date());
            tmp.setUserItem(OrderUtils.getUserItem(order.getUserItem(),String.valueOf(userId)));
            orderMapper.updateByPrimaryKeySelective(tmp);

            BizHistory history = new BizHistory();
            history.setId(WebUtils.generateUUID());
            history.setIsApproval(OrderUtils.IS_APPROVAL_YES);
            history.setOrderId(order.getId());
            history.setApprovalDate(new Date());
            history.setApprovalUser(admin.getId());
            history.setApprovalUserName(admin.getFullname());
            TbRoles roles = rolesMapper.selectByPrimaryKey(order.getLastReviewRole());
            if(roles != null){
                history.setApprovalRoleName(roles.getRoleName());
            }
            history.setOpinion("提交审核");
            historyMapper.insert(history);
            ru = ResultUtil.ok(order);
        }

        return ru;
    }

    @Override
    public ResultUtil review(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion, Long applyRole) {
        return null;
    }

    @Override
    public ResultUtil invalid(TbAdmin admin) {
        return null;
    }

    @Override
    public ResultUtil saveItem(BizPurchaseOrderDetail order) {
        return null;
    }

    @Override
    public ResultUtil delItem(String itemId) {
        return null;
    }

    @Override
    public ResultUtil getItem(String itemId) {
        return null;
    }

    @Override
    public ResultUtil getItemList(BizOrderDetailSearch search) {
        BizOrderDetailExample example = new BizOrderDetailExample();
        BizOrderDetailExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(search.getOrderId());

        List<BizOrderDetail> detailList = orderDetailMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(detailList)){
            detailList.add(new BizOrderDetail(WebUtils.generateUUID()));
        }

        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setData(detailList);
        return resultUtil;
    }

    @Override
    public ResultUtil saveItemList(List<BizOrderDetail> list, String orderId,TbAdmin admin) {
        logger.info("list:{}", JSON.toJSONString(list));
        if(!CollectionUtils.isEmpty(list)){
            //先删除之前的明细
            BizOrderDetailExample example = new BizOrderDetailExample();
            example.createCriteria().andOrderIdEqualTo(orderId);
            orderDetailMapper.deleteByExample(example);

            //保存此次明细
            //BigDecimal applyPrice = new BigDecimal(0.00);
            for (BizOrderDetail detail: list) {
                detail.setId(WebUtils.generateUUID());
                detail.setOrderId(orderId);
                //计算总金额
                /*if(detail.getTotalPrice() != null){
                    applyPrice = applyPrice.add(detail.getTotalPrice());
                }*/
                orderDetailMapper.insert(detail);
            }

            /*BizOrder order = orderMapper.selectByPrimaryKey(orderId);
            orderMapper.updateByPrimaryKeySelective(order);*/

        }
        return ResultUtil.ok();
    }
}
