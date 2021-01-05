package com.design.pattern.structrual.proxy.cglib;


import com.accumulate.coding.common.utils.JsonUtil;
import com.design.pattern.structrual.facade.Goods;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo:
 * Time 22:15
 */
public class Client {

    public static void main(String[] args) {
        IOrder orderService = new OrderService();
        IOrder proxyInstance = (IOrder) new ProxyFactory(orderService).getProxyInstance();
        Goods goods = new Goods("123", "macbook pro", BigDecimal.valueOf(20000));
        String res = proxyInstance.createOrder(JsonUtil.toJsonString(goods));
        System.out.println("订单号=" + res);
    }
}
