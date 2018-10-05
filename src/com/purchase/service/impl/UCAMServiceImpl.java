package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.admin.TbSupplierMapper;
import com.purchase.mapper.order.BizUncontractApplyMoneyDetailMapper;
import com.purchase.mapper.order.BizUncontractApplyMoneyMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizUncontractApplyMoney;
import com.purchase.pojo.order.BizUncontractApplyMoneyDetail;
import com.purchase.pojo.order.BizUncontractApplyMoneyDetailExample;
import com.purchase.pojo.order.BizUncontractApplyMoneyExample;
import com.purchase.service.UCAMService;
import com.purchase.util.*;
import com.purchase.vo.OrderHistory;
import com.purchase.vo.admin.ChoseAdminVO;
import com.purchase.vo.order.UCAMOrderDetialVo;
import com.purchase.vo.order.UCAMSearch;
import com.purchase.vo.order.UCAMVo;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private BizUncontractApplyMoneyDetailMapper ucamDetailMapper;

    @Autowired
    private TbSupplierMapper supplierMapper;

    @Autowired
    private TbAdminMapper adminMapper;

    /**
     * 合同外请款单单号前缀
     */
    public static final String UCAM_PREFIX = "NC-";


    @Override
    public ResultUtil getUCAMOrderList(Integer page, Integer limit, UCAMSearch search) {
        PageHelper.startPage(page, limit);

        BizUncontractApplyMoneyExample example = new BizUncontractApplyMoneyExample();
        //设置按创建时间降序排序
        example.setOrderByClause("update_date DESC");
        BizUncontractApplyMoneyExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(search.getOrderNo())){
            //注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
            criteria.andOrderNoLike("%"+search.getOrderNo()+"%");
        }

        if(!StringUtils.isEmpty(search.getOrderType())){
            criteria.andOrderTypeEqualTo(String.valueOf(search.getOrderType()));
        }
        if(search.getSupplierId() != null){
            criteria.andSupplierIdEqualTo(search.getSupplierId());
        }

        if(!StringUtils.isEmpty(search.getProjectId())){
            criteria.andProjectIdEqualTo(search.getProjectId());
        }
        if(search.getInstructOrderFlag() != null){
            criteria.andInstructOrderFlagEqualTo(search.getInstructOrderFlag());
        }

        if(!StringUtils.isEmpty(search.getInstructOrderNo())){
            criteria.andInstructOrderNoLike("%"+search.getInstructOrderNo()+"%");
        }

        if(search.getApplyUser() != null){
            criteria.andApplyUserEqualTo(search.getApplyUser());
        }

        if(search.getCreateUser() != null){
            criteria.andCreateUserEqualTo(search.getCreateUser());
        }
        if(!StringUtils.isEmpty(search.getCreateTime())){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                criteria.andCreateTimeEqualTo(sdf.parse(search.getCreateTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        if(search.getStatus() != null){
            criteria.andStatusEqualTo(search.getStatus());
        }

        List<UCAMVo> ucamList = ucamMapper.selectByExampleExt(example,search);
        PageInfo<UCAMVo> pageInfo = new PageInfo<>(ucamList);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public ResultUtil addUCAMOrder(BizUncontractApplyMoney order) {
        Date date = new Date();

        String id = WebUtils.generateUUID();
        order.setId(id);

        //生成采购单号
        String yyddmm = DateUtil.formatDate(date,DateUtil.DateFormat3);
        String maxNo = ucamMapper.selMaxNo(yyddmm);
        if(StringUtils.isEmpty(maxNo)){
            maxNo = "0";
        }else{
            maxNo = maxNo.substring(maxNo.length() - 3);
        }
        maxNo = String.format("%03d", Integer.parseInt(maxNo) + 1);
        String ucamNo = UCAM_PREFIX + yyddmm + "-" + maxNo;

        order.setOrderNo(ucamNo);
        //参数补充
        order.setCostDepartDate(date);
        order.setUpdateDate(date);
        order.setCreateTime(date);

        ucamMapper.insertSelective(order);

        return ResultUtil.ok();
    }

    @Override
    public ResultUtil editUCAMOrder(BizUncontractApplyMoney order) {
        /*UCAMVo ucamVo = new UCAMVo();
        if(!StringUtils.isEmpty(order.getId())){
            ucamVo = ucamService.selUCAMOrder(id);
        }*/

        return null;
    }

    @Override
    public UCAMVo selUCAMOrder(String id) {
        BizUncontractApplyMoneyExample example = new BizUncontractApplyMoneyExample();
        //设置按创建时间降序排序
        example.setOrderByClause("update_date DESC");
        BizUncontractApplyMoneyExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        UCAMSearch search = new UCAMSearch();
        search.setId(id);
        List<UCAMVo> ucamList = ucamMapper.selectByExampleExt(example,search);
        if(!CollectionUtils.isEmpty(ucamList)){
            return ucamList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public ResultUtil selUCAMOrderByOrder(String orderNo) {
        BizUncontractApplyMoneyExample example = new BizUncontractApplyMoneyExample();
        BizUncontractApplyMoneyExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<BizUncontractApplyMoney> list = ucamMapper.selectByExample(example);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        if(!CollectionUtils.isEmpty(list)){
            resultUtil.setData(list.get(0));
        }
        return resultUtil;
    }

    @Override
    public ResultUtil delUCAMOrder(String id) {
        BizUncontractApplyMoney order = ucamMapper.selectByPrimaryKey(id);
        if(!(PurchaseUtil.STATUS_0 == order.getStatus())){
            return ResultUtil.error("非未提交状态的合同外请款单不能删除！");
        }
        ucamMapper.deleteByPrimaryKey(id);

        BizUncontractApplyMoneyDetailExample example = new BizUncontractApplyMoneyDetailExample();
        example.createCriteria().andOrderNoEqualTo(order.getOrderNo());
        ucamDetailMapper.deleteByExample(example);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil submitUCAMOrder(String id) {
        BizUncontractApplyMoney order = ucamMapper.selectByPrimaryKey(id);

        int status = order.getStatus();
        if(!(PurchaseUtil.STATUS_0 == status)){
            return ResultUtil.error("非未提交状态的合同外请款单不能提交！");
        }

        BizUncontractApplyMoney tmp = new BizUncontractApplyMoney();
        tmp.setId(order.getId());
        tmp.setStatus(PurchaseUtil.STATUS_1);
        ucamMapper.updateByPrimaryKeySelective(tmp);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil reviewUCAMOrder(TbAdmin admin, String id) {
        return null;
    }

    @Override
    public UCAMOrderDetialVo selUCAMDetail(String id) {
        UCAMOrderDetialVo ucamOrderDetialVo = new UCAMOrderDetialVo();
        try {
            BizUncontractApplyMoneyExample example = new BizUncontractApplyMoneyExample();
            BizUncontractApplyMoneyExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            UCAMSearch search = new UCAMSearch();
            search.setId(id);
            List<UCAMVo> ucamList = ucamMapper.selectByExampleExt(example,search);
            UCAMVo vo = new UCAMVo();
            if(!CollectionUtils.isEmpty(ucamList)){
                vo = ucamList.get(0);
            }
            List<OrderHistory> historyList = new ArrayList<OrderHistory>();
            int status = vo.getStatus();
            if(PurchaseUtil.STATUS_0 == status){
                historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,0));
            }else if(PurchaseUtil.STATUS_1 == status){
                historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,0));
                historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,1));
            }else if(PurchaseUtil.STATUS_2 == status){
                historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,0));
                historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,1));
                historyList.add(new OrderHistory(vo.getCostAdmin().getFullname(),vo.getCostDepartDate(),"",vo.getCostDepartApproval(),2));
            }else if(PurchaseUtil.STATUS_3 == status){
                historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,0));
                historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,1));
                historyList.add(new OrderHistory(vo.getCostAdmin().getFullname(),vo.getCostDepartDate(),"",vo.getCostDepartApproval(),2));
                historyList.add(new OrderHistory(vo.getProjectAdmin().getFullname(),vo.getProjectDepartDate(),"",vo.getProjectDepartApproval(),3));
            }else if(PurchaseUtil.STATUS_4 == status){
                historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,0));
                historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,1));
                historyList.add(new OrderHistory(vo.getCostAdmin().getFullname(),vo.getCostDepartDate(),"",vo.getCostDepartApproval(),2));
                historyList.add(new OrderHistory(vo.getProjectAdmin().getFullname(),vo.getProjectDepartDate(),"",vo.getProjectDepartApproval(),3));
                historyList.add(new OrderHistory(vo.getManagerAdmin().getFullname(),vo.getManagerDepartDate(),"",vo.getManagerDepartApproval(),4));
            }
            vo.setHistoryList(historyList);
            ucamOrderDetialVo.setUcamVo(vo);

            //获取合同外请款单详情
            BizUncontractApplyMoneyDetailExample detailExample = new BizUncontractApplyMoneyDetailExample();
            BizUncontractApplyMoneyDetailExample.Criteria detailCriteria = detailExample.createCriteria();
            detailCriteria.andOrderNoEqualTo(vo.getOrderNo());
            List<BizUncontractApplyMoneyDetail> detailList = ucamDetailMapper.selectByExample(detailExample);
            ucamOrderDetialVo.setUcamDetail(detailList);

            //选择审核人
            String depart = null;
            Long reviewUserId = null;
            if(PurchaseUtil.STATUS_1 == vo.getStatus()){
                if(vo.getCostDepartUser() != null){
                    reviewUserId = vo.getCostDepartUser();
                    depart = "工程部";
                }else {
                    depart = "成本部";
                }
            }else if(PurchaseUtil.STATUS_2 == vo.getStatus()){
                depart = "工程部";
                reviewUserId = vo.getProjectDepartUser();
            }else if(PurchaseUtil.STATUS_3 == vo.getStatus()){
                depart = "总经理";
                reviewUserId = vo.getManagerDepartUser();
            }
            if(depart != null){
                List<ChoseAdminVO> data = adminMapper.selectByDeptName(depart);
                if(!CollectionUtils.isEmpty(data)){
                    Gson gson = new Gson();
                    String json = gson.toJson(data);
                    ucamOrderDetialVo.setDeparts(json);
                }
                TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
                long loginId = admin.getId();
                if(reviewUserId != null && reviewUserId == loginId){
                    ucamOrderDetialVo.setReviewUserId(vo.getCreateUser());

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return ucamOrderDetialVo;
    }

    @Override
    public ResultUtil addUCAMOrderDetail(BizUncontractApplyMoneyDetail order) {
        if(StringUtils.isEmpty(order.getId())){
            String id = MyUtil.getStrUUID();
            order.setId(id);
        }else{

        }
        ucamDetailMapper.insert(order);

        //如有金额更新采购单
        if(order.getApplyPrice() != null){
            String orderNo = order.getOrderNo();
            BizUncontractApplyMoneyExample example = new BizUncontractApplyMoneyExample();

            BizUncontractApplyMoneyExample.Criteria criteria = example.createCriteria();
            criteria.andOrderNoEqualTo(orderNo);
            List<BizUncontractApplyMoney> ucamList = ucamMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(ucamList)){
                BizUncontractApplyMoney ucamOrder = ucamList.get(0);
                BigDecimal applyPrice = ucamOrder.getApplyPrice();
                if(applyPrice == null){
                    applyPrice = order.getApplyPrice();
                }else {
                    applyPrice.add(order.getApplyPrice());
                }
                BizUncontractApplyMoney tmp = new BizUncontractApplyMoney();
                tmp.setId(ucamOrder.getId());
                tmp.setApplyPrice(applyPrice);
                tmp.setUpdateDate(order.getUpdateDate());
                ucamMapper.updateByPrimaryKeySelective(tmp);
            }
        }

        return ResultUtil.ok();
    }

    @Override
    public ResultUtil deleteUCAMItem(String id) {
        BizUncontractApplyMoneyDetail ucamDetail = ucamDetailMapper.selectByPrimaryKey(id);
        if(ucamDetail.getApplyPrice() != null){
            String orderNo = ucamDetail.getOrderNo();
            BizUncontractApplyMoneyExample example = new BizUncontractApplyMoneyExample();
            BizUncontractApplyMoneyExample.Criteria criteria = example.createCriteria();
            criteria.andOrderNoEqualTo(orderNo);
            List<BizUncontractApplyMoney> ucamList = ucamMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(ucamList)) {
                BizUncontractApplyMoney ucamOrder = ucamList.get(0);
                BigDecimal applyPrice = ucamDetail.getApplyPrice();
                if(applyPrice == null){
                    applyPrice = BigDecimal.valueOf(0);
                }else {
                    applyPrice = applyPrice.subtract(ucamDetail.getApplyPrice());
                }
                BizUncontractApplyMoney tmp = new BizUncontractApplyMoney();
                tmp.setId(ucamOrder.getId());
                tmp.setApplyPrice(applyPrice);
                tmp.setUpdateDate(new Date());
                ucamMapper.updateByPrimaryKeySelective(tmp);
            }
        }
        ucamDetailMapper.deleteByPrimaryKey(id);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil submitReviewUCAMOrder(TbAdmin admin, String id, Long userId) {
        BizUncontractApplyMoney order = ucamMapper.selectByPrimaryKey(id);

        int status = order.getStatus();
        if(PurchaseUtil.STATUS_1 != status){
            return ResultUtil.error("非未提交状态的合同外请款单不能选择成本部审核！");
        }
        Date date = new Date();
        BizUncontractApplyMoney tmp = new BizUncontractApplyMoney();
        tmp.setId(order.getId());
        tmp.setCostDepartUser(userId);
        tmp.setUpdateDate(date);

        ucamMapper.updateByPrimaryKeySelective(tmp);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil reviewUCAMOrder(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion) {
        Date date = new Date();
        BizUncontractApplyMoney order = ucamMapper.selectByPrimaryKey(id);
        Long userId = admin.getId();

        //判断审核人
        Long reviewer = null;
        Boolean reviewerResults = null;
        if(PurchaseUtil.STATUS_1 ==  order.getStatus()){
            reviewer = order.getCostDepartUser();
            reviewerResults = order.getCostDepartApproval();
        }else if (PurchaseUtil.STATUS_2 ==  order.getStatus()){
            reviewer = order.getProjectDepartUser();
            reviewerResults = order.getProjectDepartApproval();
        }else if (PurchaseUtil.STATUS_3 ==  order.getStatus()){
            reviewer = order.getManagerDepartUser();
            reviewerResults = order.getManagerDepartApproval();
        }
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
        if(PurchaseUtil.STATUS_1 ==  order.getStatus()){
            order.setStatus(PurchaseUtil.STATUS_2);
            order.setCostDepartApproval(auditResults);
            order.setCostDepartDate(date);
            order.setCostDepartOpinion(auditOpinion);
            order.setProjectDepartUser(applyUser);
        }else if (PurchaseUtil.STATUS_2 ==  order.getStatus()){
            order.setStatus(PurchaseUtil.STATUS_3);
            order.setProjectDepartDate(date);
            order.setProjectDepartOpinion(auditOpinion);
            order.setManagerDepartUser(applyUser);
        }else if (PurchaseUtil.STATUS_3 ==  order.getStatus()){
            order.setStatus(PurchaseUtil.STATUS_4);
            order.setManagerDepartDate(date);
            order.setManagerDepartOpinion(auditOpinion);
        }else if (PurchaseUtil.STATUS_4 ==  order.getStatus()){
            order.setStatus(PurchaseUtil.STATUS_5);
        }
        order.setUpdateDate(date);

        ucamMapper.updateByPrimaryKeySelective(order);

        return ResultUtil.ok();
    }
}
