package com.accumulate.coding.design.principle.ispagainst;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: 需求：管理员通过依赖管理员服务进行获取、修改、删除订单
 *       问题：当管理员依赖订单接口时，还能进行创建和支付订单操作，违背接口隔离原则
 * Time 21:26
 */
public class Admin {

    public void getOrder(OrderInterface oi) {
        oi.getOrder();
    }

    public void updateOrder(OrderInterface oi) {
        oi.updateOrder();
    }

    public void deleteOrder(OrderInterface oi) {
        oi.deleteOrder();
    }
}
