package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.purchase.mapper.admin.TbAdminMapper;
import com.purchase.mapper.admin.TbCustomersMapper;
import com.purchase.mapper.admin.TbProjectMangerMapper;
import com.purchase.pojo.admin.*;
import com.purchase.service.ProjectMangerService;
import com.purchase.util.MyUtil;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.ChoseAdminVO;
import com.purchase.vo.admin.ChoseDeptVO;
import com.purchase.vo.admin.ChoseProjectVO;
import com.purchase.vo.admin.ProjectMangerSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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

    @Autowired
    private TbAdminMapper adminMapper;

    @Autowired
    private TbCustomersMapper customersMapper;

    @Override
    public ResultUtil selProjectManger(Integer page, Integer limit, ProjectMangerSearch search) {
        PageHelper.startPage(page, limit);
        TbProjectMangerExample example = new TbProjectMangerExample();
        example.setOrderByClause("id DESC");
        TbProjectMangerExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(search.getName())){
            //注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
            criteria.andNameLike("%"+search.getName()+"%");
            /*criteria.andShortNameLike("%"+search.getName()+"%");*/
        }
        if(search.getProjectManager() != null){
            criteria.andProjectManagerEqualTo(search.getProjectManager());
        }
        if(!StringUtils.isEmpty(search.getDeveloper())){
            criteria.andDeveloperEqualTo(search.getDeveloper());
        }
        if(!StringUtils.isEmpty(search.getConsignor())){
            criteria.andConsignorEqualTo(search.getConsignor());
        }
        if(search.getStatus() != null){
            criteria.andStatusEqualTo(search.getStatus());
        }

        List<TbProjectManger> list = projectMangerMapper.selectByExample(example);
        List<TbAdmin> admins = adminMapper.selectByExampleExt(new TbAdminExample());
        for (TbProjectManger pm : list) {
            for (TbAdmin admin : admins) {
                if (admin.getId() == pm.getProjectManager()) {
                    pm.setProjectManagerName(admin.getFullname());
                }
                if (admin.getId() == pm.getBudgetLeader()) {
                    pm.setBudgetLeaderName(admin.getFullname());
                }
            }
            if(pm.getDeveloper() != null){
                TbCustomers customers = customersMapper.selectByPrimaryKey(Long.parseLong(pm.getDeveloper()));
                if(customers != null){
                    pm.setDeveloperName(customers.getFullName());
                    /*pm.setDeveloperLeaderName(customers.getChargeName());
                    pm.setDeveloperLeaderPhone(customers.getChargePhone());*/
                }
            }
            if(pm.getConsignor() != null){
                TbCustomers customers = customersMapper.selectByPrimaryKey(Long.parseLong(pm.getConsignor()));
                if(customers != null){
                    pm.setConsignorName(customers.getFullName());
                    /*pm.setConsignorLeaderName(customers.getChargeName());
                    pm.setConsignorLeaderPhone(customers.getChargePhone());*/
                }
            }

        }
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
        if(!StringUtils.isEmpty(projectManger.getId())){
            projectMangerMapper.updateByPrimaryKey(projectManger);
        }else{
            projectManger.setId(MyUtil.getStrUUID());
            projectMangerMapper.insert(projectManger);
        }
    }

    @Override
    public TbProjectManger findById(String id) {
        return projectMangerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TbProjectManger> selectProjectMangerExample() {
        TbProjectMangerExample example = new TbProjectMangerExample();
        List<TbProjectManger> list = projectMangerMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<ChoseProjectVO> selectProjectManger() {
        List<ChoseProjectVO> item = new ArrayList<>();
        TbProjectMangerExample example=new TbProjectMangerExample();
        List<TbProjectManger> depts = projectMangerMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(depts)){
            for (TbProjectManger d: depts) {
                ChoseProjectVO dept = new ChoseProjectVO(d.getId().toString(),d.getName());
                item.add(dept);
            }
        }

        return item;
    }
}
