package com.design.pattern.behavioral.observer.jdk;

import javafx.beans.value.ObservableValueBase;

import java.util.Observable;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/19  18:45
 * @Description: 使用jdk自带的抽象对象
 */
public class JdkWeatherCenter extends Observable {

    private JdkWeatherData jdkWeatherData;

    public JdkWeatherData getJdkWeatherData() {
        return jdkWeatherData;
    }

    public void setJdkWeatherData(JdkWeatherData jdkWeatherData) {
        this.jdkWeatherData = jdkWeatherData;
    }

    /**
     * 实际对象实现更新数据
     * @param jdkWeatherData
     */
    public void updateData(JdkWeatherData jdkWeatherData){
        this.jdkWeatherData = jdkWeatherData;
        setChanged();
        notifyObservers(jdkWeatherData);
    }


}
