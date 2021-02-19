package com.design.pattern.behavioral.observer.pattern;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/19  17:51
 * @Description: 华为手机天气助手
 */
public class HuaWeiWeatherHelper implements WeatherHelper {

    private WeatherData weatherData;

    /**
     * 实时更新天气数据
     *
     * @param weatherData
     */
    @Override
    public void updateData(WeatherData weatherData) {
        this.weatherData = weatherData;
        display();
    }

    /**
     * 第三方平台自己实现数据显示
     */
    private void display() {
        System.out.println("=====欢迎使用华为天气助手，当前天气情况如下=====");
        System.out.println("当前温度为：" + weatherData.getTemperature());
        System.out.println("当前湿度为：" + weatherData.getHumidity());
        System.out.println("当前气压为：" + weatherData.getPressure());
    }
}
