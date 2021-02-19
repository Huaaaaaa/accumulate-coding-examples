package com.design.pattern.structrual.adapter.interfaceadapter;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/13
 * Todo: 定义一个手机电压适配器
 * Time 15:59
 */
public class PhoneVoltageAdapter extends AbstractVoltageAdapter {

    private SrcVoltage srcVoltage;

    public PhoneVoltageAdapter(SrcVoltage srcVoltage) {
        this.srcVoltage = srcVoltage;
    }

    /**
     * 重写抽象类中的一个方法
     */
    @Override
    public int voltage5v() {
        int src = 0;
        if (srcVoltage != null) {
            if (srcVoltage.voltage() != 5) {
                src = srcVoltage.voltage() / 44;
            }
        }
        return src;
    }
}
