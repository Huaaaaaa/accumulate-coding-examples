package com.accumulate.coding.basic.design.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Date:  2020/11/8
 * Todo:
 * Time 18:25
 */
public class SingletonRequest {

    public static void main(String[] args) {

//        SingletonHungry hungry = SingletonHungry.getInstance();
//        hungry.setKey("key");
//        System.out.println("hungry=" + JsonUtil.toJsonString(hungry));


//        SingletonLazy lazy = SingletonLazy.getInstance();
//        lazy.setKey("lazy");
//        System.out.println("lazy=" + JsonUtil.toJsonString(lazy));

        //模拟多个线程访问，发现存在一些实例的hashCode不一致，导致出现多例
        ExecutorService excutor = Executors.newFixedThreadPool(200);
        for (int i = 0; i < 200; i++) {
            Runnable runnable = () -> {
//                SingletonLazy lazy = SingletonLazy.getInstance();
//                SingletonLazy safely = SingletonLazy.getInstanceSafely();
//                SingletonLazy safelyAndFaster = SingletonLazy.getInstanceSafelyAndFaster();
                SingletonLazy doubleCheck = SingletonLazy.getInstanceByDoubleCheck();
                System.out.println(doubleCheck.hashCode());
            };
            excutor.execute(runnable);
        }

    }
}
