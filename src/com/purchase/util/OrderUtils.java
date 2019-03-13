package com.purchase.util;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.StringUtils;

public class OrderUtils {

    public static final String DOMAIN_NAME = "http://wx.cxqiang.com";

    //订单前缀
    public static final String PREFIX_PO = "PO-";


    public static final int IS_APPROVAL_NO = 0;//未提交、驳回
    public static final int IS_APPROVAL_YES = 1;//已提交、通过

    public static final int IS_SAVE_SUBMIT_0 = 0;//未提交
    public static final int IS_SAVE_SUBMIT_1 = 1;//已提交
    public static final int IS_SAVE_SUBMIT_2 = 2;//完结

    /**
     * @Author zhoujb
     * @Description 订单状态
     * @Date 2019-03-13 10:20
     **/
    public static final int STATUS_0 = 0;//未提交
    public static final int STATUS_1 = 1;//已提交
    public static final int STATUS_2 = 2;//审核中
    public static final int STATUS_3 = 3;//完结

    public static String getUserItem(String userItem,String userId){
        if(StringUtils.isEmpty(userItem)){
            return userId;
        }else{
            String[] arr = userItem.split(",");
            if(!ArrayUtils.contains(arr, userId)){
                return userItem.concat(",").concat(userId);
            }else{
                return userItem;
            }
        }
    }
}
