package com.purchase.mapper.order;

import com.purchase.pojo.order.BizPurchaseOrderExample;
import com.purchase.pojo.order.BizUncontractApplyMoney;
import com.purchase.pojo.order.BizUncontractApplyMoneyExample;
import com.purchase.vo.order.BizPurchaseOrderSearch;
import com.purchase.vo.order.BizPurchaseOrderVo;
import com.purchase.vo.order.UCAMSearch;
import com.purchase.vo.order.UCAMVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BizUncontractApplyMoneyMapper {
    int countByExample(BizUncontractApplyMoneyExample example);

    int deleteByExample(BizUncontractApplyMoneyExample example);

    int deleteByPrimaryKey(String id);

    int insert(BizUncontractApplyMoney record);

    int insertSelective(BizUncontractApplyMoney record);

    List<BizUncontractApplyMoney> selectByExample(BizUncontractApplyMoneyExample example);

    List<UCAMVo> selectByExampleExt(@Param("example") BizUncontractApplyMoneyExample example, @Param("search") UCAMSearch search);

    BizUncontractApplyMoney selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BizUncontractApplyMoney record, @Param("example") BizUncontractApplyMoneyExample example);

    int updateByExample(@Param("record") BizUncontractApplyMoney record, @Param("example") BizUncontractApplyMoneyExample example);

    int updateByPrimaryKeySelective(BizUncontractApplyMoney record);

    int updateByPrimaryKey(BizUncontractApplyMoney record);

    @Select("select max(order_no) order_no from biz_uncontract_apply_money where order_no like '%${prefix}%'")
    String selMaxNo(@Param("prefix") String prefix);
}