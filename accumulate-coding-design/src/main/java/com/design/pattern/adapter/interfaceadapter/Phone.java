package com.design.pattern.adapter.interfaceadapter;

import com.design.pattern.adapter.objectadapter.IVoltage;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/13
 * Todo:
 * Time 16:09
 */
public class Phone {

    public void charging(IVoltageAdapter iVoltageAdapter) {
        if (iVoltageAdapter.voltage5v() == 5) {
            System.out.println("手机正在充电......");
        } else {
            System.out.println("充电器不适配，请更换！！！");
        }
    }
}
