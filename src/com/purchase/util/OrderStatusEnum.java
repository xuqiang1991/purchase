package com.purchase.util;

/**
 * 采购单状态
 * Created by xuqiang
 * 2018/8/18.
 */
public enum OrderStatusEnum {

    /** 采购单状态 **/
    STATUS_0(0,"未提交"),
    STATUS_1(1,"已提交"),
    STATUS_2(2,"成本部已审核"),
    STATUS_3(3,"工程部已审核"),
    STATUS_4(4,"总经理已审核"),
    STATUS_5(5,"已合同编号");


    private Integer code;
    private String name;

    OrderStatusEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public static OrderStatusEnum getVisitorByCode(String code){
        OrderStatusEnum rst = null;
        for(OrderStatusEnum enu : OrderStatusEnum.values()){
            if(enu.getCode().equals(code)){
                rst = enu;
            }
        }
        return rst;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
