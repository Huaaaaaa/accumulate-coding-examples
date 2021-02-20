package com.design.pattern.behavioral.mediator.fangtx;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  10:23
 * @Description: 交易平台
 */
public class OrderClient {

    public static void main(String[] args) {
        FangTianXiaMedium fangTianXiaMedium = new FangTianXiaMedium();
        Customer buyerCustomer = new BuyerCustomer("张三（买方）");
        Customer sellerCustomer = new SellerCustomer("李四（卖方）");
        fangTianXiaMedium.register(buyerCustomer);
        fangTianXiaMedium.register(sellerCustomer);
    }
}
