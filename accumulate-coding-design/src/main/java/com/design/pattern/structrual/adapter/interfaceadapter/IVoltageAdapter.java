package com.design.pattern.structrual.adapter.interfaceadapter;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/13
 * Todo: 定义一个电压适配接口，适配不同的电压
 * Time 15:55
 */
public interface IVoltageAdapter {

    int  voltage5v();

    int  voltage50v();

    int  voltage200v();

    int  voltage220v();
}
