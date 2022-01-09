package com.coding.interview.io;

import clojure.lang.IFn;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/7 11:38 上午
 * @description:
 */
public class FanXingTest {

    public static void main(String[] args) {
        FanXing<Integer> intTest = new FanXing<Integer>(null);
        FanXing<String> strTest = new FanXing<String>(null);
        FanXing<Double> douTest = new FanXing<Double>(null);
        System.out.println(intTest.get());
        System.out.println(strTest.get());
        System.out.println(douTest.get());
    }
}
