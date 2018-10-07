package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.order.BizProgrammeAcceptanceOrderDetailMapper;
import com.purchase.mapper.order.BizProgrammeAcceptanceOrderMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.*;
import com.purchase.service.ProgrammeAcceptanceService;
import com.purchase.util.*;
import com.purchase.vo.OrderHistory;
import com.purchase.vo.admin.ChoseAdminVO;
import com.purchase.vo.order.ProgrammeAcceptanceDetialVo;
import com.purchase.vo.order.ProgrammeAcceptanceSearch;
import com.purchase.vo.order.ProgrammeAcceptanceVo;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Auther: zhoujb
 * @Date: 2018/10/5 17:27
 * @Description:工程验收service层
 */
@Service
public class ProgrammeAcceptanceServiceImpl implements ProgrammeAcceptanceService {
    private static Logger logger = LoggerFactory.getLogger(ProgrammeAcceptanceServiceImpl.class);

    @Autowired
    private BizProgrammeAcceptanceOrderMapper paoMapper;

    @Autowired
    private BizProgrammeAcceptanceOrderDetailMapper paoDetailMapper;

    @Autowired
    private TbAdminMapper adminMapper;

    /**
     * 工程验收单号前缀
     */
    public static final String PAO_PREFIX = "PC-";

    @Override
    public ResultUtil getPAOOrderList(Integer page, Integer limit, ProgrammeAcceptanceSearch search) {
        PageHelper.startPage(page, limit);

        BizProgrammeAcceptanceOrderExample example = new BizProgrammeAcceptanceOrderExample();
        //设置按创建时间降序排序
        example.setOrderByClause("update_date DESC");
        BizProgrammeAcceptanceOrderExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(search.getOrderNo())){
            //注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
            criteria.andOrderNoLike("%"+search.getOrderNo()+"%");
        }

        if(search.getSupplierId() != null){
            criteria.andSupplierIdEqualTo(search.getSupplierId());
        }

        if(!StringUtils.isEmpty(search.getProjectId())){
            criteria.andProjectIdEqualTo(search.getProjectId());
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

        List<ProgrammeAcceptanceVo> paList = paoMapper.selectByExampleExt(example,search);// ucamMapper.selectByExampleExt(example,search);
        PageInfo<ProgrammeAcceptanceVo> pageInfo = new PageInfo<>(paList);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public ResultUtil addPAOOrder(BizProgrammeAcceptanceOrder order) {
        Date date = new Date();

        String id = WebUtils.generateUUID();
        order.setId(id);

        //生成工程验收单号
        String yyddmm = DateUtil.formatDate(date,DateUtil.DateFormat3);
        String maxNo = paoMapper.selMaxNo(yyddmm);
        if(StringUtils.isEmpty(maxNo)){
            maxNo = "0";
        }else{
            maxNo = maxNo.substring(maxNo.length() - 3);
        }
        maxNo = String.format("%03d", Integer.parseInt(maxNo) + 1);
        String ucamNo = PAO_PREFIX + yyddmm + "-" + maxNo;

        order.setOrderNo(ucamNo);
        //参数补充
        order.setCostDepartDate(date);
        order.setUpdateDate(date);
        order.setCreateTime(date);

        paoMapper.insertSelective(order);

        return ResultUtil.ok();
    }

    @Override
    public ResultUtil editPAOOrder(BizProgrammeAcceptanceOrder order) {
        return null;
    }

    @Override
    public ProgrammeAcceptanceVo selPAOOrder(String id) {
        BizProgrammeAcceptanceOrderExample example = new BizProgrammeAcceptanceOrderExample();
        //设置按创建时间降序排序
        example.setOrderByClause("update_date DESC");
        BizProgrammeAcceptanceOrderExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        ProgrammeAcceptanceSearch search = new ProgrammeAcceptanceSearch();
        search.setId(id);
        List<ProgrammeAcceptanceVo> paList = paoMapper.selectByExampleExt(example,search);
        if(!CollectionUtils.isEmpty(paList)){
            return paList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public ResultUtil selPAOOrderByOrder(String orderNo) {
        BizProgrammeAcceptanceOrderExample example = new BizProgrammeAcceptanceOrderExample();
        BizProgrammeAcceptanceOrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<BizProgrammeAcceptanceOrder> list = paoMapper.selectByExample(example);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        if(!CollectionUtils.isEmpty(list)){
            resultUtil.setData(list.get(0));
        }
        return resultUtil;
    }

    @Override
    public ResultUtil delPAOOrder(String id) {
        BizProgrammeAcceptanceOrder order = paoMapper.selectByPrimaryKey(id);
        if(!(PurchaseUtil.STATUS_0 == order.getStatus())){
            return ResultUtil.error("非未提交状态的工程验收单不能删除！");
        }
        paoMapper.deleteByPrimaryKey(id);

        BizProgrammeAcceptanceOrderExample example = new BizProgrammeAcceptanceOrderExample();
        example.createCriteria().andOrderNoEqualTo(order.getOrderNo());
        paoMapper.deleteByExample(example);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil submitPAOOrder(String id) {
        BizProgrammeAcceptanceOrder order = paoMapper.selectByPrimaryKey(id);

        int status = order.getStatus();
        if(!(PurchaseUtil.STATUS_0 == status)){
            return ResultUtil.error("非未提交状态的工程验收单不能提交！");
        }

        BizProgrammeAcceptanceOrder tmp = new BizProgrammeAcceptanceOrder();
        tmp.setId(order.getId());
        tmp.setStatus(PurchaseUtil.STATUS_1);
        tmp.setApplyDate(new Date());
        paoMapper.updateByPrimaryKeySelective(tmp);
        return ResultUtil.ok();
    }

    @Override
    public ProgrammeAcceptanceDetialVo selPAODetail(String id) {
        ProgrammeAcceptanceDetialVo paOrderDetialVo = new ProgrammeAcceptanceDetialVo();
        try {
            BizProgrammeAcceptanceOrderExample example = new BizProgrammeAcceptanceOrderExample();
            BizProgrammeAcceptanceOrderExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            ProgrammeAcceptanceSearch search = new ProgrammeAcceptanceSearch();
            search.setId(id);
            List<ProgrammeAcceptanceVo> pavList = paoMapper.selectByExampleExt(example,search);
            ProgrammeAcceptanceVo vo = new ProgrammeAcceptanceVo();
            if(!CollectionUtils.isEmpty(pavList)){
                vo = pavList.get(0);
            }
            List<OrderHistory> historyList = new ArrayList<OrderHistory>();
            int status = vo.getStatus();
            if(PurchaseUtil.STATUS_0 == status){
                historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,PurchaseUtil.STATUS_0));
            }else if(PurchaseUtil.STATUS_1 == status){
                historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,PurchaseUtil.STATUS_0));
                historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,PurchaseUtil.STATUS_1));
            }else if(PurchaseUtil.STATUS_2 == status){
                historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,PurchaseUtil.STATUS_0));
                historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,PurchaseUtil.STATUS_1));
                historyList.add(new OrderHistory(vo.getCostAdmin().getFullname(),vo.getCostDepartDate(),vo.getCostDepartOpinion(),vo.getCostDepartApproval(),PurchaseUtil.STATUS_2));
            }else if(PurchaseUtil.STATUS_3 == status){
                historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,PurchaseUtil.STATUS_0));
                historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,PurchaseUtil.STATUS_1));
                historyList.add(new OrderHistory(vo.getCostAdmin().getFullname(),vo.getCostDepartDate(),vo.getCostDepartOpinion(),vo.getCostDepartApproval(),PurchaseUtil.STATUS_2));
                historyList.add(new OrderHistory(vo.getProjectAdmin().getFullname(),vo.getProjectDepartDate(),vo.getProjectDepartOpinion(),vo.getProjectDepartApproval(),PurchaseUtil.STATUS_3));
            }else if(PurchaseUtil.STATUS_4 == status){
                historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,PurchaseUtil.STATUS_0));
                historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,PurchaseUtil.STATUS_1));
                historyList.add(new OrderHistory(vo.getCostAdmin().getFullname(),vo.getCostDepartDate(),vo.getCostDepartOpinion(),vo.getCostDepartApproval(),PurchaseUtil.STATUS_2));
                historyList.add(new OrderHistory(vo.getProjectAdmin().getFullname(),vo.getProjectDepartDate(),vo.getProjectDepartOpinion(),vo.getProjectDepartApproval(),PurchaseUtil.STATUS_3));
                historyList.add(new OrderHistory(vo.getManagerAdmin().getFullname(),vo.getManagerDepartDate(),vo.getManagerDepartOpinion(),vo.getManagerDepartApproval(),PurchaseUtil.STATUS_4));
            }
            Collections.reverse(historyList);
            vo.setHistoryList(historyList);
            paOrderDetialVo.setPaoVo(vo);

            //获取工程验收单详情
            BizProgrammeAcceptanceOrderDetailExample detailExample = new BizProgrammeAcceptanceOrderDetailExample();
            BizProgrammeAcceptanceOrderDetailExample.Criteria detailCriteria = detailExample.createCriteria();
            detailCriteria.andOrderNoEqualTo(vo.getOrderNo());
            List<BizProgrammeAcceptanceOrderDetail> detailList = paoDetailMapper.selectByExample(detailExample);
            paOrderDetialVo.setPaoDetail(detailList);

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
                    paOrderDetialVo.setDeparts(json);
                }
                TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
                long loginId = admin.getId();
                if(reviewUserId != null && reviewUserId == loginId){
                    paOrderDetialVo.setReviewUserId(vo.getCreateUser());

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return paOrderDetialVo;
    }

    @Override
    public ResultUtil addPAOOrderDetail(BizProgrammeAcceptanceOrderDetail order) {
        if(StringUtils.isEmpty(order.getId())){
            String id = MyUtil.getStrUUID();
            order.setId(id);
        }else{

        }
        paoDetailMapper.insert(order);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil deletePAOItem(String id) {
        paoDetailMapper.deleteByPrimaryKey(id);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil submitReviewPAOOrder(TbAdmin admin, String id, Long userId) {
        BizProgrammeAcceptanceOrder order = paoMapper.selectByPrimaryKey(id);

        int status = order.getStatus();
        if(PurchaseUtil.STATUS_1 != status){
            return ResultUtil.error("非未提交状态的工程验收单不能选择成本部审核！");
        }
        Date date = new Date();
        BizProgrammeAcceptanceOrder tmp = new BizProgrammeAcceptanceOrder();
        tmp.setId(order.getId());
        tmp.setCostDepartUser(userId);
        tmp.setUpdateDate(date);

        paoMapper.updateByPrimaryKeySelective(tmp);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil reviewPAOOrder(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion) {
        Date date = new Date();
        BizProgrammeAcceptanceOrder order = paoMapper.selectByPrimaryKey(id);
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

        paoMapper.updateByPrimaryKeySelective(order);

        return ResultUtil.ok();
    }
}