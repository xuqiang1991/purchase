package com.purchase.mapper.admin;

import com.purchase.pojo.admin.TbCustomers;
import com.purchase.pojo.admin.TbCustomersExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbCustomersMapper {
    int countByExample(TbCustomersExample example);

    int deleteByExample(TbCustomersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbCustomers record);

    int insertSelective(TbCustomers record);

    List<TbCustomers> selectByExample(TbCustomersExample example);

    TbCustomers selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbCustomers record, @Param("example") TbCustomersExample example);

    int updateByExample(@Param("record") TbCustomers record, @Param("example") TbCustomersExample example);

    int updateByPrimaryKeySelective(TbCustomers record);

    int updateByPrimaryKey(TbCustomers record);

    @Select("SELECT * FROM tb_customers ")
    List<TbCustomers> getCustomersList();
}