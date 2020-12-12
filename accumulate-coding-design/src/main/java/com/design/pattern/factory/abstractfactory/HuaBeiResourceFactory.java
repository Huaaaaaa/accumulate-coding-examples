package com.design.pattern.factory.abstractfactory;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo: 定义一个华北资源工厂，提供华北地区的云产品服务
 * Time 18:02
 */
public class HuaBeiResourceFactory extends AbstractFactory {

    @Override
    AbstractResource vmService() {
        return new HuaBeiVmResource();
    }

    @Override
    AbstractResource dbService() {
        return new HuaBeiDbResource();
    }
}
