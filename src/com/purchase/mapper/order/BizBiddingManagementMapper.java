package com.purchase.mapper.order;

import com.purchase.pojo.order.BizBiddingManagement;
import com.purchase.pojo.order.BizBiddingManagementExample;
import java.util.List;

import com.purchase.pojo.order.BizContractApplyMoney;
import com.purchase.pojo.order.BizUncontractApplyMoneyExample;
import com.purchase.vo.order.BiddingManagementSearch;
import com.purchase.vo.order.BiddingManagementVo;
import com.purchase.vo.order.UCAMSearch;
import com.purchase.vo.order.UCAMVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BizBiddingManagementMapper {
    int countByExample(BizBiddingManagementExample example);

    int deleteByExample(BizBiddingManagementExample example);

    int deleteByPrimaryKey(String id);

    int insert(BizBiddingManagement record);

    int insertSelective(BizBiddingManagement record);

    List<BizBiddingManagement> selectByExample(BizBiddingManagementExample example);

    BizBiddingManagement selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BizBiddingManagement record, @Param("example") BizBiddingManagementExample example);

    int updateByExample(@Param("record") BizBiddingManagement record, @Param("example") BizBiddingManagementExample example);

    int updateByPrimaryKeySelective(BizBiddingManagement record);

    int updateByPrimaryKey(BizBiddingManagement record);

    @Select("select max(order_no) order_no from biz_bidding_management where order_no like '%${prefix}%'")
    String selMaxNo(@Param("prefix") String prefix);

    @Select("select * from biz_bidding_management where order_no = #{orderNo}")
    BizBiddingManagement selectByOrderNo(@Param("orderNo") String orderNo);

    List<BiddingManagementVo> selectByExampleExt(@Param("example") BizBiddingManagementExample example, @Param("search") BiddingManagementSearch search);
}