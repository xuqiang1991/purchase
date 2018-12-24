package com.purchase.util;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.StringUtils;

public class OrderUtils {

    public static final String DOMAIN_NAME = "http://wx.cxqiang.com";


    public static final int IS_APPROVAL_NO = 0;//未提交、驳回
    public static final int IS_APPROVAL_YES = 1;//已提交、通过

    public static final int IS_SAVE_SUBMIT_0 = 0;//未提交
    public static final int IS_SAVE_SUBMIT_1 = 1;//已提交
    public static final int IS_SAVE_SUBMIT_2 = 2;//完结

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
