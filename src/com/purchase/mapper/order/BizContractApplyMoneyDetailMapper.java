package com.purchase.mapper.order;

import com.purchase.pojo.order.BizContractApplyMoneyDetail;
import com.purchase.pojo.order.BizContractApplyMoneyDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizContractApplyMoneyDetailMapper {
    int countByExample(BizContractApplyMoneyDetailExample example);

    int deleteByExample(BizContractApplyMoneyDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(BizContractApplyMoneyDetail record);

    int insertSelective(BizContractApplyMoneyDetail record);

    List<BizContractApplyMoneyDetail> selectByExample(BizContractApplyMoneyDetailExample example);

    BizContractApplyMoneyDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BizContractApplyMoneyDetail record, @Param("example") BizContractApplyMoneyDetailExample example);

    int updateByExample(@Param("record") BizContractApplyMoneyDetail record, @Param("example") BizContractApplyMoneyDetailExample example);

    int updateByPrimaryKeySelective(BizContractApplyMoneyDetail record);

    int updateByPrimaryKey(BizContractApplyMoneyDetail record);
}