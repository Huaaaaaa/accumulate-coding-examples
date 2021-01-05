package com.design.pattern.creational.factory.abstractfactory;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo: 定义一个华东资源工厂，提供华东地区的云产品服务
 * Time 18:03
 */
public class HuaDongResourceFactory extends AbstractFactory {

    @Override
    AbstractResource vmService() {
        return new HuaDongVmResource();
    }

    @Override
    AbstractResource dbService() {
        return new HuaDongDbResource();
    }
}
