package com.design.principle.isp;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: 用户服务实现通用接口与用户接口，实现自己的方法
 * Time 21:09
 */
public class UserOrderService implements CommonOrderInterface, UserOrderInterface {

    @Override
    public void getOrder() {
        System.out.println("用户获取订单");
    }

    @Override
    public void createOrder() {
        System.out.println("用户创建订单");
    }

    @Override
    public void payOrder() {
        System.out.println("用户支付订单");
    }
}
