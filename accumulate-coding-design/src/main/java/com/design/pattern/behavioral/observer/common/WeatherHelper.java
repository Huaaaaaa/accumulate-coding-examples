package com.design.pattern.behavioral.observer.common;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/18  15:42
 * @Description: 天气助手
 */
public class WeatherHelper {

    /**
     * 气温
     */
    private float temperature;

    /**
     * 气压
     */
    private float pressure;

    /**
     * 湿度
     */
    private float humidity;

    /**
     * 更新天气
     * @param temperature
     * @param pressure
     * @param humidity
     */
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    /**
     * 展示最新天气
     */
    private void display() {
        System.out.println("***Now temperature: " + temperature + "***");
        System.out.println("***Now pressure: " + pressure + "***");
        System.out.println("***Now humidity: " + humidity + "***");
    }


}
