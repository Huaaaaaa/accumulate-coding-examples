package com.design.principle.dipagainst;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: 定义一个订单类，实现微信支付方法
 * Time 22:02
 */
public class Order {

    /**
     * 订单支付接口依赖微信支付类
     * 问题：如果增加一个其他的支付方式，需要增加依赖其他支付类的方法，不利于扩展
     * @param wxp
     * @return
     */
    public String payOrder(WeiXinPay wxp) {
        return wxp.pay();
    }
}
