package com.design.pattern.behavioral.mediator.smarthouse;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  11:04
 * @Description: 抽象中介者
 */
public interface Mediator {

    void register(Colleague colleague,String name);

    void receive(String colleagueName, String message);

    void send(String message);


}
