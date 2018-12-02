package com.purchase.mapper.order;

import com.purchase.pojo.order.BizContractApplyMoney;
import com.purchase.pojo.order.BizContractApplyMoneyExample;
import com.purchase.vo.order.CAMSearch;
import com.purchase.vo.order.CAMVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    BizContractApplyMoney selectByOrderNo( @Param("orderNo") String orderNo);

    @Select("select max(order_no) purchase_no from biz_contract_apply_money where order_no like '${prefix}%'")
    String selMaxOrderNo(@Param("prefix") String prefix);

    Long selectByprojectIdExtCOUNT(String projectId);
}