package com.accumulate.coding.design.principle.ispagainst;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: 管理员服务实现订单接口实现管理员需求
 * Time 21:24
 */
public class AdminOrderService implements OrderInterface{

    @Override
    public void getOrder() {
        System.out.println("管理员服务获取订单");
    }

    @Override
    public void createOrder() {
        System.out.println("管理员服务创建订单");
    }

    @Override
    public void deleteOrder() {
        System.out.println("管理员服务删除订单");
    }

    @Override
    public void updateOrder() {
        System.out.println("管理员服务修改订单列表");
    }

    @Override
    public void payOrder() {
        System.out.println("管理员服务支付订单");
    }
}
