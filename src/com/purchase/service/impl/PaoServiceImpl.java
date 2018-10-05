package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.order.BizProgrammeAcceptanceOrderDetailMapper;
import com.purchase.mapper.order.BizProgrammeAcceptanceOrderMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizProgrammeAcceptanceOrder;
import com.purchase.pojo.order.BizProgrammeAcceptanceOrderDetail;
import com.purchase.pojo.order.BizProgrammeAcceptanceOrderExample;
import com.purchase.service.PaoService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.order.PaoOrderDetialVo;
import com.purchase.vo.order.PaoSearch;
import com.purchase.vo.order.PaoVo;
import com.purchase.vo.order.UCAMVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Auther: zhoujb
 * @Date: 2018/10/5 17:27
 * @Description:工程验收service层
 */
@Service
public class PaoServiceImpl implements PaoService {
    private static Logger logger = LoggerFactory.getLogger(PaoServiceImpl.class);

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
    public ResultUtil getPAOOrderList(Integer page, Integer limit, PaoSearch search) {
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

        List<UCAMVo> ucamList = null;// ucamMapper.selectByExampleExt(example,search);
        PageInfo<UCAMVo> pageInfo = new PageInfo<>(ucamList);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public ResultUtil addPAOOrder(BizProgrammeAcceptanceOrder order) {
        return null;
    }

    @Override
    public ResultUtil editPAOOrder(BizProgrammeAcceptanceOrder order) {
        return null;
    }

    @Override
    public PaoVo selPAOOrder(String id) {
        return null;
    }

    @Override
    public ResultUtil selPAOOrderByOrder(String orderNo) {
        return null;
    }

    @Override
    public ResultUtil delPAOOrder(String id) {
        return null;
    }

    @Override
    public ResultUtil submitPAOOrder(String id) {
        return null;
    }

    @Override
    public PaoOrderDetialVo selPAODetail(String id) {
        return null;
    }

    @Override
    public ResultUtil addPAOOrderDetail(BizProgrammeAcceptanceOrderDetail ucamDetail) {
        return null;
    }

    @Override
    public ResultUtil deletePAOItem(String id) {
        return null;
    }

    @Override
    public ResultUtil submitReviewPAOOrder(TbAdmin admin, String id, Long userId) {
        return null;
    }

    @Override
    public ResultUtil reviewPAOOrder(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion) {
        return null;
    }
}
