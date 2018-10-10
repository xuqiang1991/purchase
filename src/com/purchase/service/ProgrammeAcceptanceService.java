package com.purchase.service;

import com.purchase.pojo.admin.TbAdmin;
import com.purchase.pojo.order.BizProgrammeAcceptanceOrder;
import com.purchase.pojo.order.BizProgrammeAcceptanceOrderDetail;
import com.purchase.util.ResultUtil;
import com.purchase.vo.order.ProgrammeAcceptanceDetialVo;
import com.purchase.vo.order.ProgrammeAcceptanceSearch;
import com.purchase.vo.order.ProgrammeAcceptanceVo;

/**
 * @Auther: zhoujb
 * @Date: 2018/10/5 17:27
 * @Description:工程验收service接口
 */
public interface ProgrammeAcceptanceService {
    ResultUtil getPAOOrderList(Integer page, Integer limit, ProgrammeAcceptanceSearch search);

    ResultUtil savePAOOrder(BizProgrammeAcceptanceOrder order);

    ProgrammeAcceptanceVo selPAOOrder(String id, Long adminId);

    ResultUtil selPAOOrderByOrder(String orderNo);

    ResultUtil delPAOOrder(String id);

    ResultUtil submitPAOOrder(String id);

    ProgrammeAcceptanceDetialVo selPAODetail(String id,Long adminId);

    ResultUtil addPAOOrderDetail(BizProgrammeAcceptanceOrderDetail order);

    ResultUtil editPAOOrderDetail(BizProgrammeAcceptanceOrderDetail order);

    ResultUtil deletePAOItem(String id);

    ResultUtil selPAOItem(String id);

    ResultUtil submitReviewPAOOrder(TbAdmin admin, String id, Long userId);

    ResultUtil reviewPAOOrder(TbAdmin admin, String id, Boolean auditResults, Long applyUser, String auditOpinion);
}
