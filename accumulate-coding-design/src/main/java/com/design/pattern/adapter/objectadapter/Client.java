package com.design.pattern.adapter.objectadapter;

import org.springframework.security.core.parameters.P;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/13
 * Todo:
 * Time 15:48
 */
public class Client {

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new SrcVoltage(220)));
    }
}
