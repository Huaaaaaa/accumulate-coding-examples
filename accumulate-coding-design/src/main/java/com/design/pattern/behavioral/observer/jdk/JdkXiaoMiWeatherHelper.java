package com.design.pattern.behavioral.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/19  18:40
 * @Description: 假设我是需要接入的观察者，就需要实现jdk提供的Observer这个接口
 */
public class JdkXiaoMiWeatherHelper implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        JdkWeatherData jdkWeatherData = (JdkWeatherData) arg;
        display(jdkWeatherData);
    }

    /**
     * 第三方平台自己实现数据显示
     */
    private void display(JdkWeatherData jdkWeatherData) {
        System.out.println("=====欢迎使用华为天气助手，当前天气情况如下=====");
        System.out.println("当前温度为：" + jdkWeatherData.getTemperature());
        System.out.println("当前湿度为：" + jdkWeatherData.getHumidity());
        System.out.println("当前气压为：" + jdkWeatherData.getPressure());
    }
}
