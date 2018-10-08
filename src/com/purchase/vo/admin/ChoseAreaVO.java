package com.purchase.vo.admin;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: zhoujb
 * @Date: 2018/8/26 17:40
 * @Description:
 */
public class ChoseAreaVO implements Serializable {
    private String value;
    private String text;
    private List<ChoseAreaVO> children;

    public ChoseAreaVO(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public ChoseAreaVO(String value, String text, List<ChoseAreaVO> children) {
        this.value = value;
        this.text = text;
        this.children = children;
    }

    public List<ChoseAreaVO> getChildren() {
        return children;
    }

    public void setChildren(List<ChoseAreaVO> children) {
        this.children = children;
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
