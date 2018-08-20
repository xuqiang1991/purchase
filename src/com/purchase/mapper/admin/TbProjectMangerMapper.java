package com.purchase.mapper.admin;

import com.purchase.pojo.admin.TbProjectManger;
import com.purchase.pojo.admin.TbProjectMangerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbProjectMangerMapper {
    int countByExample(TbProjectMangerExample example);

    int deleteByExample(TbProjectMangerExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbProjectManger record);

    int insertSelective(TbProjectManger record);

    List<TbProjectManger> selectByExample(TbProjectMangerExample example);

    TbProjectManger selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbProjectManger record, @Param("example") TbProjectMangerExample example);

    int updateByExample(@Param("record") TbProjectManger record, @Param("example") TbProjectMangerExample example);

    int updateByPrimaryKeySelective(TbProjectManger record);

    int updateByPrimaryKey(TbProjectManger record);
}