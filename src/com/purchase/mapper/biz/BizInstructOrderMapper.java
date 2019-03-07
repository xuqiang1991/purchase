package com.purchase.mapper.biz;

import com.purchase.pojo.biz.BizInstructOrder;
import com.purchase.pojo.biz.BizInstructOrderExample;
import com.purchase.vo.Search.InstructOrderSearch;
import com.purchase.vo.biz.InstructOrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BizInstructOrderMapper {
    int countByExample(BizInstructOrderExample example);

    int deleteByExample(BizInstructOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(BizInstructOrder record);

    int insertSelective(BizInstructOrder record);

    List<BizInstructOrder> selectByExample(BizInstructOrderExample example);

    BizInstructOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BizInstructOrder record, @Param("example") BizInstructOrderExample example);

    int updateByExample(@Param("record") BizInstructOrder record, @Param("example") BizInstructOrderExample example);

    int updateByPrimaryKeySelective(BizInstructOrder record);

    int updateByPrimaryKey(BizInstructOrder record);

    List<InstructOrderVo> selectByExampleExt(@Param("example") BizInstructOrderExample example,@Param("search") InstructOrderSearch search);
}