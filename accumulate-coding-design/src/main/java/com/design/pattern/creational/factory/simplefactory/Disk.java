package com.design.pattern.creational.factory.simplefactory;

import java.util.UUID;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo: 提供硬盘服务
 * Time 12:00
 */
public class Disk extends CloudProduct {

    @Override
    public String service() {
        String pId = UUID.randomUUID().toString();
        return "云硬盘创建完成！" + pId;
    }
}
