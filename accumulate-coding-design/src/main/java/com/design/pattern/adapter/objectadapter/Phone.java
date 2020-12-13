package com.design.pattern.adapter.objectadapter;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/13
 * Todo: 定义一个手机，用适配器进行充电
 * Time 15:43
 */
public class Phone {

    public void charging(IVoltage iVoltage) {
        if(iVoltage.transferVoltage()==5){
            System.out.println("手机正在充电......");
        }else {
            System.out.println("充电器不适配，请更换！！！");
        }
    }
}
