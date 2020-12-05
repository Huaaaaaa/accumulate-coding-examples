package com.accumulate.coding.design.principle.isp;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: 管理员服务实现通用接口与管理员接口，实现自己的方法
 * Time 21:10
 */
public class AdminOrderService implements CommonOrderInterface,AdminOrderInterface {

    @Override
    public void getOrder() {
        System.out.println("管理员获取订单");
    }

    @Override
    public void updateOrder() {
        System.out.println("管理修改订单");
    }

    @Override
    public void deleteOrder() {
        System.out.println("管理员删除订单");
    }
}
