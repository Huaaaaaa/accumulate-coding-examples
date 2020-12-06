package com.design.principle.isp;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: 需求：用户通过依赖用户服务进行创建、获取、支付订单
 * Time 21:12
 */
public class User {

    void getOrder(CommonOrderInterface coi) {

        coi.getOrder();
    }

    void createOrder(UserOrderInterface uoi) {
        uoi.createOrder();
    }

    void payOrder(UserOrderInterface uoi) {
        uoi.payOrder();
    }

}
