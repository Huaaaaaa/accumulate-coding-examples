package com.accumulate.coding.basic.design.singleton;

import lombok.Synchronized;

/**
 * Author: Huaaaaaa
 * Date:  2020/11/8
 * Todo: 单例模式之懒汉式
 * Time 19:27
 */
public class SingletonLazy {

    private static volatile SingletonLazy instance = null;

    private String key;

    private SingletonLazy() {
        System.out.println("Hello lazy");
    }

    /**
     * 一般的懒汉模式，线程不安全
     * 特点：只有在实例被用到的时候才去实例化
     * 缺点：多线程访问时容易存在非单例的情况
     *
     * @return
     */
    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    /**
     * 优化一：使用synchronized关键字对整个方法加锁
     * 特点：通过加锁的方式解决线程不安全
     * 缺点：锁粒度太大，容易引起其他线程的阻塞
     *
     * @return
     */
    synchronized public static SingletonLazy getInstanceSafely() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }


    /**
     * 优化二：减小锁粒度，在方法中进行加锁
     * 特点：稍微减小了CPU开销
     * 缺点：当线程1和线程2同时访问到synchronized块时，可能创建多个实例
     *
     * @return
     */
    public static SingletonLazy getInstanceSafelyAndFaster() {

        if (instance == null) {
            synchronized (SingletonLazy.class) {
                instance = new SingletonLazy();
            }
        }
        return instance;
    }

    /**
     * 优化三：减小锁粒度，在方法中进行加锁，锁被占用时其他线程可以直接返回
     * 特点：使用双重检查机制
     * 缺点：避免不了指令重排序引起的创建多实例
     * 优化：使用volatile关键字避免cpu指令重排序
     *
     * @return
     */
    public static SingletonLazy getInstanceByDoubleCheck() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "SingletonLazy{" +
                "key='" + key + '\'' +
                '}';
    }
}
