package com.purchase.mapper.order;

import com.purchase.pojo.order.BizPurchaseOrderDetail;
import com.purchase.pojo.order.BizPurchaseOrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizPurchaseOrderDetailMapper {
    int countByExample(BizPurchaseOrderDetailExample example);

    int deleteByExample(BizPurchaseOrderDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(BizPurchaseOrderDetail record);

    int insertSelective(BizPurchaseOrderDetail record);

    List<BizPurchaseOrderDetail> selectByExample(BizPurchaseOrderDetailExample example);

    BizPurchaseOrderDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BizPurchaseOrderDetail record, @Param("example") BizPurchaseOrderDetailExample example);

    int updateByExample(@Param("record") BizPurchaseOrderDetail record, @Param("example") BizPurchaseOrderDetailExample example);

    int updateByPrimaryKeySelective(BizPurchaseOrderDetail record);

    int updateByPrimaryKey(BizPurchaseOrderDetail record);
}