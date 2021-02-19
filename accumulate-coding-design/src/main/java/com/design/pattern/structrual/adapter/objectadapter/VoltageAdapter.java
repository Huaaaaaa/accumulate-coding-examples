package com.design.pattern.structrual.adapter.objectadapter;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/13
 * Todo:  定义一个电压适配器，将220v电压转化成5v目标电压
 * Time 15:31
 */
public class VoltageAdapter implements IVoltage {

    /**
     * 将继承关系改为聚合关系
     */
    private SrcVoltage srcVoltage;

    public VoltageAdapter(SrcVoltage srcVoltage) {
        this.srcVoltage = srcVoltage;
    }

    @Override
    public int transferVoltage() {
        int des = 0;
        if (srcVoltage != null && srcVoltage.voltage() == 220) {
            des = srcVoltage.voltage() / 44;
        }
        if (des != 5) {
            System.out.println("适配的电压为" + des + "v");
        } else {
            System.out.println("适配的电压是" + des + "v");
        }
        return des;
    }
}
