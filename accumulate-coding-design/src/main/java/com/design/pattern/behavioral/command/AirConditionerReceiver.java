package com.design.pattern.behavioral.command;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/9
 * Todo:  电视命令接受者
 * Time 18:56
 */
public class AirConditionerReceiver {

    public void openAir(){
        System.out.println("空调打开");
    }
    public void closeAir(){
        System.out.println("空调关闭");
    }
    public void heatUp(){
        System.out.println("增加温度");
    }
    public void collDown(){
        System.out.println("降低温度");
    }
}
