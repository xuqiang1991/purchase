package com.purchase.vo.order;

import java.util.Date;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/24 21:01
 * @Description:合同内请款单查询条件字段
 */
public class UCAMSearch {

    /*单号、单据类型、供应商、所属项目、有无指令、指令单号、请款人、开单人、开单日期、单据状态*/
    private String orderNo;
    private String orderType;
    private Long supplierId;
    private Long projectId;
    private String instructOrderFlag;
    private String instructOrderNo;
    private Long applyUser;
    private Long createUser;
    private Date createTime;
    private Integer status;
}
