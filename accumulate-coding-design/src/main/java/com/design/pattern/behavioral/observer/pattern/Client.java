package com.design.pattern.behavioral.observer.pattern;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/19  17:55
 * @Description: 模拟气象中心更新数据时，实时推送数据到第三方
 */
public class Client {

    public static void main(String[] args) {
        //要接入的第三方平台
        WeatherHelper huaWeiWeatherHelper = new HuaWeiWeatherHelper();
        //如果有其他第三方平台来接入，只要第三方平台实现观察者并在气象中心完成注册即可
        WeatherHelper xiaoMiWeatherHelper = new XiaoMiWeatherHelper();
        WeatherCenter weatherCenter = new WeatherCenter();
        //华为天气助手平台完成注册
        weatherCenter.register(huaWeiWeatherHelper);
        //小米天气助手平台完成注册
        weatherCenter.register(xiaoMiWeatherHelper);
        WeatherData am8 = new WeatherData(8, 100, 30);
        //气象中心实时更新数据
        System.out.println("您好，现在是北京时间早上八点");
        weatherCenter.setWeatherData(am8);
        System.out.println("您好，现在是北京时间早上十一点");
        WeatherData am11 = new WeatherData(11, 110, 40);
        weatherCenter.setWeatherData(am11);
    }
}
