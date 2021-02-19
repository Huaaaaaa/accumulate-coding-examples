package com.design.pattern.behavioral.observer.common;

import lombok.Data;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/18  15:43
 * @Description: 天气类
 */
@Data
public class WeatherCenter {

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

    private WeatherHelper weatherHelper;

    public WeatherCenter(WeatherHelper weatherHelper) {
        this.weatherHelper = weatherHelper;
    }

    private void updateData() {
        weatherHelper.update(temperature, pressure, humidity);
    }


    /**
     * 气象中心更新数据时顺便更新第三方天气助手的天气信息
     * @param temperature
     * @param pressure
     * @param humidity
     */
    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        updateData();
    }


}
