package com.design.pattern.adapter.interfaceadapter;

import com.design.pattern.adapter.objectadapter.VoltageAdapter;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/13
 * Todo:
 * Time 15:48
 */
public class Client {

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new PhoneVoltageAdapter(new SrcVoltage(200)));
    }
}
