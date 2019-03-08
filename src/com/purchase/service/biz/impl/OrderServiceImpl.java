package com.purchase.service.biz.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.purchase.mapper.biz.BizOrderDetailMapper;
import com.purchase.mapper.biz.BizOrderMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.biz.BizOrder;
import com.purchase.pojo.biz.BizOrderDetail;
import com.purchase.pojo.biz.BizOrderDetailExample;
import com.purchase.pojo.biz.BizOrderExample;
import com.purchase.pojo.order.BizPurchaseOrderDetail;
import com.purchase.service.biz.OrderService;
import com.purchase.util.DateUtil;
import com.purchase.util.PurchaseUtil;
import com.purchase.util.ResultUtil;
import com.purchase.util.WebUtils;
import com.purchase.vo.Search.BizOrderDetailSearch;
import com.purchase.vo.Search.BizOrderSearch;
import com.purchase.vo.biz.BizOrderVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private BizOrderMapper orderMapper;

    @Autowired
    private BizOrderDetailMapper orderDetailMapper;

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
    public ResultUtil save(BizOrder order) {
        Date date = new Date();
        String id = null;
        if(StringUtils.isBlank(order.getId())){
            id = WebUtils.generateUUID();
            order.setId(id);
            //生成合同订单号
            String prefix = PurchaseUtil.prefix + DateUtil.formatDate(date,DateUtil.DateFormat3);
            String pn = orderMapper.selMaxOrderNo(prefix);
            String maxNo = PurchaseUtil.generatePurchaseNo(pn);
            order.setOrderNo(maxNo);

            //参数补充
            order.setCreateTime(date);
            order.setUpdateDate(date);

            orderMapper.insertSelective(order);
        }else {
            id = order.getId();
            order.setUpdateDate(date);
            orderMapper.updateByPrimaryKeySelective(order);
        }
        return ResultUtil.ok(id);
    }

    @Override
    public BizOrderVo selInfo(String id, Long adminId) {
        return null;
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
        return null;
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
        List<BizOrderDetail> detailList = new ArrayList<>();
        detailList.add(new BizOrderDetail(WebUtils.generateUUID()));
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setData(detailList);
        return resultUtil;
    }
}
