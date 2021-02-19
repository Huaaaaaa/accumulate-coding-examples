package com.design.pattern.behavioral.observer.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/19  16:25
 * @Description: 气象中心：实际观察者
 */
public class WeatherCenter implements Weather {

    private WeatherData weatherData;

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
        notifyObservers();
    }

    private List<WeatherHelper> weatherHelpers = new ArrayList<>();

    /**
     * 注册观察者
     *
     * @param weatherHelper
     */
    @Override
    public void register(WeatherHelper weatherHelper) {
        weatherHelpers.add(weatherHelper);
    }

    /**
     * 移除观察者
     *
     * @param weatherHelper
     */
    @Override
    public void remove(WeatherHelper weatherHelper) {
        if (weatherHelpers.contains(weatherHelper)) {
            weatherHelpers.remove(weatherHelper);
        }
    }

    /**
     * 更新数据，通知观察者
     */
    @Override
    public void notifyObservers() {
        weatherHelpers.forEach(weatherHelper -> weatherHelper.updateData(weatherData));
    }
}
