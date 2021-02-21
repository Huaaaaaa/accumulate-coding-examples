package com.design.pattern.behavioral.state;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  21:31
 * @Description: 线程上下文，及处理业务逻辑的地方
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThreadContext {

    private ThreadState threadState;

    /**
     * 启动线程，进入就绪状态（可运行）
     */
    public void start() {
        threadState.start(this);
    }

    /**
     * 获取到cpu，进入运行状态
     */
    public void getCpu() {
        threadState.getCpu(this);
    }

    /**
     * 执行完毕，线程结束，进入死亡状态
     */
    public void stop() {
        threadState.stop(this);
    }

    /**
     * 线程挂起，进入阻塞状态
     */
    public void suspend() {
        threadState.suspend(this);
    }


    /**
     * 线程恢复，进入就绪状态
     */
    public void resume() {
        threadState.resume(this);
    }
}


