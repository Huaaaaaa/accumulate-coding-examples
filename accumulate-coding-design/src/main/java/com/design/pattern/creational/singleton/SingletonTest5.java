package com.design.pattern.creational.singleton;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 第五种实现方式：懒汉式之同步代码块线程安全方式
 * Time 19:36
 */
public class SingletonTest5 {

    public static void main(String[] args) {
        System.out.println("单例模式懒汉式之同步代码块线程安全方式");
        Singleton5 singleton1 = Singleton5.getInstance();
        Singleton5 singleton2 = Singleton5.getInstance();
        System.out.println("singleton1" + (singleton1 == singleton2 ? "等于" : "不等于") + "singleton2");
        System.out.println("singleton1HashCode=" + singleton1.hashCode());
        System.out.println("singleton2HashCode=" + singleton2.hashCode());
    }
}

class Singleton5 {

    private static Singleton5 instance;

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                instance = new Singleton5();
            }
        }
        return instance;
    }
}



