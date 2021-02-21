package com.design.pattern.behavioral.state;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  21:42
 * @Description: 具体状态类：死亡状态DeadState
 */
public class DeadState extends ThreadState {

    @Override
    public void start(ThreadContext threadContext) {
        System.out.println("线程已结束，不支持start方法");
    }

    @Override
    public void getCpu(ThreadContext threadContext) {
        System.out.println("线程已结束，不支持getCpu方法");
    }

    @Override
    public void stop(ThreadContext threadContext) {
        System.out.println("线程已结束，不支持stop方法");
    }

    @Override
    public void suspend(ThreadContext threadContext) {
        System.out.println("线程已结束，不支持suspend方法");
    }

    @Override
    public void resume(ThreadContext threadContext) {
        System.out.println("线程已结束，不支持resume方法");
    }

    public DeadState() {
        currentStatus = ThreadStatusEnum.DEAD;
        System.out.println("线程运行完成，线程死亡..");
    }

}
