package com.coding.interview.curr;

import java.util.concurrent.*;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/31 12:43 下午
 * @description:
 */
public class CurrCaller {

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(990), Executors.privilegedThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int requestCount = 1000;
        UserFutureServiceImpl userFutureService = new UserFutureServiceImpl();
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(requestCount);
        try {
            for (int i = 1; i <= requestCount; i++) {
                String userId = String.valueOf(i);
                executor.execute(() -> {
                    UserVo userVo = userFutureService.getUserBatchWithFuture(userId);
                    System.out.println("第" + userId + "个用户=" + userVo);
                    try {
                        begin.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                });
                /*submit = (Future<UserVo>) executor.submit(() -> {
                    UserVo userVo = userFutureService.getUserBatchWithFuture(userId);
                    System.out.println("第" + userId + "个用户=" + userVo);
                    try {
                        begin.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                });*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            begin.countDown();
            executor.shutdown();
        }
    }
}
