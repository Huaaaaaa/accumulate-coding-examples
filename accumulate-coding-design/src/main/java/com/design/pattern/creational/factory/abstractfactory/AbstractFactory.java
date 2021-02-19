package com.design.pattern.creational.factory.abstractfactory;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo: 定义一个抽象工厂，提供主机服务和数据库服务
 * Time 14:57
 */
public abstract class AbstractFactory {

    /**
     * 主机服务
     * @return
     */
    abstract AbstractResource vmService();

    /**
     * 数据库服务
     * @return
     */
    abstract AbstractResource dbService();
}
