package com.design.pattern.behavioral.state;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  21:32
 * @Description: 具体状态类：新建状态NewState
 */
public class NewState extends ThreadState {

    public NewState() {
        currentStatus = ThreadStatusEnum.NEW;
    }

    /**
     * 新建状态的线程，可以执行启动行为
     */
    public void start(ThreadContext threadContext) {
        System.out.println("线程已创建，等待启动");
        if (currentStatus.equals(ThreadStatusEnum.NEW)) {
            System.out.println("线程创建完成，启动线程...");
            threadContext.setThreadState(new RunnableState());
        } else {
            System.out.println("当前线程不是新建状态，不能调用start()方法.");
        }
    }

    @Override
    public void getCpu(ThreadContext threadContext) {
        System.out.println("线程未启动，不支持getCpu方法");
    }

    @Override
    public void stop(ThreadContext threadContext) {
        System.out.println("线程未启动，不支持stop方法");
    }

    @Override
    public void suspend(ThreadContext threadContext) {
        System.out.println("线程未启动，不支持suspend方法");
    }

    @Override
    public void resume(ThreadContext threadContext) {
        System.out.println("线程未启动，不支持resume方法");
    }
}
