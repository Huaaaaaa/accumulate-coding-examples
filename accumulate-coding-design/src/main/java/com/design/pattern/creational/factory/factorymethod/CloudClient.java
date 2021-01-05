package com.design.pattern.creational.factory.factorymethod;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo: 客户购买云资源
 * Time 12:11
 */
public class CloudClient {

    public static void main(String[] args) {
        System.out.println("创建主机开始");
        Vm vm = (Vm) new VmFactory().service();
        System.out.println("vm=" + vm.hashCode());
        vm.creatInstance();
        System.out.println("创建主机结束");
        Db db = (Db) new DbFactory().service();
        System.out.println("db=" + db.hashCode());
        db.creatInstance();
        System.out.println("创建数据库开始");
        System.out.println("创建数据库结束");

    }
}
