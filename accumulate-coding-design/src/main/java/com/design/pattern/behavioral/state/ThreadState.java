package com.design.pattern.behavioral.state;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  21:23
 * @Description: 抽象状态类
 */
public abstract class ThreadState {

    /**
     * 当前状态
     */
    protected ThreadStatusEnum currentStatus;

    public ThreadStatusEnum getCurrentStatus() {
        return currentStatus;
    }

    /**
     * 启动线程，进入就绪状态（可运行）
     */
    public abstract void start(ThreadContext threadContext);

    /**
     * 获取到cpu，进入运行状态
     */
    public abstract void getCpu(ThreadContext threadContext);

    /**
     * 执行完毕，线程结束，进入死亡状态
     */
    public abstract void stop(ThreadContext threadContext);

    /**
     * 线程挂起，进入阻塞状态
     */
    public abstract void suspend(ThreadContext threadContext);


    /**
     * 线程恢复，进入就绪状态
     */
    public abstract void resume(ThreadContext threadContext);
}
