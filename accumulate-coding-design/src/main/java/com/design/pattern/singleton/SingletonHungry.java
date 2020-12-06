package com.design.pattern.singleton;

/**
 * Date:  2020/11/8
 * Todo:  单例模式基础款---饿汉式
 * Time 18:21
 */
public class SingletonHungry {

    private String key;

    private static SingletonHungry instance = new SingletonHungry();

    private SingletonHungry() {
        System.out.println("Hello Singleton!");
    }

    /**
     * 特点：定义时就完成实例化
     * 缺点：如果该单例不会被用到，但是已经分配了内存，造成空间的浪费！！
     */
    public static SingletonHungry getInstance() {
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
        return "SingletonBasic{" +
                "key='" + key + '\'' +
                '}';
    }
}
