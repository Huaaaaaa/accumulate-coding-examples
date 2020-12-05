package com.accumulate.coding.design.principle.dip;

import java.util.Set;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: 依赖传递之set方法传递
 * Time 22:22
 */
public class DeliverySetExp {

    public static void main(String[] args) {
        SetOrderPay setOrderPay = new SetOrderPay();
        setOrderPay.setiCashierPay(new WeiXinPay());
        setOrderPay.setiCouponPay(new VoucherPay());
        System.out.println(setOrderPay.cashierPay());
        System.out.println(setOrderPay.couponPay());
    }

}

interface DeliverySetIPay {

    String cashierPay();

    String couponPay();
}

class SetOrderPay implements DeliverySetIPay {

    private static final String PREFIX = "通过set方法传递依赖：";

    /**
     * 通过set传递现金支付依赖
     */
    private ICashierPay iCashierPay;

    /**
     * 通过set方法传递券支付依赖
     */
    private ICouponPay iCouponPay;

    public void setiCashierPay(ICashierPay iCashierPay) {
        this.iCashierPay = iCashierPay;
    }

    public void setiCouponPay(ICouponPay iCouponPay) {
        this.iCouponPay = iCouponPay;
    }

    @Override
    public String cashierPay() {
        return SetOrderPay.PREFIX + iCashierPay.cashierPay();
    }

    @Override
    public String couponPay() {
        return SetOrderPay.PREFIX + iCouponPay.couponPay();
    }
}