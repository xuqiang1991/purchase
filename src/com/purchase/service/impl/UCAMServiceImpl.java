package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.admin.TbRolesMapper;
import com.purchase.mapper.order.BizHistoryMapper;
import com.purchase.mapper.order.BizUncontractApplyMoneyDetailMapper;
import com.purchase.mapper.order.BizUncontractApplyMoneyMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbRoles;
import com.purchase.pojo.order.*;
import com.purchase.service.PaymentOrderService;
import com.purchase.service.UCAMService;
import com.purchase.util.*;
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

    public static final int STATUS_0 = 0;//未提交
    public static final int STATUS_1 = 1;//已提交
    public static final int STATUS_2 = 2;//工程部已审核
    public static final int STATUS_3 = 3;//成本部已审核
    public static final int STATUS_4 = 4;//总经理已审核

    @Autowired
    private BizUncontractApplyMoneyMapper ucamMapper;

    @Autowired
    private BizUncontractApplyMoneyDetailMapper ucamDetailMapper;

    @Autowired
    private TbAdminMapper adminMapper;

    @Autowired
    private TbRolesMapper rolesMapper;

    @Autowired
    private PaymentOrderService paymentOrderService;

    @Autowired
    private BizHistoryMapper historyMapper;


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
        /*if(search.getStatus() != null){
            criteria.andStatusEqualTo(search.getStatus());
        }*/

        List<UCAMVo> ucamList = ucamMapper.selectByExampleExt(example,search);
        PageInfo<UCAMVo> pageInfo = new PageInfo<>(ucamList);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public ResultUtil saveUCAMOrder(BizUncontractApplyMoney order) {
        Date date = new Date();
        String id = null;
        if(StringUtils.isEmpty(order.getId())){
            id = WebUtils.generateUUID();
            order.setId(id);
            String yyddmm = DateUtil.formatDate(date,DateUtil.DateFormat3);
            String maxNo = ucamMapper.selMaxNo(yyddmm);
            if(StringUtils.isEmpty(maxNo)){
                maxNo = "0";
            }else{
                maxNo = maxNo.substring(maxNo.length() - 3);
            }
            maxNo = String.format("%03d", Integer.parseInt(maxNo) + 1);
            order.setOrderNo(UCAM_PREFIX + yyddmm + "-" + maxNo);
            //参数补充
            /*order.setStatus(STATUS_0);*/
            order.setUpdateDate(date);
            order.setCreateTime(date);
            order.setLastReviewUser(order.getCreateUser());
            order.setLastReviewDate(new Date());
            order.setIsSaveSubmit(OrderUtils.IS_SAVE_SUBMIT_0);
            order.setIsApproval(OrderUtils.IS_APPROVAL_NO);
            ucamMapper.insertSelective(order);
        }else{
            id = order.getId();
            order.setIsSaveSubmit(OrderUtils.IS_SAVE_SUBMIT_0);
            order.setIsApproval(OrderUtils.IS_APPROVAL_NO);
            order.setUpdateDate(date);
            ucamMapper.updateByPrimaryKeySelective(order);
        }
        return ResultUtil.ok(id);
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
        UCAMSearch search = new UCAMSearch();
        search.setOrderNo(orderNo);
        List<UCAMVo> list = ucamMapper.selectByExampleExt(example,search);
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
        /*if(!(STATUS_0 == order.getStatus())){
            return ResultUtil.error("非未提交状态的合同外请款单不能删除！");
        }*/
        ucamMapper.deleteByPrimaryKey(id);

        BizUncontractApplyMoneyDetailExample example = new BizUncontractApplyMoneyDetailExample();
        example.createCriteria().andOrderNoEqualTo(order.getOrderNo());
        ucamDetailMapper.deleteByExample(example);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil submitUCAMOrder(String id,Long userId, Long roleId) {
        BizUncontractApplyMoney order = ucamMapper.selectByPrimaryKey(id);
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        BizUncontractApplyMoney tmp = new BizUncontractApplyMoney();
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
        tmp.setIsSaveSubmit(1);
        ucamMapper.updateByPrimaryKeySelective(tmp);

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


        return ResultUtil.ok(order);
    }

   /* @Override
    public ResultUtil reviewUCAMOrder(TbAdmin admin, String id) {
        return null;
    }*/

    @Override
    public UCAMOrderDetialVo selUCAMDetail(String id, Long adminId) {
        UCAMOrderDetialVo ucamOrderDetialVo = new UCAMOrderDetialVo();
        try {
            BizUncontractApplyMoneyExample example = new BizUncontractApplyMoneyExample();
            BizUncontractApplyMoneyExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            UCAMSearch search = new UCAMSearch();
            search.setId(id);
            search.setLoginId(adminId);
            List<UCAMVo> ucamList = ucamMapper.selectByExampleExt(example,search);
            UCAMVo vo = new UCAMVo();
            if(!CollectionUtils.isEmpty(ucamList)){
                vo = ucamList.get(0);
            }
            BizHistoryExample example1 = new BizHistoryExample();
            BizHistoryExample.Criteria criteria1 = example1.createCriteria();
            example1.setOrderByClause("approval_date DESC");
            criteria1.andOrderIdEqualTo(vo.getId());
            List<BizHistory> histories = historyMapper.selectByExample(example1);
            vo.setHistoryList(histories);
            ucamOrderDetialVo.setUcamVo(vo);

            //获取合同外请款单详情
            BizUncontractApplyMoneyDetailExample detailExample = new BizUncontractApplyMoneyDetailExample();
            BizUncontractApplyMoneyDetailExample.Criteria detailCriteria = detailExample.createCriteria();
            detailCriteria.andOrderNoEqualTo(vo.getOrderNo());
            List<BizUncontractApplyMoneyDetail> detailList = ucamDetailMapper.selectByExample(detailExample);
            ucamOrderDetialVo.setUcamDetail(detailList);

            //选择审核人
            String roleName = "工程部";
            Long reviewUserId = null;
            /*switch (vo.getStatus()){
                case STATUS_1:
                    reviewUserId = vo.getProjectDepartUser(); roleName = "成本部";
                    break;
                case STATUS_2:
                    reviewUserId = vo.getCostDepartUser(); roleName = "总经理";
                    break;
                case STATUS_3:
                    reviewUserId = vo.getManagerDepartUser();
                    break;
                default:
                    logger.info("不在处理流程内，不做修改");
                    break;
            }*/
            ucamOrderDetialVo.setReviewUserId(reviewUserId);
            if(roleName != null){
                List<ChoseAdminVO> data = adminMapper.selectByRoleName(roleName);
                if(!CollectionUtils.isEmpty(data)){
                    Gson gson = new Gson();
                    String json = gson.toJson(data);
                    ucamOrderDetialVo.setDeparts(json);
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return ucamOrderDetialVo;
    }

    @Override
    public ResultUtil addUCAMOrderDetail(BizUncontractApplyMoneyDetail order) {
        /*if(StringUtils.isEmpty(order.getId())){
            String id = MyUtil.getStrUUID();
            order.setId(id);
        }else{

        }
        ucamDetailMapper.insert(order);

        //如有金额更新合同订单
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
        }*/

        return ResultUtil.ok();
    }

    @Override
    public ResultUtil editUCAMOrderDetail(BizUncontractApplyMoneyDetail order) {
        if(StringUtils.isEmpty(order.getId())){
            String id = MyUtil.getStrUUID();
            order.setId(id);
            ucamDetailMapper.insert(order);
        }else{
            ucamDetailMapper.updateByPrimaryKeySelective(order);
        }


        //如有金额更新合同订单
        if(order.getApplyPrice() != null){
            String orderNo = order.getOrderNo();
            BizUncontractApplyMoneyDetailExample example = new BizUncontractApplyMoneyDetailExample();
            BizUncontractApplyMoneyDetailExample.Criteria criteria = example.createCriteria();
            criteria.andOrderNoEqualTo(orderNo);
            List<BizUncontractApplyMoneyDetail> details = ucamDetailMapper.selectByExample(example);


            if(!CollectionUtils.isEmpty(details)){
                BigDecimal applyPrice = new BigDecimal(0.00);
                for (BizUncontractApplyMoneyDetail detail : details) {
                    applyPrice = applyPrice.add(detail.getApplyPrice());
                }

                BizUncontractApplyMoney tmp = ucamMapper.selectByOrderNo(orderNo);
                tmp.setApplyPrice(applyPrice);
                tmp.setUpdateDate(new Date());
                ucamMapper.updateByPrimaryKeySelective(tmp);
            }
        }

        return ResultUtil.ok();
    }

    @Override
    public ResultUtil deleteUCAMItem(String id) {
        BizUncontractApplyMoneyDetail ucamDetail = ucamDetailMapper.selectByPrimaryKey(id);
        ucamDetailMapper.deleteByPrimaryKey(id);
        String orderNo = ucamDetail.getOrderNo();
        BizUncontractApplyMoneyDetailExample example = new BizUncontractApplyMoneyDetailExample();
        BizUncontractApplyMoneyDetailExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<BizUncontractApplyMoneyDetail> details = ucamDetailMapper.selectByExample(example);


        if(!CollectionUtils.isEmpty(details)){
            BigDecimal applyPrice = new BigDecimal(0.00);
            for (BizUncontractApplyMoneyDetail detail : details) {
                if(detail.getApplyPrice() != null){
                    applyPrice = applyPrice.add(detail.getApplyPrice());
                }
            }

            BizUncontractApplyMoney tmp = ucamMapper.selectByOrderNo(orderNo);
            tmp.setApplyPrice(applyPrice);
            tmp.setUpdateDate(new Date());
            ucamMapper.updateByPrimaryKeySelective(tmp);
        }

        return ResultUtil.ok();
    }

    @Override
    public ResultUtil selUCAMItem(String id) {
        BizUncontractApplyMoneyDetail detail = ucamDetailMapper.selectByPrimaryKey(id);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setData(detail);
        return resultUtil;
    }

    @Override
    public ResultUtil submitReviewUCAMOrder(TbAdmin admin, String id, Long userId) {
        BizUncontractApplyMoney order = ucamMapper.selectByPrimaryKey(id);

        /*int status = order.getStatus();
        if(STATUS_1 != status){
            return ResultUtil.error("非未提交状态的合同外请款单不能选择成本部审核！");
        }*/
        Date date = new Date();
        BizUncontractApplyMoney tmp = new BizUncontractApplyMoney();
        tmp.setId(order.getId());
        /*tmp.setProjectDepartUser(userId);*/
        tmp.setUpdateDate(date);

        ucamMapper.updateByPrimaryKeySelective(tmp);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil reviewUCAMOrder(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion, Long applyRole) {
        Date date = new Date();
        BizUncontractApplyMoney order = ucamMapper.selectByPrimaryKey(id);
        BizHistory history = new BizHistory();
        history.setId(WebUtils.generateUUID());
        //审核不通过
        if(!auditResults){
            order.setIsSaveSubmit(OrderUtils.IS_SAVE_SUBMIT_0);
            order.setIsApproval(OrderUtils.IS_APPROVAL_NO);
            order.setLastReviewRole(null);
            order.setLastReviewUser(null);
            order.setNextReviewRole(null);
            order.setNextReviewUser(order.getCreateUser());//驳回则还原到创建人
            history.setIsApproval(OrderUtils.IS_APPROVAL_NO);
        }else{
            order.setIsSaveSubmit(OrderUtils.IS_SAVE_SUBMIT_1);
            order.setIsApproval(OrderUtils.IS_APPROVAL_YES);
            order.setLastReviewRole(order.getNextReviewRole());
            order.setLastReviewUser(admin.getId());
            order.setNextReviewUser(applyUser);
            order.setNextReviewRole(applyRole);
            history.setIsApproval(OrderUtils.IS_APPROVAL_YES);
        }
        order.setLastReviewDate(date);
        order.setUserItem(OrderUtils.getUserItem(order.getUserItem(),String.valueOf(applyUser)));
        order.setUpdateDate(date);

        history.setOrderId(order.getId());
        history.setApprovalDate(new Date());
        history.setApprovalUser(admin.getId());
        history.setApprovalUserName(admin.getFullname());
        TbRoles roles = rolesMapper.selectByPrimaryKey(order.getLastReviewRole());
        if(roles != null){
            history.setApprovalRoleName(roles.getRoleName());
        }
        history.setOpinion(auditOpinion);

        //TbRoles nextReviewRole = rolesMapper.selectByPrimaryKey(applyRole);
        //总经理审核写入付款单
        if(auditResults && roles.getIsOverRole() == 1){
            order.setIsSaveSubmit(OrderUtils.IS_SAVE_SUBMIT_2);
            order.setNextReviewUser(null);
            order.setNextReviewRole(null);
            paymentOrderService.generatePaymenyOrder(order);
        }
        ucamMapper.updateByPrimaryKey(order);
        historyMapper.insert(history);
        return ResultUtil.ok(order);
    }

    @Override
    public ResultUtil setInstructOrderNo(String id, String instructOrderNo) {
        BizUncontractApplyMoney tmp = new BizUncontractApplyMoney();
        tmp.setId(id);
        tmp.setInstructOrderFlag(1);
        tmp.setInstructOrderNo(instructOrderNo);
        tmp.setUpdateDate(new Date());
        ucamMapper.updateByPrimaryKeySelective(tmp);
        return ResultUtil.ok();
    }
}
