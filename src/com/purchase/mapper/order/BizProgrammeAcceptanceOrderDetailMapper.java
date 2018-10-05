package com.purchase.mapper.order;

import com.purchase.pojo.order.BizProgrammeAcceptanceOrderDetail;
import com.purchase.pojo.order.BizProgrammeAcceptanceOrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizProgrammeAcceptanceOrderDetailMapper {
    int countByExample(BizProgrammeAcceptanceOrderDetailExample example);

    int deleteByExample(BizProgrammeAcceptanceOrderDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(BizProgrammeAcceptanceOrderDetail record);

    int insertSelective(BizProgrammeAcceptanceOrderDetail record);

    List<BizProgrammeAcceptanceOrderDetail> selectByExample(BizProgrammeAcceptanceOrderDetailExample example);

    BizProgrammeAcceptanceOrderDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BizProgrammeAcceptanceOrderDetail record, @Param("example") BizProgrammeAcceptanceOrderDetailExample example);

    int updateByExample(@Param("record") BizProgrammeAcceptanceOrderDetail record, @Param("example") BizProgrammeAcceptanceOrderDetailExample example);

    int updateByPrimaryKeySelective(BizProgrammeAcceptanceOrderDetail record);

    int updateByPrimaryKey(BizProgrammeAcceptanceOrderDetail record);
}