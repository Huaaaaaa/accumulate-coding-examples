package com.design.pattern.creational.singleton;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 第六种实现方式：懒汉式之双重检查机制方式（推荐使用）
 * Time 19:36
 */
public class SingletonTest6 {

    public static void main(String[] args) {
        System.out.println("单例模式懒汉式之双重检查机制方式（推荐使用）");
        Singleton6 singleton1 = Singleton6.getInstance();
        Singleton6 singleton2 = Singleton6.getInstance();
        System.out.println("singleton1" + (singleton1 == singleton2 ? "等于" : "不等于") + "singleton2");
        System.out.println("singleton1HashCode=" + singleton1.hashCode());
        System.out.println("singleton2HashCode=" + singleton2.hashCode());
    }
}

class Singleton6 {

    private static volatile Singleton6 instance;

    private Singleton6() {

    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}


