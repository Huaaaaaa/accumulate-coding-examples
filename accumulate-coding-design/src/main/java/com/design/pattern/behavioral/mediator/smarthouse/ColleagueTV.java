package com.design.pattern.behavioral.mediator.smarthouse;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  11:08
 * @Description: 具体同事类：电视
 */
public class ColleagueTV extends Colleague{

    public ColleagueTV(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(this,name);
    }

    /**
     * 电视发送执行命令
     * @param message：open-开电视；close-关电视
     */
    @Override
    void sendMessage(String message) {
        System.out.println(">>>>>智能电视开始工作<<<<<");
        getMediator().receive(getName(),message);
    }


    public void open() {
        System.out.println("=====电视打开了=====");
    }

    public void close() {
        System.out.println("=====电视关闭了=====");
    }
}
