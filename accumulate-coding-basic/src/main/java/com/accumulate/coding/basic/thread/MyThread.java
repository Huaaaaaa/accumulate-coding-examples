package com.accumulate.coding.basic.thread;

/**
 * @author: cyhua
 * @createTime: 2021/11/12
 * @description:
 */
public class MyThread extends Thread {

    private static int num = 5;


    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
       /* while (num > 0) {
            num--;
            System.out.println("currentName=" + Thread.currentThread().getName() + ";num=" + num);
        }*/
        num--;
        System.out.println("currentName=" + Thread.currentThread().getName() + ";num=" + num);


    }
}
