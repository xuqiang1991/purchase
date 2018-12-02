package com.purchase.mapper.admin;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.admin.TbAdminExample;
import com.purchase.pojo.admin.TbRoles;
import com.purchase.vo.admin.ChoseAdminVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
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

    @Select("SELECT id,username,password,salt,fullname,e_mail as eMail,sex,birthday,address,phone,quarters,dept_id as deptId,entry_date as entryDate," +
            " is_on_job as isOnJob, open_id as openId,wx_nick as wxNick, remark, supplier_id as supplierId, user_type as userType" +
            " FROM tb_admin WHERE open_id = #{0}")
    TbAdmin selAdminByOpenId(String openId);

    @Select("SELECT id,username,password,salt,fullname,e_mail as eMail,sex,birthday,address,phone,quarters,dept_id as deptId,entry_date as entryDate," +
            " is_on_job as isOnJob, open_id as openId,wx_nick as wxNick, remark, supplier_id as supplierId, user_type as userType" +
            " FROM tb_admin WHERE wx_nick = #{0} and (open_id is null or open_id = '')")
    TbAdmin selAdminByWxNick(String wx_nick);

    @Select("SELECT id,username,password,salt,fullname,e_mail as eMail,sex,birthday,address,phone,quarters,dept_id as deptId,entry_date as entryDate," +
            " is_on_job as isOnJob, open_id as openId,wx_nick as wxNick, remark, supplier_id as supplierId, user_type as userType" +
            " FROM tb_admin a WHERE a.is_on_job = #{0}")
    List<TbAdmin> getAdmins(Integer isOnJob);

    @Select("SELECT  id,username,password,salt,fullname,e_mail as eMail,sex,birthday,address,phone,quarters,dept_id as deptId,entry_date as entryDate," +
            " is_on_job as isOnJob, open_id as openId,wx_nick as wxNick, remark, supplier_id as supplierId, user_type as userType" +
            " FROM tb_admin a WHERE a.dept_id = #{0}")
    List<TbAdmin> getAdminsByDeptId(String deptId);

    @Select("SELECT a.fullname, a.id FROM tb_admin a ,tb_department b WHERE a.dept_id = b.id and b.name = #{0}")
    @Results({
            @Result(property = "text", column = "fullname"),
            @Result(property = "value", column = "id")
    })
    List<ChoseAdminVO> selectByDeptName(String depart);

    List<TbAdmin> selectByExampleExt(@Param("example") TbAdminExample example);

    Long selectByExampleExt_COUNT(@Param("example") TbAdminExample example);

    List<TbRoles> selectRoleByExample(@Param("example") TbAdminExample example);

    @Select("SELECT a.fullname, a.id FROM tb_admin a,tb_admin_role b,tb_roles c WHERE a.id = b.user_id and c.role_id = b.role_id and c.role_name = #{0}")
    @Results({
            @Result(property = "text", column = "fullname"),
            @Result(property = "value", column = "id")
    })
    List<ChoseAdminVO> selectByRoleName(String roleName);

    @Select("SELECT id,username,password,salt,fullname,e_mail as eMail,sex,birthday,address,phone,quarters,dept_id as deptId,entry_date as entryDate," +
            " is_on_job as isOnJob, open_id as openId,wx_nick as wxNick, remark, supplier_id as supplierId, user_type as userType" +
            " FROM tb_admin a WHERE a.is_on_job = #{0} and a.supplier_id = #{1}")
    List<TbAdmin> selectAdminBySupplierId(Integer isOnJob, Long supplierId);

    @Select("SELECT id,username,password,salt,fullname,e_mail as eMail,sex,birthday,address,phone,quarters,dept_id as deptId,entry_date as entryDate," +
            " is_on_job as isOnJob, open_id as openId,wx_nick as wxNick, remark, supplier_id as supplierId, user_type as userType" +
            " FROM tb_admin a WHERE a.is_on_job = #{0} and a.supplier_id IS NOT NULL")
    List<TbAdmin> selectAdminSupplierIdNotNull(Integer isOnJob);

    List<TbAdmin> getAdminSupplierIdNotNullExt();

    @Select("SELECT COUNT(1) from tb_admin a where a.dept_id = #{0}")
    long seladminByDepartment(Long id);

    @Select("SELECT COUNT(1) from tb_supplier a where a.area_id = #{0}")
    long selsupplierByArea(Long id);

    @Select("SELECT COUNT(1) from tb_customers a where a.area = #{0}")
    long selcustomersByArea(Long id);
}