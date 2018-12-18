package com.purchase.mapper.order;

import com.purchase.pojo.order.BizProgrammeAcceptanceOrder;
import com.purchase.pojo.order.BizProgrammeAcceptanceOrderExample;
import com.purchase.vo.order.ProgrammeAcceptanceSearch;
import com.purchase.vo.order.ProgrammeAcceptanceVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BizProgrammeAcceptanceOrderMapper {
    int countByExample(BizProgrammeAcceptanceOrderExample example);

    int deleteByExample(BizProgrammeAcceptanceOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(BizProgrammeAcceptanceOrder record);

    int insertSelective(BizProgrammeAcceptanceOrder record);

    List<BizProgrammeAcceptanceOrder> selectByExample(BizProgrammeAcceptanceOrderExample example);

    BizProgrammeAcceptanceOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BizProgrammeAcceptanceOrder record, @Param("example") BizProgrammeAcceptanceOrderExample example);

    int updateByExample(@Param("record") BizProgrammeAcceptanceOrder record, @Param("example") BizProgrammeAcceptanceOrderExample example);

    int updateByPrimaryKeySelective(BizProgrammeAcceptanceOrder record);

    int updateByPrimaryKey(BizProgrammeAcceptanceOrder record);

    @Select("select max(order_no) order_no from biz_programme_acceptance_order where order_no like '%${prefix}%'")
    String selMaxNo(@Param("prefix") String prefix);

    @Select("select * from biz_programme_acceptance_order where order_no = #{orderNo}")
    BizProgrammeAcceptanceOrder selectByOrderNo(@Param("orderNo") String orderNo);

    List<ProgrammeAcceptanceVo> selectByExampleExt(@Param("example") BizProgrammeAcceptanceOrderExample example, @Param("search") ProgrammeAcceptanceSearch search);
}