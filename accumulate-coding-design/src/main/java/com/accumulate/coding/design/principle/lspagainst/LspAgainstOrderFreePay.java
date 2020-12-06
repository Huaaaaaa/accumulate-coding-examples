package com.accumulate.coding.design.principle.lspagainst;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 定义一个免支付类继承支付类，并重写支付方法
 * Time 8:21
 */
public class LspAgainstOrderFreePay extends LspAgainstOrderPay {

    /**
     * 重写父类的支付方法，实现免支付
     * 问题：因为重写了父类方法，导致无法实现金额大于0的订单支付
     *
     * @param payFee
     * @return
     */
    public String payOrder(BigDecimal payFee) {
        if (payFee.compareTo(new BigDecimal(0)) == 0) {
            return "完成免支付";
        } else {
            return "支付金额不能大于0";
        }
    }
}
