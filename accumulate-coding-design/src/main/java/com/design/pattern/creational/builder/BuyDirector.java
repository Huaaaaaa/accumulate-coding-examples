package com.design.pattern.creational.builder;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo: 定义一个指挥者，即对外提供接口的服务封装购买接口
 * Time 23:11
 */
public class BuyDirector {

    private ConcreteBuyBuilder concreteBuyBuilder;

    public Order buy(String userName, String productId) {
        concreteBuyBuilder = new ConcreteBuyBuilder();
        concreteBuyBuilder.createOrder(userName, productId);
        concreteBuyBuilder.getPrice();
        concreteBuyBuilder.payOrder();
        concreteBuyBuilder.delivery();
        return concreteBuyBuilder.buy();
    }
}
