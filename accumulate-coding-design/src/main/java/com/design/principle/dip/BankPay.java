package com.design.principle.dip;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: 网银支付实现类
 * Time 22:11
 */
public class BankPay implements IPay {

    @Override
    public String pay() {
        return "网银支付";
    }
}
