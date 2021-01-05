package com.design.pattern.creational.factory.simplefactory;

import java.util.UUID;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo:  提供数据库服务
 * Time 12:02
 */
public class DataBase extends CloudProduct {

    @Override
    public String service() {
        String pId = UUID.randomUUID().toString();
        return "云数据库创建完成！" + pId;
    }
}
