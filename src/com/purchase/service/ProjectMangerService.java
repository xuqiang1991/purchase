package com.purchase.service;

import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.ChoseProjectVO;
import com.purchase.vo.admin.ProjectMangerSearch;

import java.util.List;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/18 15:58
 * @Description:项目管理Service接口
 */
public interface ProjectMangerService {

    /**
     * 获取项目集合
     * @param page
     * @param limit
     * @return
     */
    ResultUtil selProjectManger(Integer page, Integer limit, ProjectMangerSearch search);

    /**
     * 检查项目名称是否唯一
     * @param projectManger
     * @return
     */
    boolean checkProjectMangerName(TbProjectManger projectManger);

    /**
     * 新增/更新项目
     */
    void editProjectManger(TbProjectManger projectManger);

    /**
     * 根据ID查询项目信息
     * @param id
     * @return
     */
    TbProjectManger findById(String id);

    /**
     * 查询所有可选项目
     * @return
     */
    List<TbProjectManger> selectProjectMangerExample();

    List<ChoseProjectVO> selectProjectManger();

    void delProject(String id);

    /**
     * 检查项目是否被引用
     * @param id
     * @return
     */
    ResultUtil checkProject(String id);
}
