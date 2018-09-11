package com.purchase.mapper.order;

import com.purchase.pojo.order.BizUncontractApplyMoney;
import com.purchase.pojo.order.BizUncontractApplyMoneyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizUncontractApplyMoneyMapper {
    int countByExample(BizUncontractApplyMoneyExample example);

    int deleteByExample(BizUncontractApplyMoneyExample example);

    int deleteByPrimaryKey(String id);

    int insert(BizUncontractApplyMoney record);

    int insertSelective(BizUncontractApplyMoney record);

    List<BizUncontractApplyMoney> selectByExample(BizUncontractApplyMoneyExample example);

    BizUncontractApplyMoney selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BizUncontractApplyMoney record, @Param("example") BizUncontractApplyMoneyExample example);

    int updateByExample(@Param("record") BizUncontractApplyMoney record, @Param("example") BizUncontractApplyMoneyExample example);

    int updateByPrimaryKeySelective(BizUncontractApplyMoney record);

    int updateByPrimaryKey(BizUncontractApplyMoney record);
}