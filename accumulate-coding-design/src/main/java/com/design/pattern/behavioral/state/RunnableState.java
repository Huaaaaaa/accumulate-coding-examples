package com.design.pattern.behavioral.state;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  21:42
 * @Description: 具体状态类：就绪状态RunnableState
 */
public class RunnableState extends ThreadState {


    public RunnableState() {
        currentStatus = ThreadStatusEnum.RUNNABLE;
        System.out.println("当前线程处于就绪状态");
    }

    @Override
    public void start(ThreadContext threadContext) {
        System.out.println("线程已就绪，不支持start方法");
    }

    @Override
    public void stop(ThreadContext threadContext) {
        System.out.println("线程已就绪，还未运行，不支持stop方法");
    }

    @Override
    public void suspend(ThreadContext threadContext) {
        System.out.println("线程已就绪，还未运行，不支持suspend方法");
    }

    @Override
    public void resume(ThreadContext threadContext) {
        System.out.println("线程已就绪，尚未挂起，不支持resume方法");
    }

    /**
     * 线程已启动，尝试获取CPU时间片，进入运行状态
     */
    public void getCpu(ThreadContext threadContext) {
        System.out.println("线程已启动，等待获取CPU时间片");
        if (currentStatus.equals(ThreadStatusEnum.RUNNABLE)) {
            System.out.println("线程获取到cpu时间片，进入Running状态...");
            threadContext.setThreadState(new RunningState());
        } else {
            System.out.println("当前线程不是就绪状态，不能调用getCpu()方法.");
        }
    }
}
