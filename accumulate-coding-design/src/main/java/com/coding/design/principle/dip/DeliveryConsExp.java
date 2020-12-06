package com.coding.design.principle.dip;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: 依赖传递之构造函数传递
 * Time 22:22
 */
public class DeliveryConsExp {

    public static void main(String[] args) {
        ConOrderPay conOrderPay = new ConOrderPay(new WeiXinPay(), new VoucherPay());
        System.out.println(conOrderPay.cashierPay());
        System.out.println(conOrderPay.couponPay());
    }


}

interface DeliveryConIPay {

    String cashierPay();

    String couponPay();
}

class ConOrderPay implements DeliveryConIPay {

    private static final String PREFIX = "通过构造函数传递依赖：";

    /**
     * 通过构造函数传递现金支付依赖
     */
    private ICashierPay iCashierPay;

    /**
     * 通过构造桉树传递券支付依赖
     */
    private ICouponPay iCouponPay;

    public ConOrderPay(ICashierPay iCashierPay, ICouponPay iCouponPay) {
        this.iCashierPay = iCashierPay;
        this.iCouponPay = iCouponPay;
    }

    @Override
    public String cashierPay() {
        return ConOrderPay.PREFIX + iCashierPay.cashierPay();
    }

    @Override
    public String couponPay() {
        return ConOrderPay.PREFIX + iCouponPay.couponPay();
    }
}


