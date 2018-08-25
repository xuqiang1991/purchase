package com.purchase.vo.order;

import java.util.Date;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/24 21:01
 * @Description:合同内请款单查询条件字段
 */
public class CAMSearch {

    /*单号、订单类型、来源订单、供应商、所属项目、合同号、请款人、开单人、开单日期、单据状态*/
    private String orderNo;
    private String orderType;
    private String sourceOrderId;
    private Long supplierId;
    private Long projectId;
    private Long applyUser;
    private Long createUser;
    private Date createTime;
    private Integer status;
}
