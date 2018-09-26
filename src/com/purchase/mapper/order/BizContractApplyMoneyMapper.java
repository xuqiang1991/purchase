package com.purchase.mapper.order;

import com.purchase.pojo.order.BizContractApplyMoney;
import com.purchase.pojo.order.BizContractApplyMoneyExample;
import java.util.List;

import com.purchase.vo.order.CAMSearch;
import com.purchase.vo.order.CAMVo;
import org.apache.ibatis.annotations.Param;

public interface BizContractApplyMoneyMapper {
    int countByExample(BizContractApplyMoneyExample example);

    int deleteByExample(BizContractApplyMoneyExample example);

    int deleteByPrimaryKey(String id);

    int insert(BizContractApplyMoney record);

    int insertSelective(BizContractApplyMoney record);

    List<BizContractApplyMoney> selectByExample(BizContractApplyMoneyExample example);

    BizContractApplyMoney selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BizContractApplyMoney record, @Param("example") BizContractApplyMoneyExample example);

    int updateByExample(@Param("record") BizContractApplyMoney record, @Param("example") BizContractApplyMoneyExample example);

    int updateByPrimaryKeySelective(BizContractApplyMoney record);

    int updateByPrimaryKey(BizContractApplyMoney record);

    List<CAMVo> selectByExampleExt( @Param("example")BizContractApplyMoneyExample example,  @Param("search") CAMSearch search);
}