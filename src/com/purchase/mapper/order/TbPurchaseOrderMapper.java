package com.purchase.mapper.order;

import com.purchase.pojo.order.TbPurchaseOrder;
import com.purchase.pojo.order.TbPurchaseOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPurchaseOrderMapper {
    int countByExample(TbPurchaseOrderExample example);

    int deleteByExample(TbPurchaseOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbPurchaseOrder record);

    int insertSelective(TbPurchaseOrder record);

    List<TbPurchaseOrder> selectByExample(TbPurchaseOrderExample example);

    TbPurchaseOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPurchaseOrder record, @Param("example") TbPurchaseOrderExample example);

    int updateByExample(@Param("record") TbPurchaseOrder record, @Param("example") TbPurchaseOrderExample example);

    int updateByPrimaryKeySelective(TbPurchaseOrder record);

    int updateByPrimaryKey(TbPurchaseOrder record);
}