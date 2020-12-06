package com.design.pattern.singleton;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 第八种实现方式：枚举方式（推荐使用）
 * Time 19:36
 */
public class SingletonTest8 {

    public static void main(String[] args) {
        System.out.println("单例模式之枚举方式（推荐使用）");
        Singleton8 singleton1 = Singleton8.INSTANCE;
        Singleton8 singleton2 = Singleton8.INSTANCE;
        System.out.println("singleton1" + (singleton1 == singleton2 ? "等于" : "不等于") + "singleton2");
        System.out.println("singleton1HashCode=" + singleton1.hashCode());
        System.out.println("singleton2HashCode=" + singleton2.hashCode());
        singleton1.ack();
        singleton2.ack();

        Runtime runtime = Runtime.getRuntime();
    }
}

enum Singleton8 {
    INSTANCE;

    public void ack() {
        System.out.println("i'm okay......");
    }
}

