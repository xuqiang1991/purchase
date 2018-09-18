package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.admin.TbSupplierMapper;
import com.purchase.mapper.order.BizUncontractApplyMoneyMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizPurchaseOrderExample;
import com.purchase.pojo.order.BizUncontractApplyMoney;
import com.purchase.pojo.order.BizUncontractApplyMoneyExample;
import com.purchase.service.UCAMService;
import com.purchase.util.DateUtil;
import com.purchase.util.ResultUtil;
import com.purchase.util.WebUtils;
import com.purchase.vo.order.BizPurchaseOrderVo;
import com.purchase.vo.order.UCAMSearch;
import com.purchase.vo.order.UCAMVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Autowired
    private BizUncontractApplyMoneyMapper ucamMapper;

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

        BizUncontractApplyMoneyExample example=new BizUncontractApplyMoneyExample();
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
            criteria.andSupplierIdsLike("%"+String.valueOf(search.getSupplierId())+"%");
        }

        if(search.getProjectId() != null){
            criteria.andProjectIdEqualTo(search.getProjectId());
        }
        if(!StringUtils.isEmpty(search.getInstructOrderFlag())){
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
        return null;
    }

    @Override
    public ResultUtil selUCAMOrder(String orderNo) {
        return null;
    }

    @Override
    public ResultUtil delUCAMOrder(String id) {
        return null;
    }

    @Override
    public ResultUtil submitUCAMOrder(String id) {
        return null;
    }

    @Override
    public ResultUtil reviewUCAMOrder(TbAdmin admin, String id) {
        return null;
    }
}
