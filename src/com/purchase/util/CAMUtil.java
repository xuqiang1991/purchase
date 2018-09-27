package com.purchase.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 合同内请款工具类
 * Created by xuqiang
 * 2018/9/27.
 */
public class CAMUtil {


    public static final String prefix = "CR-";

    /**
     * 生成采购单号
     * @param orderNo 当天最大采购单号
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
