package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.purchase.mapper.admin.TbProjectMangerMapper;
import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.pojo.admin.TbProjectMangerExample;
import com.purchase.service.ProjectMangerService;
import com.purchase.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/18 15:59
 * @Description:项目管理Service实现类
 */
@Service
public class ProjectMangerServiceImpl implements ProjectMangerService {
    @Autowired
    private TbProjectMangerMapper projectMangerMapper;

    @Override
    public ResultUtil selProjectManger(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        TbProjectMangerExample example = new TbProjectMangerExample();
        List<TbProjectManger> list = projectMangerMapper.selectByExample(example);
        PageInfo<TbProjectManger> pageInfo = new PageInfo<TbProjectManger>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public boolean checkProjectMangerName(TbProjectManger projectManger) {
        TbProjectMangerExample example = new TbProjectMangerExample();
        TbProjectMangerExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(projectManger.getName());
        //criteria.andShortNameEqualTo(projectManger.getShortName());

        if(projectManger.getId() != null){
            criteria.andIdNotEqualTo(projectManger.getId());
        }
        List<TbProjectManger> checkProjectMangers= projectMangerMapper.selectByExample(example);
        if (checkProjectMangers != null && checkProjectMangers.size() > 0) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void editProjectManger(TbProjectManger projectManger) {
        if(projectManger.getId() != null){
            projectMangerMapper.updateByPrimaryKey(projectManger);
        }else{
            projectMangerMapper.insert(projectManger);
        }
    }

    @Override
    public TbProjectManger findById(String id) {
        return projectMangerMapper.selectByPrimaryKey(id);
    }
}
