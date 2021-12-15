package com.coding.interview.design.observer;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/15 4:04 下午
 * @Description:
 */
public class SubscriberUserLiSi extends SubscriberUser {

    public SubscriberUserLiSi(String name) {
        super(name);
    }

    @Override
    public void read() {
        System.out.println(name + " is reading the article");
    }
}
