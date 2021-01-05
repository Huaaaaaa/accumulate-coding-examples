package com.design.pattern.creational.factory.simplefactory;

import java.util.UUID;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo: 提供主机服务
 * Time 11:59
 */
public class Vm extends CloudProduct {

    @Override
    public String service() {
        String pId = UUID.randomUUID().toString();
        return "云主机创建完成！" + pId;
    }
}
