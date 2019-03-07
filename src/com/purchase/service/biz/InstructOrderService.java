package com.purchase.service.biz;

import com.purchase.pojo.biz.BizInstructOrder;
import com.purchase.util.ResultUtil;
import com.purchase.vo.Search.InstructOrderSearch;

/**
 * @author zhoujb
 * @Title: InstructOrder
 * @ProjectName purchase
 * @Description: 指令单接口
 * @date 2019-03-0411:32
 */
public interface InstructOrderService {

    ResultUtil getList(Integer page, Integer limit, InstructOrderSearch search);

    ResultUtil save(BizInstructOrder order);

    ResultUtil del(String id);

    /**
     * 根据ID查询指令单
     * @param id
     * @return
     */
    BizInstructOrder findById(String id);

    /**
     * 检查指令单是否唯一
     * @param instructOrder
     * @return
     */
    boolean checkInstructNo(BizInstructOrder instructOrder);

}
