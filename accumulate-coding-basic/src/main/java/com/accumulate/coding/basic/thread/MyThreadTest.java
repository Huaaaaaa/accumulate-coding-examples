package com.accumulate.coding.basic.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/11/12
 * @description:
 */
public class MyThreadTest {

    public static void main(String[] args) {

        //CountDownLatch countDownLatch = new CountDownLatch(200);
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 200; i++) {
            Thread thread = new MyThread("myThread" + i);
            thread.start();
        }
        Long time = System.currentTimeMillis() - start;
        System.out.println("usedTime=" + time);
        //System.out.println(countDownLatch.getCount());
        /*MyThread myThread1 = new MyThread("myThread1");
        MyThread myThread2 = new MyThread("myThread2");
        MyThread myThread3 = new MyThread("myThread3");
        MyThread myThread4 = new MyThread("myThread3");
        MyThread myThread5 = new MyThread("myThread3");
        myThread1.start();
        myThread2.start();
        myThread3.start();*/
    }
}
