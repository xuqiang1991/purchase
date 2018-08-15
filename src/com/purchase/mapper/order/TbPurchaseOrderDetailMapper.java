package com.purchase.mapper.order;

import com.purchase.pojo.order.TbPurchaseOrderDetail;
import com.purchase.pojo.order.TbPurchaseOrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPurchaseOrderDetailMapper {
    int countByExample(TbPurchaseOrderDetailExample example);

    int deleteByExample(TbPurchaseOrderDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbPurchaseOrderDetail record);

    int insertSelective(TbPurchaseOrderDetail record);

    List<TbPurchaseOrderDetail> selectByExample(TbPurchaseOrderDetailExample example);

    TbPurchaseOrderDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPurchaseOrderDetail record, @Param("example") TbPurchaseOrderDetailExample example);

    int updateByExample(@Param("record") TbPurchaseOrderDetail record, @Param("example") TbPurchaseOrderDetailExample example);

    int updateByPrimaryKeySelective(TbPurchaseOrderDetail record);

    int updateByPrimaryKey(TbPurchaseOrderDetail record);
}