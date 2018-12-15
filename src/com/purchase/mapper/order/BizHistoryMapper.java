package com.purchase.mapper.order;

import com.purchase.pojo.order.BizHistory;
import com.purchase.pojo.order.BizHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizHistoryMapper {
    int countByExample(BizHistoryExample example);

    int deleteByExample(BizHistoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(BizHistory record);

    int insertSelective(BizHistory record);

    List<BizHistory> selectByExample(BizHistoryExample example);

    BizHistory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BizHistory record, @Param("example") BizHistoryExample example);

    int updateByExample(@Param("record") BizHistory record, @Param("example") BizHistoryExample example);

    int updateByPrimaryKeySelective(BizHistory record);

    int updateByPrimaryKey(BizHistory record);
}