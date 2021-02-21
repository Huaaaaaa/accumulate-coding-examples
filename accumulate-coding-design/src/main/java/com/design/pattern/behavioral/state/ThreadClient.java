package com.design.pattern.behavioral.state;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  22:10
 * @Description: 模拟线程运行状态的客户端
 */
public class ThreadClient {

    public static void main(String[] args) {
        ThreadContext threadContext = new ThreadContext(new NewState());
        threadContext.start();
        threadContext.getCpu();
        threadContext.resume();
        threadContext.stop();
    }
}
