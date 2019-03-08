package com.purchase.mapper.biz;

import com.purchase.pojo.biz.BizOrderDetail;
import com.purchase.pojo.biz.BizOrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizOrderDetailMapper {
    int countByExample(BizOrderDetailExample example);

    int deleteByExample(BizOrderDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(BizOrderDetail record);

    int insertSelective(BizOrderDetail record);

    List<BizOrderDetail> selectByExample(BizOrderDetailExample example);

    BizOrderDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BizOrderDetail record, @Param("example") BizOrderDetailExample example);

    int updateByExample(@Param("record") BizOrderDetail record, @Param("example") BizOrderDetailExample example);

    int updateByPrimaryKeySelective(BizOrderDetail record);

    int updateByPrimaryKey(BizOrderDetail record);
}