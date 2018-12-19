package com.purchase.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 合同订单工具类
 * Created by xuqiang
 * 2018/8/18.
 */
public class UCAMUtil {

    /** 合同订单状态 **/
    public static final int STATUS_0 = 0;//未提交
    public static final int STATUS_1 = 1;//已提交
    public static final int STATUS_2 = 2;//成本部已审核
    public static final int STATUS_3 = 3;//工程部已审核
    public static final int STATUS_4 = 4;//总经理已审核
    public static final int STATUS_5 = 5;//已合同编号


    public static final String prefix = "PO-";

    /**
     * 生成合同订单号
     * @param purchaseNo 当天最大合同订单号
     * @return
     */
    public static synchronized String generatePurchaseNo(String purchaseNo){

        String suffix = null;
        Date date = new Date();
        String yyddmm = DateUtil.formatDate(date,DateUtil.DateFormat3);

        String pn = null;
        if(StringUtils.isBlank(purchaseNo)){
            suffix = "001";
            pn = prefix + yyddmm  + "-" + suffix;
        }else {
            int no = Integer.parseInt(purchaseNo.substring(purchaseNo.length() - 3));
            pn = purchaseNo.substring(0,purchaseNo.length() - 3) + String.format("%03d", ++no);
        }
        return pn;
    }


    public static void main(String[] args) {
        String pn = generatePurchaseNo(null);
        System.out.println(pn);
        pn = generatePurchaseNo(pn);
        System.out.println(pn);
    }
}
