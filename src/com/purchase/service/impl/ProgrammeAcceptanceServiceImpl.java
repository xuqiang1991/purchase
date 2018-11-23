package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.order.BizProgrammeAcceptanceOrderDetailMapper;
import com.purchase.mapper.order.BizProgrammeAcceptanceOrderMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizProgrammeAcceptanceOrder;
import com.purchase.pojo.order.BizProgrammeAcceptanceOrderDetail;
import com.purchase.pojo.order.BizProgrammeAcceptanceOrderDetailExample;
import com.purchase.pojo.order.BizProgrammeAcceptanceOrderExample;
import com.purchase.service.ProgrammeAcceptanceService;
import com.purchase.util.DateUtil;
import com.purchase.util.MyUtil;
import com.purchase.util.ResultUtil;
import com.purchase.util.WebUtils;
import com.purchase.vo.OrderHistory;
import com.purchase.vo.admin.ChoseAdminVO;
import com.purchase.vo.order.ProgrammeAcceptanceDetialVo;
import com.purchase.vo.order.ProgrammeAcceptanceSearch;
import com.purchase.vo.order.ProgrammeAcceptanceVo;
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

    public static final int STATUS_0 = 0;//未提交
    public static final int STATUS_1 = 1;//已提交
    public static final int STATUS_2 = 2;//工程部已审核
    public static final int STATUS_3 = 3;//成本部已审核
    public static final int STATUS_4 = 4;//总经理已审核

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

        if(!StringUtils.isEmpty(search.getContractNo())){
            //注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
            criteria.andContractNoLike("%"+search.getContractNo()+"%");
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
    public ResultUtil savePAOOrder(BizProgrammeAcceptanceOrder order) {
        Date date = new Date();
        String id = null;
        if(!StringUtils.isEmpty(order.getId())){
            id = order.getId();
            order.setUpdateDate(date);
            paoMapper.updateByPrimaryKeySelective(order);
        }else{
            id = WebUtils.generateUUID();
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
            String orderNo = PAO_PREFIX + yyddmm + "-" + maxNo;

            order.setOrderNo(orderNo);
            //参数补充
            order.setStatus(STATUS_0);
            order.setUpdateDate(date);
            order.setCreateTime(date);
            paoMapper.insertSelective(order);
        }
        return ResultUtil.ok(id);
    }

    @Override
    public ProgrammeAcceptanceVo selPAOOrder(String id, Long adminId) {
        BizProgrammeAcceptanceOrderExample example = new BizProgrammeAcceptanceOrderExample();
        //设置按创建时间降序排序
        example.setOrderByClause("update_date DESC");
        BizProgrammeAcceptanceOrderExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        ProgrammeAcceptanceSearch search = new ProgrammeAcceptanceSearch();
        search.setId(id);
        search.setLoginId(adminId);
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
        if(!(STATUS_0 == order.getStatus())){
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
        if(!(STATUS_0 == status)){
            return ResultUtil.error("非未提交状态的工程验收单不能提交！");
        }

        BizProgrammeAcceptanceOrder tmp = new BizProgrammeAcceptanceOrder();
        tmp.setId(order.getId());
        tmp.setStatus(STATUS_1);
        tmp.setApplyDate(new Date());
        paoMapper.updateByPrimaryKeySelective(tmp);
        return ResultUtil.ok();
    }

    @Override
    public ProgrammeAcceptanceDetialVo selPAODetail(String id,  Long adminId) {
        ProgrammeAcceptanceDetialVo paOrderDetialVo = new ProgrammeAcceptanceDetialVo();
        try {
            BizProgrammeAcceptanceOrderExample example = new BizProgrammeAcceptanceOrderExample();
            BizProgrammeAcceptanceOrderExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            ProgrammeAcceptanceSearch search = new ProgrammeAcceptanceSearch();
            search.setId(id);
            search.setLoginId(adminId);
            List<ProgrammeAcceptanceVo> pavList = paoMapper.selectByExampleExt(example,search);
            ProgrammeAcceptanceVo vo = new ProgrammeAcceptanceVo();
            if(!CollectionUtils.isEmpty(pavList)){
                vo = pavList.get(0);
            }
            List<OrderHistory> historyList = new ArrayList<OrderHistory>();
            int status = vo.getStatus();
            if(STATUS_0 == status){
                historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,STATUS_0));
            }else if(STATUS_1 == status){
                historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,STATUS_0));
                historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,STATUS_1));
            }else if(STATUS_2 == status){
                historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,STATUS_0));
                historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,STATUS_1));
                historyList.add(new OrderHistory(vo.getProjectAdmin().getFullname(),vo.getProjectDepartDate(),vo.getProjectDepartOpinion(),vo.getProjectDepartApproval(),STATUS_2));
            }else if(STATUS_3 == status){
                historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,STATUS_0));
                historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,STATUS_1));
                historyList.add(new OrderHistory(vo.getProjectAdmin().getFullname(),vo.getProjectDepartDate(),vo.getProjectDepartOpinion(),vo.getProjectDepartApproval(),STATUS_2));
                historyList.add(new OrderHistory(vo.getCostAdmin().getFullname(),vo.getCostDepartDate(),vo.getCostDepartOpinion(),vo.getCostDepartApproval(),STATUS_3));
            }else if(STATUS_4 == status){
                historyList.add(new OrderHistory(vo.getAdmin().getFullname(),vo.getCreateTime(),"",true,STATUS_0));
                historyList.add(new OrderHistory(vo.getAuAdmin().getFullname(),vo.getApplyDate(),"",true,STATUS_1));
                historyList.add(new OrderHistory(vo.getProjectAdmin().getFullname(),vo.getProjectDepartDate(),vo.getProjectDepartOpinion(),vo.getProjectDepartApproval(),STATUS_2));
                historyList.add(new OrderHistory(vo.getCostAdmin().getFullname(),vo.getCostDepartDate(),vo.getCostDepartOpinion(),vo.getCostDepartApproval(),STATUS_3));
                historyList.add(new OrderHistory(vo.getManagerAdmin().getFullname(),vo.getManagerDepartDate(),vo.getManagerDepartOpinion(),vo.getManagerDepartApproval(),STATUS_4));
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
            String roleName = "工程部";
            Long reviewUserId = null;
            switch (vo.getStatus()){
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
            }
            paOrderDetialVo.setReviewUserId(reviewUserId);
            if(roleName != null){
                List<ChoseAdminVO> data = adminMapper.selectByRoleName(roleName);
                if(!CollectionUtils.isEmpty(data)){
                    Gson gson = new Gson();
                    String json = gson.toJson(data);
                    paOrderDetialVo.setDeparts(json);
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
        }
        paoDetailMapper.insert(order);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil editPAOOrderDetail(BizProgrammeAcceptanceOrderDetail order) {
        /*BizProgrammeAcceptanceOrderDetail detail = paoDetailMapper.selectByPrimaryKey(order.getId());
        detail.setActualOverDate(order.getActualOverDate());
        detail.setRectifyFlag(order.getRectifyFlag());*/
        paoDetailMapper.updateByPrimaryKey(order);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil deletePAOItem(String id) {
        paoDetailMapper.deleteByPrimaryKey(id);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil selPAOItem(String id) {
        BizProgrammeAcceptanceOrderDetail detail = paoDetailMapper.selectByPrimaryKey(id);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setData(detail);
        return resultUtil;
    }

    @Override
    public ResultUtil submitReviewPAOOrder(TbAdmin admin, String id, Long userId) {
        BizProgrammeAcceptanceOrder order = paoMapper.selectByPrimaryKey(id);

        int status = order.getStatus();
        if(STATUS_1 != status){
            return ResultUtil.error("非未提交状态的工程验收单不能选择工程部审核！");
        }
        Date date = new Date();
        BizProgrammeAcceptanceOrder tmp = new BizProgrammeAcceptanceOrder();
        tmp.setId(order.getId());
        tmp.setProjectDepartUser(userId);
        tmp.setUpdateDate(date);

        paoMapper.updateByPrimaryKeySelective(tmp);
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil reviewPAOOrder(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion) {
        logger.info("审核工程验收单。id:{}, 是否通过:{}, 上级审批人:{}, 审批意见:{}", id,auditOpinion,applyUser,auditOpinion);

        Date date = new Date();
        BizProgrammeAcceptanceOrder order = paoMapper.selectByPrimaryKey(id);

        //审核不通过
        if(!auditResults){
            order.setStatus(STATUS_0);
            order.setProjectDepartUser(null);
            order.setCostDepartUser(null);
            order.setManagerDepartUser(null);

            order.setProjectDepartDate(null);
            order.setCostDepartDate(null);
            order.setManagerDepartDate(null);

            order.setProjectDepartApproval(null);
            order.setCostDepartApproval(null);
            order.setManagerDepartApproval(null);

            order.setProjectDepartOpinion(null);
            order.setCostDepartOpinion(null);
            order.setManagerDepartOpinion(null);
        }else{
            //审核状态
            if(STATUS_1 ==  order.getStatus()){
                order.setProjectDepartDate(date);
                order.setStatus(STATUS_2);
                order.setProjectDepartApproval(auditResults);
                order.setProjectDepartOpinion(auditOpinion);
                order.setCostDepartUser(applyUser);
            }else if (STATUS_2 ==  order.getStatus()){
                order.setStatus(STATUS_3);
                order.setCostDepartDate(date);
                order.setCostDepartApproval(auditResults);
                order.setCostDepartOpinion(auditOpinion);
                order.setManagerDepartUser(applyUser);
            }else if (STATUS_3 ==  order.getStatus()){
                order.setStatus(STATUS_4);
                order.setManagerDepartDate(date);
                order.setManagerDepartApproval(auditResults);
                order.setManagerDepartOpinion(auditOpinion);
            }
        }
        order.setUpdateDate(date);
        paoMapper.updateByPrimaryKey(order);
        return ResultUtil.ok();
    }
}
