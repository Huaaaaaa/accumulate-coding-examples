package com.design.pattern.behavioral.mediator.smarthouse;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  11:14
 * @Description: 具体中介实现类：智能语音助手
 */
public class SmartHouseMediator implements Mediator {

    //聚合智能家居
    private Map<String, Colleague> colleagues = new HashMap<>();

    /**
     * 在智能音响上注册智能家居，类似在小爱音响中添加智能家居设备
     *
     * @param colleague
     */
    @Override
    public void register(Colleague colleague, String name) {
        colleagues.putIfAbsent(name, colleague);
    }

    /**
     * 接受命令
     *
     * @param colleagueName
     * @param message:
     */
    @Override
    public void receive(String colleagueName, String message) {
        Colleague colleague = colleagues.get(colleagueName);
        if (colleague instanceof ColleagueCoffeeMachine) {
            ColleagueCoffeeMachine ccm = (ColleagueCoffeeMachine) colleague;
            if (message.equals(CommonConstants.SWITCH_START)) {
                ccm.start();
            } else {
                ccm.finish();
            }
        }
        if (colleague instanceof ColleagueWindowCurtain) {
            ColleagueWindowCurtain cwc = (ColleagueWindowCurtain) colleague;
            if (message.equals(CommonConstants.SWITCH_OPEN)) {
                cwc.open();
            } else {
                cwc.close();
            }
        }
        if (colleague instanceof ColleagueLight) {
            ColleagueLight cl = (ColleagueLight) colleague;
            if (message.equals(CommonConstants.SWITCH_OPEN)) {
                cl.open();
            } else {
                cl.close();
            }
        }
        if (colleague instanceof ColleagueTV) {
            ColleagueTV ct = (ColleagueTV) colleague;
            if (message.equals(CommonConstants.SWITCH_OPEN)) {
                ct.open();
            } else {
                ct.close();
            }
        }
        if (colleague instanceof ColleagueAudioMachine) {
            ColleagueAudioMachine cam = (ColleagueAudioMachine) colleague;
            if (message.equals(CommonConstants.SWITCH_ON)) {
                cam.on();
            } else {
                cam.off();
            }
        }
    }

    /**
     * getup-起床（拉开窗帘-煮咖啡-播放新闻）；cinema-影院模式（打开电视->关闭窗帘->关灯）;sleep-睡眠模式（拉窗帘-关电视-关灯-催眠音乐-5分钟后关闭音乐）
     *
     * @param message
     */
    @Override
    public void send(String message) {
        switch (message) {
            case CommonConstants.MODULE_GET_UP:
                getUpModule(this);
                break;
            case CommonConstants.MODULE_CINEMA:
                cinemaModule(this);
                break;
            case CommonConstants.MODULE_SLEEP:
                sleepModule(this);
                break;
            default:
                break;
        }
    }

    /**
     * 起床模式：拉开窗帘-煮咖啡-打开新闻
     */
    private void getUpModule(Mediator mediator) {
        System.out.println("早上好，美好的一天开始了");
        ColleagueWindowCurtain windowCurtain = (ColleagueWindowCurtain) colleagues.get(CommonConstants.SMART_CURTAIN);
        ColleagueCoffeeMachine coffeeMachine = (ColleagueCoffeeMachine) colleagues.get(CommonConstants.SMART_COFFEE);
        ColleagueAudioMachine audioMachine = (ColleagueAudioMachine) colleagues.get(CommonConstants.SMART_AUDIO);
        windowCurtain.sendMessage(CommonConstants.SWITCH_OPEN);
        coffeeMachine.sendMessage(CommonConstants.SWITCH_START);
        audioMachine.sendMessage(CommonConstants.SWITCH_ON);
        coffeeMachine.sendMessage(CommonConstants.SWITCH_END);
    }

    /**
     * 影院模式:打开电视->关闭窗帘->关灯
     */
    private void cinemaModule(Mediator mediator) {
        System.out.println("欢迎进入家庭影院，开始享受你的美好生活吧");
        ColleagueTV tv = (ColleagueTV) colleagues.get(CommonConstants.SMART_TV);
        ColleagueWindowCurtain windowCurtain = (ColleagueWindowCurtain) colleagues.get(CommonConstants.SMART_CURTAIN);
        ColleagueLight light = (ColleagueLight) colleagues.get(CommonConstants.SMART_LIGHT);
        tv.sendMessage(CommonConstants.SWITCH_OPEN);
        windowCurtain.sendMessage(CommonConstants.SWITCH_CLOSE);
        light.sendMessage(CommonConstants.SWITCH_CLOSE);
    }

    /**
     * 睡眠模式:拉窗帘-关电视-关灯-催眠音乐-5分钟后关闭音乐
     */
    private void sleepModule(Mediator mediator) {
        System.out.println("晚安，祝你有一个好梦哦");
        ColleagueWindowCurtain windowCurtain = (ColleagueWindowCurtain) colleagues.get(CommonConstants.SMART_CURTAIN);
        ColleagueTV tv = (ColleagueTV) colleagues.get(CommonConstants.SMART_TV);
        ColleagueLight light = (ColleagueLight) colleagues.get(CommonConstants.SMART_LIGHT);
        ColleagueAudioMachine audioMachine = (ColleagueAudioMachine) colleagues.get(CommonConstants.SMART_AUDIO);
        windowCurtain.sendMessage(CommonConstants.SWITCH_CLOSE);
        tv.sendMessage(CommonConstants.SWITCH_CLOSE);
        light.sendMessage(CommonConstants.SWITCH_CLOSE);
        audioMachine.sendMessage(CommonConstants.SWITCH_ON);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        audioMachine.sendMessage(CommonConstants.SWITCH_OFF);
    }
}
