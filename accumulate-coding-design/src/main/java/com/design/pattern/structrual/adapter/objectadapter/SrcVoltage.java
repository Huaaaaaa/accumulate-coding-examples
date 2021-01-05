package com.design.pattern.structrual.adapter.objectadapter;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/13
 * Todo: 源充电器电压为220v
 * Time 15:34
 */
public class SrcVoltage {

    private int voltage;

    public SrcVoltage(int voltage){
        this.voltage = voltage;
    }

    public int voltage() {
        System.out.println("现有接口的电压为" + voltage + "v");
        return voltage;
    }
}
