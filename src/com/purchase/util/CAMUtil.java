package com.purchase.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 合同内请款工具类
 * Created by xuqiang
 * 2018/9/27.
 */
public class CAMUtil {


    /** 合同内请款单状态 **/
    public static final int STATUS_0 = 0;//未提交
    public static final int STATUS_1 = 1;//已提交
    public static final int STATUS_2 = 2;//成本部已审核
    public static final int STATUS_3 = 3;//工程部已审核
    public static final int STATUS_4 = 4;//总经理已审核
    public static final int STATUS_5 = 5;//已合同编号


    public static final String prefix = "CR-";

    /**
     * 生成合同内请款单号
     * @param orderNo 当天最大合同内请款单号
     * @return
     */
    public static synchronized String generateOrderNo(String orderNo){

        String suffix = null;
        Date date = new Date();
        String yyddmm = DateUtil.formatDate(date,DateUtil.DateFormat3);

        String pn = null;
        if(StringUtils.isBlank(orderNo)){
            suffix = "001";
            pn = prefix + yyddmm  + "-" + suffix;
        }else {
            int no = Integer.parseInt(orderNo.substring(orderNo.length() - 3));
            pn = orderNo.substring(0,orderNo.length() - 3) + String.format("%03d", ++no);
        }
        return pn;
    }


    public static void main(String[] args) {
        String pn = generateOrderNo(null);
        System.out.println(pn);
        pn = generateOrderNo(pn);
        System.out.println(pn);
    }
}
