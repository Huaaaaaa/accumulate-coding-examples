package com.design.pattern.behavioral.mediator.smarthouse;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  11:08
 * @Description: 具体同事类：灯
 */
public class ColleagueLight extends Colleague{

    public ColleagueLight(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(this,name);
    }

    /**
     * 电视发送执行命令
     * @param message：open-开灯；close-关灯
     */
    @Override
    void sendMessage(String message) {
        System.out.println(">>>>>智能灯开始工作<<<<<");
        getMediator().receive(getName(),message);
    }

    public void open() {
        System.out.println("=====灯开了=====");
    }

    public void close() {
        System.out.println("=====灯关了=====");
    }
}
