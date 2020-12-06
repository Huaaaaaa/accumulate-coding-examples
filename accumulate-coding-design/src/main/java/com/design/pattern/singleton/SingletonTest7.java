package com.design.pattern.singleton;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 第七种实现方式：静态内部类方式
 * Time 19:36
 */
public class SingletonTest7 {

    public static void main(String[] args) {
        System.out.println("单例模式之静态内部类实现方式");
        Singleton7 singleton1 = Singleton7.getInstance();
        Singleton7 singleton2 = Singleton7.getInstance();
        System.out.println("singleton1" + (singleton1 == singleton2 ? "等于" : "不等于") + "singleton2");
        System.out.println("singleton1HashCode=" + singleton1.hashCode());
        System.out.println("singleton2HashCode=" + singleton2.hashCode());
    }
}

class Singleton7 {

    private Singleton7() {

    }

    private static class SingletonInstance {
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}


