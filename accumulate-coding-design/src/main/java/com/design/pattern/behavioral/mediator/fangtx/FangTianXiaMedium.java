package com.design.pattern.behavioral.mediator.fangtx;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  10:11
 * @Description: 具体中介对象：房天下中介
 */
public class FangTianXiaMedium implements Medium {

    private List<Customer> customers = new ArrayList<>();

    /**
     * 提供同事类注册
     *
     * @param customer
     */
    @Override
    public void register(Customer customer) {
        if (!customers.contains(customer)) {
            customers.add(customer);
            customer.setMedium(this);
        }
    }

    /**
     * 转发买卖双方的消息
     *
     * @param from
     * @param message
     */
    @Override
    public void relay(String from, String message) {
        Preconditions.checkNotNull(customers, "客户没有注册，请先完成平台注册");
        for (Customer customer : customers) {
            if (!from.equals(customer.getName())) {
                customer.receive(from, message);
            }
        }
    }
}
