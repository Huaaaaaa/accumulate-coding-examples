package com.design.pattern.creational.factory.simplefactory;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo: 一个云工厂，生产云产品
 * Time 12:03
 */
public class CloudFactory {

    /**
     * 静态方法根据传进来的云服务类型参数提供不同的云服务
     * 工厂静态方法提供实例化不同产品的功能
     *
     * @param csType
     */
    public static CloudProduct cloudService(String csType) {
        if ("vm".equals(csType)) {
            return new Vm();
        } else if ("disk".equals(csType)) {
            return new Disk();
        } else if ("db".equals(csType)) {
            return new DataBase();
        } else {
            return null;
        }
    }
}
