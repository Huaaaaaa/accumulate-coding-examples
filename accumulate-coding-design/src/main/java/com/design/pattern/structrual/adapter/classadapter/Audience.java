package com.design.pattern.structrual.adapter.classadapter;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/13
 * Todo: 定义一个听众类
 * Time 10:18
 */
public class Audience {

    public static void main(String[] args) {
        EnglishRadio er = new EnglishRadio();
        er.broadCast(new ReporterAdapter());
    }
}
