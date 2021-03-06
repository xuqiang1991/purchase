package com.purchase.mapper.order;

import com.purchase.pojo.order.BizPurchaseOrder;
import com.purchase.pojo.order.BizPurchaseOrderExample;
import com.purchase.vo.order.BizPurchaseOrderSearch;
import com.purchase.vo.order.BizPurchaseOrderVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BizPurchaseOrderMapper {
    int countByExample(BizPurchaseOrderExample example);

    int deleteByExample(BizPurchaseOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(BizPurchaseOrder record);

    int insertSelective(BizPurchaseOrder record);

    List<BizPurchaseOrder> selectByExample(BizPurchaseOrderExample example);

    BizPurchaseOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BizPurchaseOrder record, @Param("example") BizPurchaseOrderExample example);

    int updateByExample(@Param("record") BizPurchaseOrder record, @Param("example") BizPurchaseOrderExample example);

    int updateByPrimaryKeySelective(BizPurchaseOrder record);

    int updateByPrimaryKey(BizPurchaseOrder record);

    List<BizPurchaseOrderVo> selectByExampleExt(@Param("example") BizPurchaseOrderExample example, @Param("search") BizPurchaseOrderSearch search);

    @Select("select max(purchase_no) purchase_no from biz_purchase_order where purchase_no like '${prefix}%'")
    String selMaxPurchaseNo(@Param("prefix") String prefix);

    @Select("select * from biz_purchase_order where status = #{0} and supplier_id = #{1}")
    List<BizPurchaseOrder> selectPurchaseOrder(Integer status, Long supplier);

    BizPurchaseOrder selectByPurchaseNo(@Param("purchaseNo") String purchaseNo);
}