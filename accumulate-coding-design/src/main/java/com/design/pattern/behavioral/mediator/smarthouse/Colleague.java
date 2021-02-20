package com.design.pattern.behavioral.mediator.smarthouse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  11:05
 * @Description: 抽象同事类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Colleague {

    /**
     * 聚合中介
     */
    private Mediator mediator;

    /**
     * 具体同事类名称
     */
    private String name;

    /**
     * 由中介执行命令
     */
    abstract void sendMessage(String message);


}
