package com.design.pattern.factory.factorymethod;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo: 数据库工厂类，提供数据库服务
 * Time 14:42
 */
public class DbFactory extends AbstractFactory {


    @Override
    public Resource service() {
        return new Db();
    }
}
