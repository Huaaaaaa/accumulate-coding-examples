package com.design.principle.lspagainst;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 定义一个支付类，实现现金支付
 * Time 8:18
 */
public class LspAgainstOrderPay {

    /**
     * 定义一个支付方法
     *
     * @param payFee
     * @return
     */
    public String payOrder(BigDecimal payFee) {
        String suffix = "---支付金额=" + payFee;
        if (payFee.compareTo(new BigDecimal(0)) == 0) {
            return "完成免支付" + suffix;
        } else if (payFee.compareTo(new BigDecimal(0)) > 0) {
            return "完成实际支付" + suffix;
        } else {
            return "支付金额不能大于0" + suffix;
        }
    }
}
