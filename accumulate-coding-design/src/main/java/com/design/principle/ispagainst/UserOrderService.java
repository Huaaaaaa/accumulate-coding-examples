package com.design.principle.ispagainst;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: 用户服务实现订单接口完成用户需求
 * Time 21:24
 */
public class UserOrderService implements OrderInterface{

    @Override
    public void getOrder() {
        System.out.println("用户服务获取订单");
    }

    @Override
    public void createOrder() {
        System.out.println("用户服务创建订单");
    }

    @Override
    public void deleteOrder() {
        System.out.println("用户服务删除订单");
    }

    @Override
    public void updateOrder() {
        System.out.println("用户服务修改订单列表");
    }

    @Override
    public void payOrder() {
        System.out.println("用户服务支付订单");
    }
}
