package com.design.pattern.behavioral.mediator.smarthouse;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  11:08
 * @Description: 具体同事类：窗帘
 */
public class ColleagueWindowCurtain extends Colleague {

    public ColleagueWindowCurtain(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(this, name);
    }

    /**
     * 电视发送执行命令
     *
     * @param message：open-开窗帘；close:关窗帘
     */
    @Override
    void sendMessage(String message) {
        System.out.println(">>>>>智能窗帘开始工作<<<<<");
        getMediator().receive(getName(), message);
    }


    public void open() {
        System.out.println("=====打开窗帘了=====");
    }

    public void close() {
        System.out.println("=====窗帘关闭了=====");
    }
}
