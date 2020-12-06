package com.design.principle.isp;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: 需求：管理员通过依赖管理员服务进行获取、修改、删除订单
 * Time 21:13
 */
public class Admin {

    void getOrder(CommonOrderInterface coi) {
        coi.getOrder();
    }

    void updateOrder(AdminOrderInterface aoi) {
        aoi.updateOrder();
    }

    void deleteOrder(AdminOrderInterface aoi) {
        aoi.deleteOrder();
    }
}
