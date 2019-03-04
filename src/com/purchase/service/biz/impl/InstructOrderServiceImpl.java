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
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

        List<BizInstructOrder> bmList = instructOrderMapper.selectByExample(example);
        PageInfo<BizInstructOrder> pageInfo = new PageInfo<>(bmList);
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
        instructOrderMapper.deleteByPrimaryKey(id);
        return ResultUtil.ok();
    }
}
