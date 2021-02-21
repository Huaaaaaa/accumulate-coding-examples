package com.design.pattern.behavioral.state;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  21:42
 * @Description: 具体状态类：运行状态RunningState
 */
public class RunningState extends ThreadState {

    public RunningState() {
        currentStatus = ThreadStatusEnum.RUNNING;
        System.out.println("当前线程处于运行状态");
    }

    @Override
    public void start(ThreadContext threadContext) {
        System.out.println("线程正在运行中，不支持start方法");
    }

    @Override
    public void getCpu(ThreadContext threadContext) {
        System.out.println("线程正在运行中，不支持getCpu方法");
    }

    @Override
    public void resume(ThreadContext threadContext) {
        System.out.println("线程正在运行中，不支持resume方法");
    }

    /**
     * 运行状态的线程，可以执行suspend方法进入阻塞状态
     */
    public void suspend(ThreadContext threadContext) {
        System.out.println("线程正在运行，因为异常被挂起");
        if (currentStatus.equals(ThreadStatusEnum.RUNNING)) {
            System.out.println("线程挂起，进入Block状态...");
            threadContext.setThreadState(new BlockState());
        } else {
            System.out.println("当前线程不是运行状态，不能调用suspend()方法.");
        }
    }

    /**
     * 运行状态的线程，可以执行执行stop方法结束
     */
    public void stop(ThreadContext threadContext) {
        System.out.println("线程正在运行，等待运行完毕");
        if (currentStatus.equals(ThreadStatusEnum.RUNNING)) {
            System.out.println("线程运行结束，进入Dead状态...");
            threadContext.setThreadState(new DeadState());
        } else {
            System.out.println("当前线程不是运行状态，不能调用stop()方法.");
        }
    }
}
