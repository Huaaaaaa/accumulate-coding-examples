package com.coding.interview.thread;

/**
 * @author: huayingcao
 * @createTime: 2021/12/13 3:44 下午
 * @description: 北京掌上先机面试题：一个线程可以调用两次start()方法吗？
 */
public class StartThreadTwice {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("first start..."));
        thread.start();
        thread.start();
    }
}
