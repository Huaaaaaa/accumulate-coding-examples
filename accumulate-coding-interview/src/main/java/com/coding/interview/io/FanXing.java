package com.coding.interview.io;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/7 11:37 上午
 * @description:
 */
public class FanXing<T> {

    T data;

    public FanXing() {
    }

    public FanXing(T data) {
        this.data = data;
    }

    T get() {
        return data;
    }
}
