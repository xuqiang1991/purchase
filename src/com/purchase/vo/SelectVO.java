package com.purchase.vo;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/27 14:11
 * @Description:
 */
public class SelectVO {
    private String value;
    private String text;

    public SelectVO(String value, String text) {
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
