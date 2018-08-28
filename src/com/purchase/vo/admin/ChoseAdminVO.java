package com.purchase.vo.admin;

import java.io.Serializable;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/26 17:40
 * @Description:
 */
public class ChoseAdminVO implements Serializable {
    private String value;
    private String text;

    public ChoseAdminVO(String value, String text) {
        this.value = value;
        this.text = text;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
