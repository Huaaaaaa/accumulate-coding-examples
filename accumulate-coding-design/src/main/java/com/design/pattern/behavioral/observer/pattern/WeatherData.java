package com.design.pattern.behavioral.observer.pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/19  16:19
 * @Description: 天气数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData implements Serializable {
    private static final long serialVersionUID = -7976644829007526905L;
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
}
