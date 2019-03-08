package com.purchase.mapper.biz;

import com.purchase.pojo.biz.BizOrder;
import com.purchase.pojo.biz.BizOrderExample;
import com.purchase.vo.Search.BizOrderSearch;
import com.purchase.vo.biz.BizOrderVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BizOrderMapper {
    int countByExample(BizOrderExample example);

    int deleteByExample(BizOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(BizOrder record);

    int insertSelective(BizOrder record);

    List<BizOrder> selectByExample(BizOrderExample example);

    BizOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BizOrder record, @Param("example") BizOrderExample example);

    int updateByExample(@Param("record") BizOrder record, @Param("example") BizOrderExample example);

    int updateByPrimaryKeySelective(BizOrder record);

    int updateByPrimaryKey(BizOrder record);

    List<BizOrderVo> selectByExampleExt(@Param("example") BizOrderExample example, @Param("search") BizOrderSearch search);

    @Select("select max(order_no) order_no from biz_order where order_no like '${prefix}%'")
    String selMaxOrderNo(@Param("prefix") String prefix);
}