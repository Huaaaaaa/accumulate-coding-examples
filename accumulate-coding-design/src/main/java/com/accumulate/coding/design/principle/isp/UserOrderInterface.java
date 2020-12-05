package com.accumulate.coding.design.principle.isp;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: 用户接口：专门供用户使用的接口，实现订单的创建与支付
 * Time 21:08
 */
public interface UserOrderInterface {

    void createOrder();

    void payOrder();
}
