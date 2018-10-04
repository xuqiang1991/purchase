package com.purchase.mapper.order;

import com.purchase.pojo.order.BizUncontractApplyMoneyDetail;
import com.purchase.pojo.order.BizUncontractApplyMoneyDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizUncontractApplyMoneyDetailMapper {
    int countByExample(BizUncontractApplyMoneyDetailExample example);

    int deleteByExample(BizUncontractApplyMoneyDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(BizUncontractApplyMoneyDetail record);

    int insertSelective(BizUncontractApplyMoneyDetail record);

    List<BizUncontractApplyMoneyDetail> selectByExample(BizUncontractApplyMoneyDetailExample example);

    BizUncontractApplyMoneyDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BizUncontractApplyMoneyDetail record, @Param("example") BizUncontractApplyMoneyDetailExample example);

    int updateByExample(@Param("record") BizUncontractApplyMoneyDetail record, @Param("example") BizUncontractApplyMoneyDetailExample example);

    int updateByPrimaryKeySelective(BizUncontractApplyMoneyDetail record);

    int updateByPrimaryKey(BizUncontractApplyMoneyDetail record);
}