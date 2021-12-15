package com.coding.interview.design.observer;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/15 4:03 下午
 * @Description:
 */
public class SubscriberUserZhang extends SubscriberUser {

    public SubscriberUserZhang(String name) {
        super(name);
    }

    @Override
    public void read() {
        System.out.println(name + " is reading the article");
    }
}
