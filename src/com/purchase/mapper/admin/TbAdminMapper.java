package com.purchase.mapper.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbAdminExample;
import org.apache.ibatis.annotations.Select;

public interface TbAdminMapper {
    int countByExample(TbAdminExample example);

    int deleteByExample(TbAdminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAdmin record);

    int insertSelective(TbAdmin record);

    List<TbAdmin> selectByExample(TbAdminExample example);

    TbAdmin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAdmin record, @Param("example") TbAdminExample example);

    int updateByExample(@Param("record") TbAdmin record, @Param("example") TbAdminExample example);

    int updateByPrimaryKeySelective(TbAdmin record);

    int updateByPrimaryKey(TbAdmin record);

    @Select("SELECT * FROM tb_admin WHERE open_id = #{0}")
    TbAdmin selAdminByOpenId(String openId);

    @Select("SELECT * FROM tb_admin WHERE wx_nick = #{0}")
    TbAdmin selAdminByWxNick(String wx_nick);
}