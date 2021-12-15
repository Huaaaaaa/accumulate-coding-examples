package com.coding.interview.design.observer;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/15 4:11 下午
 * @Description:
 */
public abstract class SubscriberUser {

    protected String name;

    public abstract void read();

    public SubscriberUser(String name) {
        this.name = name;
    }
}
