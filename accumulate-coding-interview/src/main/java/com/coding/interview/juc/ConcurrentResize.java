package com.coding.interview.juc;

import com.sun.corba.se.spi.orbutil.threadpool.NoSuchThreadPoolException;
import io.swagger.models.auth.In;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/30 11:21 上午
 * @description: 并发扩容
 */
public class ConcurrentResize {

    private ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100000, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10000), Executors.privilegedThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        ConcurrentResize concurrentResize = new ConcurrentResize();
        concurrentResize.concurrentResize();
    }

    public void concurrentResize() {
        int conNum = 100;
        HashMap<CustomKey, Integer> map = new HashMap<>(2);
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(conNum);

        System.out.println("执行之前，mapSize=" + map.size());
        try {
            AtomicInteger ai = new AtomicInteger(0);
            for (int i = 0; i < conNum; i++) {
                executor.execute(() -> {
                    int index = ai.incrementAndGet();
                    map.put(new CustomKey(index), index);
                    try {
                        begin.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            begin.countDown();
            executor.shutdown();
        }

        System.out.println("执行之后，mapSize=" + map.size());
        Iterator<Map.Entry<CustomKey, Integer>> iterator = map.entrySet().stream().iterator();
        while (iterator.hasNext()) {
            Map.Entry<CustomKey, Integer> next = iterator.next();
            System.out.println("key=" + next.getKey() + ",value=" + next.getValue());
        }
    }
}