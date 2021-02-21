package com.design.pattern.behavioral.state;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  21:24
 * @Description: 线程状态枚举
 */
public enum ThreadStatusEnum {
    NEW(0, "新建状态"),
    RUNNABLE(1, "就绪状态"),
    RUNNING(2, "运行状态"),
    BLOCK(3, "阻塞状态"),
    DEAD(4, "死亡状态");

    private int status;

    private String description;

    ThreadStatusEnum(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
