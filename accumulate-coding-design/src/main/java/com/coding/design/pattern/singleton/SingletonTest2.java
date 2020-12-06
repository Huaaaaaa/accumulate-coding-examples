package com.coding.design.pattern.singleton;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 第二种实现方式，饿汉式的静态代码块
 * Time 19:36
 */
public class SingletonTest2 {

    public static void main(String[] args) {
        System.out.println("单例模式饿汉式之静态代码块方式");
        Singleton2 singleton1 = Singleton2.getInstance();
        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println("singleton1" + (singleton1 == singleton2 ? "等于" : "不等于") + "singleton2");
        System.out.println("singleton1HashCode=" + singleton1.hashCode());
        System.out.println("singleton2HashCode=" + singleton2.hashCode());
    }
}

class Singleton2 {

    private static final Singleton2 instance;

    private Singleton2() {

    }

    static {
        instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return instance;
    }


}


