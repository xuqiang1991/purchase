package com.purchase.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 付款单工具类
 * Created by xuqiang
 * 2018/10/7.
 */
public class PaymentOrderUtil {


    public static final String prefix = "PM-";

    /**
     * 生成付款单号
     * @param orderNo 当天最大付款单号
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
