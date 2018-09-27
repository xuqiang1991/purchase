package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.admin.TbSupplierMapper;
import com.purchase.mapper.order.BizContractApplyMoneyDetailMapper;
import com.purchase.mapper.order.BizContractApplyMoneyMapper;
import com.purchase.mapper.order.BizPurchaseOrderMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.order.*;
import com.purchase.service.CAMService;
import com.purchase.util.*;
import com.purchase.vo.admin.ChoseAdminVO;
import com.purchase.vo.order.BizPurchaseOrderVo;
import com.purchase.vo.order.CAMDetailsVo;
import com.purchase.vo.order.CAMSearch;
import com.purchase.vo.order.CAMVo;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
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
    private BizContractApplyMoneyDetailMapper contractApplyMoneyDetailMapper;

    @Autowired
    private TbSupplierMapper supplierMapper;

    @Autowired
    private TbAdminMapper adminMapper;

    @Autowired
    private BizPurchaseOrderMapper purchaseOrderMapper;


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
        Date date = new Date();
        String id = WebUtils.generateUUID();
        order.setId(id);
        //生成订单号
        String yyddmm = DateUtil.formatDate(date,DateUtil.DateFormat3);
        String prefix = CAMUtil.prefix + yyddmm;
        String pn = purchaseOrderMapper.selMaxPurchaseNo(prefix);
        String purchaseNo = CAMUtil.generateOrderNo(pn);
        order.setOrderNo(purchaseNo);

        String sourceOrderId = order.getSourceOrderId();
        BizPurchaseOrder purchaseOrder = purchaseOrderMapper.selectByPrimaryKey(sourceOrderId);

        //所属项目
        String projectId = purchaseOrder.getProjectId();
        order.setProjectId(projectId);

        //单据类型
        String type = purchaseOrder.getType();
        order.setOrderType(type);

        //补充参数
        order.setCreateTime(date);

        camMapper.insertSelective(order);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil editCAMOrder(BizContractApplyMoney order) {
        return null;
    }

    @Override
    public CAMDetailsVo selCAMOrder(String id) {
        CAMDetailsVo detailsVo = new CAMDetailsVo();
        //获取请款单
        BizContractApplyMoney order = camMapper.selectByPrimaryKey(id);
        CAMVo vo = new CAMVo();
        BeanUtils.copyProperties(order, vo);

        Long userId = order.getCreateUser();
        TbAdmin tbAdmin = adminMapper.selectByPrimaryKey(userId);
        vo.setAdmin(tbAdmin);

        Long costUserId = order.getCostDepartUser();
        if(costUserId != null){
            TbAdmin costAdmin = adminMapper.selectByPrimaryKey(costUserId);
            vo.setCostAdmin(costAdmin);
        }

        Long projectUserId = order.getProjectDepartUser();
        if(projectUserId != null){
            TbAdmin projectAdmin = adminMapper.selectByPrimaryKey(projectUserId);
            vo.setCostAdmin(projectAdmin);
        }

        Long managerUserId = order.getManagerDepartUser();
        if(managerUserId != null){
            TbAdmin managerAdmin = adminMapper.selectByPrimaryKey(managerUserId);
            vo.setManagerAdmin(managerAdmin);
        }

        Long supplierId = order.getSupplierId();
        if(supplierId != null){
            TbSupplier supplier = supplierMapper.selectByPrimaryKey(supplierId);
            vo.setSupplier(supplier);
        }
        detailsVo.setOrder(vo);

        //获取采购单详情
        String orderNo = vo.getOrderNo();
        BizContractApplyMoneyDetailExample example = new BizContractApplyMoneyDetailExample();
        BizContractApplyMoneyDetailExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<BizContractApplyMoneyDetail> detailList = contractApplyMoneyDetailMapper.selectByExample(example);
        detailsVo.setDetails(detailList);

        //选择审核人
        int status = vo.getStatus();
        String depart = null;
        Long reviewUserId = null;
        if(PurchaseUtil.STATUS_1 == status){
            Long cId = vo.getCostDepartUser();
            if(cId != null){
                reviewUserId = vo.getCostDepartUser();
                depart = "工程部";
            }else {
                depart = "成本部";
            }
        }else if(PurchaseUtil.STATUS_2 == status){
            depart = "工程部";
            reviewUserId = vo.getProjectDepartUser();
        }else if(PurchaseUtil.STATUS_3 == status){
            depart = "总经理";
            reviewUserId = vo.getManagerDepartUser();
        }
        if(depart != null){
            TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
            long loginId = admin.getId();
            if(reviewUserId != null && reviewUserId == loginId){
                detailsVo.setReviewUserId(userId);
                List<ChoseAdminVO> data = adminMapper.selectByDeptName(depart);
                if(!CollectionUtils.isEmpty(data)){
                    Gson gson = new Gson();
                    String json = gson.toJson(data);
                    detailsVo.setDeparts(json);
                }
            }
        }

        return detailsVo;
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
