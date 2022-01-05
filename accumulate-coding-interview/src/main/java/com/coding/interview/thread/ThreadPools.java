package com.coding.interview.thread;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author: me
 * @createTime: 2021/12/22 11:40 上午
 * @description: 创建固定线程池
 */
public class ThreadPools {


    public static void main(String[] args) {
        //fixedPool();
        //cachedPool();
        //scheduledPool();
        //newSinglePool();
        customPool();
    }

    /**
     * 线程数量可控，不会创建额外的线程，每次都复用固定数量的线程
     */
    public static void fixedPool() {
        System.out.println("------fixedPool begin execute------");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(() -> System.out.println("线程 " + Thread.currentThread().getName() + " 执行任务 task" + finalI));
        }
        executorService.shutdown();
    }


    /**
     * 在所有任务执行完成后，1分钟内空闲线程销毁，线程池中没有空闲线程
     */
    public static void cachedPool() {
        System.out.println("------cachedPool begin execute------");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 6; i++) {
            int finalI = i;
            executorService.execute(() -> {
                System.out.println("线程 " + Thread.currentThread().getName() + " 执行任务 task" + finalI);
            });
        }
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(() -> {
                System.out.println("线程 " + Thread.currentThread().getName() + " 执行任务 task" + finalI);
            });
        }
        executorService.shutdown();
    }


    /**
     * 定时执行
     */
    public static void scheduledPool() {
        System.out.println("------scheduledPool begin execute------");
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(7);
        /*for (int i = 0; i < 7; i++) {
            int finalI = i;
            //5秒之后，每隔2秒执行一次
            scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("当前时间" + new Date() + "线程 " + Thread.currentThread().getName() + " 执行任务 task" + finalI), 5000, 2000, TimeUnit.MILLISECONDS);
        }*/


        //5秒之后，每隔2秒执行一次:如果间隔小于任务执行时长，则任务结束立即执行【以固定速率执行】
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                System.out.println("scheduleAtFixedRate开始执行：" + DateFormat.getDateTimeInstance().format(new Date()));
                Thread.sleep(1000);
                System.out.println("scheduleAtFixedRate结束执行：" + DateFormat.getDateTimeInstance().format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, 5000, 5000, TimeUnit.MILLISECONDS);
        //1秒之后，延迟5秒执行一次:两次执行之间间隔5秒，如果延时小于任务执行时长，则任务执行结束后才进行延时【以固定延时执行】
        scheduledExecutorService.scheduleWithFixedDelay(
                () -> {
                    try {
                        System.out.println("scheduleWithFixedDelay开始执行：" + DateFormat.getDateTimeInstance().format(new Date()));
                        Thread.sleep(5000);
                        System.out.println("scheduleWithFixedDelay结束执行：" + DateFormat.getDateTimeInstance().format(new Date()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, 0, 5000, TimeUnit.MILLISECONDS);
        scheduledExecutorService.shutdown();
    }

    /**
     * 一直只有一个线程执行
     */
    public static void newSinglePool() {
        System.out.println("------newSinglePool begin execute------");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.execute(() -> System.out.println("线程 " + Thread.currentThread().getName() + " 执行任务 task" + finalI));
        }
        executorService.shutdown();
    }


    public static void customPool() {
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(20);
        /*
         * 20个并发，通过线程池执行过程如下：
         * 1、先让2个核心线程执行2个任务
         * 2、接下来的9个任务进入阻塞队列，等待执行
         * 3、再创建3个线程（5-2=3）执行8个任务
         * 4、还有1（15-2-9-3）个线程开启拒绝策略
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10));
        //允许回收核心线程
        executor.allowCoreThreadTimeOut(false);
        //提前创建核心线程
        boolean b = executor.prestartCoreThread();
        try {
            for (int i = 1; i <= 15; i++) {
                int finalI = i;
                executor.execute(() -> {
                    System.out.println("自定义线程池开始工作,当前线程：" + Thread.currentThread().getName() + "正在执行任务：" + finalI);
                    try {
                        start.await();
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
            start.countDown();
            executor.shutdown();
        }
    }


}
