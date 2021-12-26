package com.coding.interview.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/26 3:46 下午
 * @description:
 */
public class ThreadLocalSource {

    /**
     * 首先要对ThreadLocal进行初始化
     */
    private static ThreadLocal<Map<String, String>> threadLocal = ThreadLocal.withInitial(HashMap::new);


    public static void main(String[] args) {
        new Thread(() -> {
            String name = Thread.currentThread().getName();
            threadLocal.get().put("t1", name);
            String t1 = threadLocal.get().get("t1");
            String t2 = threadLocal.get().get("t2");
            System.out.println(name + "获取threadLocal中的值，t1=" + t1 + ";t2=" + t2);
        }).start();
        new Thread(() -> {
            String name = Thread.currentThread().getName();
            threadLocal.get().put("t2", name);
            String t1 = threadLocal.get().get("t1");
            String t2 = threadLocal.get().get("t2");
            System.out.println(name + "获取threadLocal中的值，t1=" + t1 + ";t2=" + t2);
        }).start();
    }

}
