package com.design.pattern.creational.factory.factorymethod;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo: 主机抽工厂类，提供创建主机服务
 * Time 14:07
 */
public class VmFactory extends AbstractFactory {


    @Override
    public Resource service() {
        return new Vm();
    }
}
