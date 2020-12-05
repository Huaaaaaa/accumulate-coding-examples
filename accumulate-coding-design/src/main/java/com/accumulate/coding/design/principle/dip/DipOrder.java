package com.accumulate.coding.design.principle.dip;

/**
 * Author: huayingcao2
 * Date:  2020/12/5
 * Todo:  订单类中实现订单支付方法
 * Time 22:12
 */
public class DipOrder {

    /**
     * 传递一个接口，就能支持多种支付方式
     *
     * @param iPay
     * @return
     */
    public String payOrder(IPay iPay) {
        return iPay.pay();
    }
}
