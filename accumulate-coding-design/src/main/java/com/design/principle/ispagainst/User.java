package com.design.principle.ispagainst;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: 需求：用户通过依赖用户服务进行创建、获取、支付订单
 *      问题：当用户依赖订单接口时，还能进行订单的修改和删除操作，违背接口隔离原则
 * Time 21:25
 */
public class User {

    public void createOrder(OrderInterface oi) {
        oi.createOrder();
    }

    public void getOrder(OrderInterface oi) {
        oi.getOrder();
    }

    public void payOrder(OrderInterface oi) {
        oi.payOrder();
    }
}
