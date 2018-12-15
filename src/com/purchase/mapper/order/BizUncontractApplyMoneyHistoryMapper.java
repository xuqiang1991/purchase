package com.purchase.mapper.order;

import com.purchase.pojo.order.BizUncontractApplyMoneyHistory;
import com.purchase.pojo.order.BizUncontractApplyMoneyHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizUncontractApplyMoneyHistoryMapper {
    int countByExample(BizUncontractApplyMoneyHistoryExample example);

    int deleteByExample(BizUncontractApplyMoneyHistoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(BizUncontractApplyMoneyHistory record);

    int insertSelective(BizUncontractApplyMoneyHistory record);

    List<BizUncontractApplyMoneyHistory> selectByExample(BizUncontractApplyMoneyHistoryExample example);

    BizUncontractApplyMoneyHistory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BizUncontractApplyMoneyHistory record, @Param("example") BizUncontractApplyMoneyHistoryExample example);

    int updateByExample(@Param("record") BizUncontractApplyMoneyHistory record, @Param("example") BizUncontractApplyMoneyHistoryExample example);

    int updateByPrimaryKeySelective(BizUncontractApplyMoneyHistory record);

    int updateByPrimaryKey(BizUncontractApplyMoneyHistory record);
}