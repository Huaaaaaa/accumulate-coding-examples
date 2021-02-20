package com.design.pattern.behavioral.mediator.smarthouse;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  11:08
 * @Description: 具体同事类：音响
 */
public class ColleagueAudioMachine extends Colleague{

    public ColleagueAudioMachine(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(this,name);
    }

    /**
     * 咖啡机发送执行命令
     * @param message：start-开始煮咖啡;end-咖啡煮好了
     */
    @Override
    void sendMessage(String message) {
        System.out.println(">>>>>智能音响开始工作<<<<<");
        getMediator().receive(getName(),message);
    }

    public void on() {
        System.out.println("=====小爱同学开始开始播放新闻=====");
    }

    public void off() {
        System.out.println("=====小爱同学退出=====");
    }
}
