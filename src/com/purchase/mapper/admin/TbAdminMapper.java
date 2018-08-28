package com.purchase.mapper.admin;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbAdminExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    @Select("SELECT * FROM tb_admin WHERE wx_nick = #{0} and (open_id is null or open_id = '')")
    TbAdmin selAdminByWxNick(String wx_nick);

    @Select("SELECT * FROM tb_admin a WHERE a.is_on_job = #{0}")
    List<TbAdmin> getAdmins(Integer isOnJob);

}