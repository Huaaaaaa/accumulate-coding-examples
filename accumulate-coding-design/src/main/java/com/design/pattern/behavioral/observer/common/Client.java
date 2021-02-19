package com.design.pattern.behavioral.observer.common;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/19  15:46
 * @Description: 气象中心更新天气时实时推送更新数据到第三方天气助手平台
 */
public class Client {

    public static void main(String[] args) {
        WeatherHelper weatherHelper = new WeatherHelper();
        /**
         * 缺点：就是违背OCP原则，每增加一个第三方平台，气象中心就要对接一次
         */
        WeatherCenter weatherCenter = new WeatherCenter(weatherHelper);
        System.out.println("早上八点的实时天气");
        weatherCenter.setData(8,100,40);
        System.out.println("早上十点的实时天气");
        weatherCenter.setData(15,120,40);
    }
}
