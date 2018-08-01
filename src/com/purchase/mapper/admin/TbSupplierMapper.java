package com.purchase.mapper.admin;

import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.admin.TbSupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSupplierMapper {
    int countByExample(TbSupplierExample example);

    int deleteByExample(TbSupplierExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbSupplier record);

    int insertSelective(TbSupplier record);

    List<TbSupplier> selectByExample(TbSupplierExample example);

    TbSupplier selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbSupplier record, @Param("example") TbSupplierExample example);

    int updateByExample(@Param("record") TbSupplier record, @Param("example") TbSupplierExample example);

    int updateByPrimaryKeySelective(TbSupplier record);

    int updateByPrimaryKey(TbSupplier record);
}