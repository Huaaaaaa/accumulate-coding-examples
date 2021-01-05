package com.design.pattern.creational.singleton;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 第三种实现方式：懒汉式模式之线程不安全
 * Time 19:36
 */
public class SingletonTest3 {

    public static void main(String[] args) {
        System.out.println("单例模式懒汉式之线程不安全方式");
        Singleton3 singleton1 = Singleton3.getInstance();
        Singleton3 singleton2 = Singleton3.getInstance();
        System.out.println("singleton1" + (singleton1 == singleton2 ? "等于" : "不等于") + "singleton2");
        System.out.println("singleton1HashCode=" + singleton1.hashCode());
        System.out.println("singleton2HashCode=" + singleton2.hashCode());
    }
}

class Singleton3 {

    private static Singleton3 instance;

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}



