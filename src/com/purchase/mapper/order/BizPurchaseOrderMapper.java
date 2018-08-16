package com.purchase.mapper.order;

import com.purchase.pojo.order.BizPurchaseOrder;
import com.purchase.pojo.order.BizPurchaseOrderExample;
import java.util.List;

import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.SupplierVo;
import com.purchase.vo.order.BizPurchaseOrderVo;
import org.apache.ibatis.annotations.Param;

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

    List<BizPurchaseOrderVo> selectByExampleExt(BizPurchaseOrderExample example);
}