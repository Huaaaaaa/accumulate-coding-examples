package com.design.pattern.creational.singleton;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 第一种实现方式：饿汉式
 * Time 19:36
 */
public class SingletonTest1 {

    public static void main(String[] args) {
        System.out.println("单例模式饿汉式之静态常量方式");
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton2 = Singleton1.getInstance();
        System.out.println("singleton1" + (singleton1 == singleton2 ? "等于" : "不等于") + "singleton2");
        System.out.println("singleton1HashCode=" + singleton1.hashCode());
        System.out.println("singleton2HashCode=" + singleton2.hashCode());
    }
}


class Singleton1 {

    private static final Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }

}