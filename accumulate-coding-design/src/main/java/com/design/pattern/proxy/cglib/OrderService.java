package com.design.pattern.proxy.cglib;

import com.accumulate.coding.common.utils.RandomUtil;

import java.util.Random;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo:
 * Time 21:59
 */
public class OrderService implements IOrder {

    @Override
    public String createOrder(String params) {
        System.out.println("创建订单参数=" + params);
        return RandomUtil.getUUID();
    }
}
