package com.design.pattern.behavioral.mediator.smarthouse;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  11:08
 * @Description: 具体同事类：咖啡机
 */
public class ColleagueCoffeeMachine extends Colleague{

    public ColleagueCoffeeMachine(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(this,name);
    }

    /**
     * 咖啡机发送执行命令
     * @param message：start-开始煮咖啡;end-咖啡煮好了
     */
    @Override
    void sendMessage(String message) {
        System.out.println(">>>>>智能咖啡机开始工作<<<<<");
        getMediator().receive(getName(),message);
    }

    public void start() {
        System.out.println("=====咖啡机开始制作咖啡=====");
    }

    public void finish() {
        System.out.println("=====咖啡机制作好咖啡了=====");
    }
}
