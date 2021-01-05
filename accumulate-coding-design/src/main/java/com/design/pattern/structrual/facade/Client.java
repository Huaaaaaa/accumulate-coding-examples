package com.design.pattern.structrual.facade;

import com.accumulate.coding.common.utils.JsonUtil;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo: 客户类，下单购买
 * Time 9:35
 */
public class Client {

    /**
     * 客户端只需传入自己要购买的商品信息并调用购买接口，无需知道其中的查价、查优惠信息等流程
     * @param args
     */
    public static void main(String[] args) {
        Goods goods = new Goods("1", "牙刷", BigDecimal.valueOf(30));
        Buy buy = new Buy();
        try {
            OrderDetail orderDetail = buy.buy("user1", goods, 2);
            System.out.println("orderDetail=" + JsonUtil.toJsonString(orderDetail));
            System.out.println(orderDetail.getUserName() + "买了" + orderDetail.getQuantity() + "个" + orderDetail.getGoods().getName() + "总价" + orderDetail.getTotalPrice() + "元，共花了" + orderDetail.getActualPrice() + "元，优惠了" + orderDetail.getCouponPrice() + "元");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
