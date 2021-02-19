package com.design.principle.srp;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo:
 * Time 23:52
 */
public class SrpOrderPay implements SrpIPay {

    @Override
    public String weiXinPay() {
        return "微信支付";
    }

    @Override
    public String zhiFuBaoPay() {
        return "支付宝支付";
    }

    @Override
    public String couponPay() {
        return "代金券支付";
    }
}
