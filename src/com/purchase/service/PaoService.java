package com.purchase.service;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizProgrammeAcceptanceOrder;
import com.purchase.pojo.order.BizProgrammeAcceptanceOrderDetail;
import com.purchase.util.ResultUtil;
import com.purchase.vo.order.PaoOrderDetialVo;
import com.purchase.vo.order.PaoSearch;
import com.purchase.vo.order.PaoVo;

/**
 * @Auther: zhoujb
 * @Date: 2018/10/5 17:27
 * @Description:工程验收service接口
 */
public interface PaoService {
    ResultUtil getPAOOrderList(Integer page, Integer limit, PaoSearch search);

    ResultUtil addPAOOrder(BizProgrammeAcceptanceOrder order);

    ResultUtil editPAOOrder(BizProgrammeAcceptanceOrder order);

    PaoVo selPAOOrder(String id);

    ResultUtil selPAOOrderByOrder(String orderNo);

    ResultUtil delPAOOrder(String id);

    ResultUtil submitPAOOrder(String id);

    PaoOrderDetialVo selPAODetail(String id);

    ResultUtil addPAOOrderDetail(BizProgrammeAcceptanceOrderDetail ucamDetail);

    ResultUtil deletePAOItem(String id);

    ResultUtil submitReviewPAOOrder(TbAdmin admin, String id, Long userId);

    ResultUtil reviewPAOOrder(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion);
}
