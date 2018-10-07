package com.purchase.mapper.order;

import com.purchase.pojo.order.BizPaymentOrder;
import com.purchase.pojo.order.BizPaymentOrderExample;
import java.util.List;

import com.purchase.vo.order.BizPaymentOrderSearch;
import com.purchase.vo.order.BizPaymentOrderVo;
import org.apache.ibatis.annotations.Param;

public interface BizPaymentOrderMapper {
    int countByExample(BizPaymentOrderExample example);

    int deleteByExample(BizPaymentOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(BizPaymentOrder record);

    int insertSelective(BizPaymentOrder record);

    List<BizPaymentOrder> selectByExample(BizPaymentOrderExample example);

    BizPaymentOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BizPaymentOrder record, @Param("example") BizPaymentOrderExample example);

    int updateByExample(@Param("record") BizPaymentOrder record, @Param("example") BizPaymentOrderExample example);

    int updateByPrimaryKeySelective(BizPaymentOrder record);

    int updateByPrimaryKey(BizPaymentOrder record);

    List<BizPaymentOrderVo> selectByExampleExt(@Param("example") BizPaymentOrderExample example, @Param("search") BizPaymentOrderSearch search);

}