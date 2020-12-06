package com.coding.design.pattern.singleton;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 第四种实现方式：懒汉式之同步方法线程安全方式
 * Time 19:36
 */
public class SingletonTest4 {

    public static void main(String[] args) {
        System.out.println("单例模式懒汉式之同步方法线程安全方式");
        Singleton4 singleton1 = Singleton4.getInstance();
        Singleton4 singleton2 = Singleton4.getInstance();
        System.out.println("singleton1" + (singleton1 == singleton2 ? "等于" : "不等于") + "singleton2");
        System.out.println("singleton1HashCode=" + singleton1.hashCode());
        System.out.println("singleton2HashCode=" + singleton2.hashCode());
    }
}


class Singleton4 {

    private static Singleton4 instance;

    private Singleton4() {

    }

    public synchronized static Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}

