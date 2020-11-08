package com.accumulate.coding.basic.design.singleton;

import com.accumulate.coding.basic.utils.JsonUtil;
import sun.nio.ch.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

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
        for (int i = 0; i < 100; i++) {
            Runnable runnable = () -> {
//                SingletonLazy lazy1 = SingletonLazy.getInstance();
//                SingletonLazy lazy2 = SingletonLazy.getInstanceSafely();
                SingletonLazy lazy3 = SingletonLazy.getInstanceSafelyAndFaster();
                System.out.println(lazy3.hashCode());
            };
            excutor.execute(runnable);
        }

    }
}
