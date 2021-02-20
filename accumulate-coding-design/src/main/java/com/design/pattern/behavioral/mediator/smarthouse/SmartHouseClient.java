package com.design.pattern.behavioral.mediator.smarthouse;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  13:18
 * @Description: 智能家庭客户端
 */
public class SmartHouseClient {

    public static void main(String[] args) throws InterruptedException {
        //中介者
        Mediator smartHouseMediator = new SmartHouseMediator();
        ColleagueWindowCurtain curtain = new ColleagueWindowCurtain(smartHouseMediator, CommonConstants.SMART_CURTAIN);
        ColleagueCoffeeMachine coffee = new ColleagueCoffeeMachine(smartHouseMediator, CommonConstants.SMART_COFFEE);
        ColleagueAudioMachine audio = new ColleagueAudioMachine(smartHouseMediator, CommonConstants.SMART_AUDIO);
        ColleagueLight light = new ColleagueLight(smartHouseMediator, CommonConstants.SMART_LIGHT);
        ColleagueTV tv = new ColleagueTV(smartHouseMediator, CommonConstants.SMART_TV);
        smartHouseMediator.send(CommonConstants.MODULE_GET_UP);
        Thread.sleep(3000);
        smartHouseMediator.send(CommonConstants.MODULE_CINEMA);
        Thread.sleep(3000);
        smartHouseMediator.send(CommonConstants.MODULE_SLEEP);


    }
}
