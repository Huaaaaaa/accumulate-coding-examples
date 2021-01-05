package com.design.pattern.structrual.adapter.interfaceadapter;

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
