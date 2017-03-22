package com.an.zxing.model;

import java.io.Serializable;

/*
* 作者：qydq/shiluohua,
 * email:qyddai@gmail.com
 * 如使用标明出处。
* */
public class ResponeZxingCodeModel implements Serializable {
    private String code;
    private String strs[];
    private String age;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String[] getStrs() {
        return strs;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
