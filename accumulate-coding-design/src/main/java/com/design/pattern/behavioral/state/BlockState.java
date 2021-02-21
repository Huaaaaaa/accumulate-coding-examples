package com.design.pattern.behavioral.state;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  21:42
 * @Description: 具体状态类：阻塞状态BlockState
 */
public class BlockState extends ThreadState {

    public BlockState() {
        currentStatus = ThreadStatusEnum.BLOCK;
        System.out.println("当前线程处于阻塞状态");
    }

    @Override
    public void start(ThreadContext threadContext) {
        System.out.println("线程阻塞中，不支持start方法");
    }

    @Override
    public void getCpu(ThreadContext threadContext) {
        System.out.println("线程阻塞中，不支持getCpu方法，请等待线程恢复");
    }

    @Override
    public void stop(ThreadContext threadContext) {
        System.out.println("线程阻塞中，不支持stop方法，请等待线程恢复并执行");
    }

    @Override
    public void suspend(ThreadContext threadContext) {
        System.out.println("线程阻塞中，不支持suspend方法");
    }

    /**
     * 阻塞状态的线程，可以执行resume方法进入就绪状态
     */
    public void resume(ThreadContext threadContext) {
        System.out.println("线程恢复，重新进入就绪状态");
        if (currentStatus.equals(ThreadStatusEnum.BLOCK)) {
            System.out.println("线程恢复，进入就绪状态...");
            threadContext.setThreadState(new RunnableState());
        } else {
            System.out.println("当前线程不是阻塞状态，不能调用resume()方法.");
        }
    }
}
