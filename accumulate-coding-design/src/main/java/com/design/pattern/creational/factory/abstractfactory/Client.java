package com.design.pattern.creational.factory.abstractfactory;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo:
 * Time 18:37
 */
public class Client {
    public static void main(String[] args) {
        new HuaBeiResourceFactory().dbService().creatInstance();
        new HuaBeiResourceFactory().vmService().creatInstance();
        new HuaDongResourceFactory().dbService().creatInstance();
        new HuaDongResourceFactory().vmService().creatInstance();
    }
}
