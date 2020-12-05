package com.accumulate.coding.design.principle.isp;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: 管理员接口：专门供管理员修改与删除订单
 * Time 21:08
 */
public interface AdminOrderInterface {

    void updateOrder();

    void deleteOrder();
}
