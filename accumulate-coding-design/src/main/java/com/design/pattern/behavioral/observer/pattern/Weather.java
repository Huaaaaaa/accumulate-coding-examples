package com.design.pattern.behavioral.observer.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/19  16:17
 * @Description: 抽象主题
 */
public interface Weather {

    /**
     * 注册观察者
     * @param weatherHelper
     */
    void register(WeatherHelper weatherHelper);


    /**
     * 删除观察者
     * @param weatherHelper
     */
    void remove(WeatherHelper weatherHelper);


    /**
     * 更新数据
     */
    void notifyObservers();
}
