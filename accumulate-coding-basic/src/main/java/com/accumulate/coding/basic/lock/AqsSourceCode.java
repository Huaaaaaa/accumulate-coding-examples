package com.accumulate.coding.basic.lock;

import org.springframework.ui.context.Theme;
import org.springframework.util.StopWatch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/11/19
 * @description:
 */
public class AqsSourceCode {

    private static Integer STORE = 5;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 200; i++) {
            new Thread(AqsSourceCode::secondKill).start();
        }

    }

    private static void secondKill() {
        STORE--;
        if (STORE >= 0) {
            System.out.println("当前线程：" + Thread.currentThread().getName() + ";剩余库存：" + STORE + ";当前时间：" + System.currentTimeMillis());
        } else {
            System.out.println("当前线程：" + Thread.currentThread().getName() + "；库存不足;当前时间：" + System.currentTimeMillis());
        }
    }
}
