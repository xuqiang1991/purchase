package com.purchase.service.biz.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.purchase.mapper.biz.BizInstructOrderMapper;
import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.biz.BizInstructOrder;
import com.purchase.pojo.biz.BizInstructOrderExample;
import com.purchase.service.biz.InstructOrderService;
import com.purchase.util.ResultUtil;
import com.purchase.util.WebUtils;
import com.purchase.vo.biz.InstructOrderSearch;
import com.purchase.vo.biz.InstructOrderVo;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @Title: InstructOrderServiceImpl
 * @ProjectName purchase
 * @Description: 指令单实现类
 * @author zhoujb
 * @date 2019-03-0411:32
 */
@Service
public class InstructOrderServiceImpl implements InstructOrderService {
    private static Logger logger = LoggerFactory.getLogger(InstructOrderServiceImpl.class);

    @Autowired
    private BizInstructOrderMapper instructOrderMapper;

    @Override
    public ResultUtil getList(Integer page, Integer limit, InstructOrderSearch search) {
        PageHelper.startPage(page, limit);

        BizInstructOrderExample example = new BizInstructOrderExample();
        //设置按创建时间降序排序
        example.setOrderByClause("edit_date DESC");
        BizInstructOrderExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(search.getInstructCentext())){
            //注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
            criteria.andInstructCentextLike("%"+search.getInstructCentext()+"%");
        }

        if(!StringUtils.isEmpty(search.getPmId())){
            criteria.andPmIdEqualTo(search.getPmId());
        }

        List<InstructOrderVo> bmList = instructOrderMapper.selectByExampleExt(example,search);
        PageInfo<InstructOrderVo> pageInfo = new PageInfo<>(bmList);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public ResultUtil save(BizInstructOrder order) {
        Date date = new Date();
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        if(StringUtils.isEmpty(order.getId())){
            order.setId(WebUtils.generateUUID());
            order.setCreateDate(date);
            order.setCreateUser(admin.getId());
            instructOrderMapper.insertSelective(order);
        }else{
            order.setEditDate(date);
            order.setEditUser(admin.getId());
            instructOrderMapper.updateByPrimaryKeySelective(order);
        }
        return ResultUtil.ok();
    }

    @Override
    public ResultUtil del(String id) {
        //检查指令单是否被引用 计量计价单明细表、签证结算单明细表
        boolean flag = false;
        if(flag){
            instructOrderMapper.deleteByPrimaryKey(id);
            return ResultUtil.ok();
        }else{
            return new ResultUtil(500,"指令单已被引用，不能删除！");
        }
    }

    @Override
    public BizInstructOrder findById(String id) {
        return instructOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean checkInstructNo(BizInstructOrder instructOrder) {
        BizInstructOrderExample example = new BizInstructOrderExample();
        BizInstructOrderExample.Criteria criteria = example.createCriteria();
        criteria.andInstructNoEqualTo(instructOrder.getInstructNo());
        criteria.andPmIdEqualTo(instructOrder.getPmId());
        if(instructOrder.getId() != null){
            criteria.andIdNotEqualTo(instructOrder.getId());
        }
        List<BizInstructOrder> list = instructOrderMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return true;
        }else{
            return false;
        }
    }
}
