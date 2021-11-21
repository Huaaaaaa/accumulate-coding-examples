package com.accumulate.coding.basic.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/11/18
 * @description:
 */
public class ThreadPoolResourceReading {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        int threadNum = 0;
        do {
            executorService.execute(() -> System.out.println("当前线程：" + Thread.currentThread().getName()));
            if (threadNum == 0) {
                int max = 1 << 30;
                int halfMax = max >>> 1;
                System.out.println("max=" + max);
                System.out.println("halfMax=" + halfMax);
            }
            threadNum++;
        } while (threadNum < 5);
    }
}
