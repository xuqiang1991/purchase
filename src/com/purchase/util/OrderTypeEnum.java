package com.purchase.util;

/**
 * 合同订单类型
 * Created by xuqiang
 * 2018/8/18.
 */
public enum OrderTypeEnum {

    /** 合同订单状态 **/
    STATUS_0("0","绿化苗木"),
    STATUS_1("1","园建水电"),
    STATUS_2("2","机械租赁"),
    STATUS_3("3","工程分包");


    private String code;
    private String name;

    OrderTypeEnum(String code, String name){
        this.code = code;
        this.name = name;
    }

    public static OrderTypeEnum getVisitorByCode(String code){
        OrderTypeEnum rst = null;
        for(OrderTypeEnum enu : OrderTypeEnum.values()){
            if(enu.getCode().equals(code)){
                rst = enu;
            }
        }
        return rst;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
