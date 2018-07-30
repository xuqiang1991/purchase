package com.purchase.mapper.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.purchase.pojo.admin.TbRoles;
import com.purchase.pojo.admin.TbRolesExample;

public interface TbRolesMapper {
    int countByExample(TbRolesExample example);

    int deleteByExample(TbRolesExample example);

    int deleteByPrimaryKey(Long roleId);

    int insert(TbRoles record);

    int insertSelective(TbRoles record);

    List<TbRoles> selectByExample(TbRolesExample example);

    TbRoles selectByPrimaryKey(Long roleId);

    int updateByExampleSelective(@Param("record") TbRoles record, @Param("example") TbRolesExample example);

    int updateByExample(@Param("record") TbRoles record, @Param("example") TbRolesExample example);

    int updateByPrimaryKeySelective(TbRoles record);

    int updateByPrimaryKey(TbRoles record);
}