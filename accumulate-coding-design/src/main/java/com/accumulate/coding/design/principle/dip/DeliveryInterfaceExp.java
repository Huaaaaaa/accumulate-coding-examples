package com.accumulate.coding.design.principle.dip;

import java.net.InterfaceAddress;

/**
 * Author: huayingcao2
 * Date:  2020/12/5
 * Todo: 依赖传递之接口传递
 * Time 22:22
 */
public class DeliveryInterfaceExp {

    public static void main(String[] args) {
        InterfaceOrderPay interfaceOrderPay = new InterfaceOrderPay();
        System.out.println(interfaceOrderPay.cashierPay(new WeiXinPay()));
        System.out.println(interfaceOrderPay.couponPay(new VoucherPay()));
    }


}

/**
 * 支付接口:通过接口传递具体的支付方式
 */
interface DeliveryInterfaceIPay {

    String cashierPay(ICashierPay iCashierPay);

    String couponPay(ICouponPay iCouponPay);
}

/**
 * 订单支付
 */
class InterfaceOrderPay implements DeliveryInterfaceIPay {

    private static final String PREFIX = "通过接口传递依赖：";


    @Override
    public String cashierPay(ICashierPay iCashierPay) {
        return InterfaceOrderPay.PREFIX + iCashierPay.cashierPay();
    }

    @Override
    public String couponPay(ICouponPay iCouponPay) {
        return InterfaceOrderPay.PREFIX + iCouponPay.couponPay();
    }
}

/**
 * 现金支付
 */
interface ICashierPay {
    String cashierPay();
}

/**
 * 券支付
 */
interface ICouponPay {
    String couponPay();
}


/**
 * 现金支付--微信支付方式
 */
class WeiXinPay implements ICashierPay {
    @Override
    public String cashierPay() {
        return "现金支付---微信方式支付";
    }
}

/**
 * 券支付---优惠券支付方式
 */
class VoucherPay implements ICouponPay {
    @Override
    public String couponPay() {
        return "券支付---优惠券支付";
    }
}