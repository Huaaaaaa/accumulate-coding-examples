package com.accumulate.coding.design.principle.lsp;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 定义一个基类
 * Time 9:19
 */
public class LspOrderBasePay {

    /**
     * 定义一个支付方法
     *
     * @param payFee
     * @return
     */
    public String payOrder(BigDecimal payFee) {
        String suffix = "---支付金额" + payFee;
        if (payFee.compareTo(new BigDecimal(0)) > 0) {
            return "完成支付" + suffix;
        } else if (payFee.compareTo(BigDecimal.valueOf(0)) == 0) {
            return "完成免支付" + suffix;
        } else {
            return "不满足支付条件" + suffix;
        }
    }
}
