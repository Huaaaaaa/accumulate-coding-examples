package com.design.pattern.adapter.classadapter;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/13
 * Todo: 定义一个中文记者类
 * Time 10:06
 */
public class ChineseReporter {

    private String message;

    public ChineseReporter() {
        this.message = "你好！";
    }

    public String say() {
        return message;
    }
}
