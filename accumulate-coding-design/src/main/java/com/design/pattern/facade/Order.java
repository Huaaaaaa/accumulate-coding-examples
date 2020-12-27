package com.design.pattern.facade;

import com.accumulate.coding.common.utils.RandomUtil;
import com.google.common.collect.Ordering;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo: 子系统1：订单类
 * Time 8:39
 */
public class Order {

    /**
     * 创建订单
     * @param user
     * @param goods
     * @param quantity
     * @return
     */
    public OrderDetail createOrder(String user, Goods goods, int quantity) {
        String orderNumber = RandomUtil.getUUID();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderNumber(orderNumber);
        orderDetail.setGoods(goods);
        orderDetail.setQuantity(quantity);
        orderDetail.setUserName(user);
        return orderDetail;
    }
}
