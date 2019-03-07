package com.purchase.service.biz;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.biz.BizOrder;
import com.purchase.pojo.order.BizPurchaseOrderDetail;
import com.purchase.util.ResultUtil;
import com.purchase.vo.Search.BizOrderDetailSearch;
import com.purchase.vo.Search.BizOrderSearch;
import com.purchase.vo.biz.BizOrderVo;

/**
 * Created by xuqiang
 * 2018/8/15.
 */
public interface OrderService {

    /**
     * @Author zhoujb
     * @Description 分页获取列表
     * @Date 2019-03-06 14:13
     * @Param
     * @return
     **/
    ResultUtil getList(Integer page, Integer limit, BizOrderSearch search);

    /**
     * @Author zhoujb
     * @Description 保存
     * @Date 2019-03-06 14:13
     * @Param
     * @return
     **/
    ResultUtil save(BizOrder order);

    /**
     * @Author zhoujb
     * @Description 查询某条记录
     * @Date 2019-03-06 14:14
     * @Param
     * @return
     **/
    BizOrderVo selInfo(String id, Long adminId);

    /**
     * @Author zhoujb
     * @Description 删除
     * @Date 2019-03-06 14:14
     * @Param
     * @return
     **/
    ResultUtil delOrder(String id);

    /**
     * @Author zhoujb
     * @Description 提交，保存后的提交操作，标识已经进入审批流程
     * @Date 2019-03-06 14:14
     * @Param
     * @return
     **/
    ResultUtil submit(String id, Long userId, Long roleId);

    /**
     * @Author zhoujb
     * @Description 审批
     * @Date 2019-03-06 14:15
     * @Param
     * @return
     **/
    ResultUtil review(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion, Long applyRole);

    /**
     * @Author zhoujb
     * @Description 作废
     * @Date 2019-03-06 14:15
     * @Param
     * @return
     **/
    ResultUtil invalid(TbAdmin admin);


    /**
     * @Author zhoujb
     * @Description 保存详情
     * @Date 2019-03-06 14:17
     * @Param
     * @return
     **/
    ResultUtil saveItem(BizPurchaseOrderDetail order);

    /**
     * @Author zhoujb
     * @Description 删除详情
     * @Date 2019-03-06 14:17
     * @Param
     * @return
     **/
    ResultUtil delItem(String itemId);

    /**
     * @Author zhoujb
     * @Description 获取某条详情
     * @Date 2019-03-06 14:17
     * @Param
     * @return
     **/
    ResultUtil getItem(String itemId);

    /**
     * @Author zhoujb
     * @Description 获取订单明细
     * @Date 2019-03-07 21:48
     * @Param
     * @return
     **/
    ResultUtil getItemList(BizOrderDetailSearch search);


}
