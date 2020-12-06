package com.accumulate.coding.design.principle.lsp;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo:
 * Time 9:26
 */
public class LspOrderPay extends LspOrderBasePay {

    /**
     * 定义一个非免支付方法
     *
     * @param payFee
     * @return
     */
    public String noFreeOrder(BigDecimal payFee) {
        if (payFee.compareTo(new BigDecimal(0)) > 0) {
            return "完成支付";
        } else {
            return "不满足支付条件";
        }
    }

    /**
     * 支付之前增加支付金额是否为空的判断
     *
     * @param payFee
     * @return
     */
    public String payOrder(BigDecimal payFee) {
        if (payFee != null) {
            return super.payOrder(payFee);
        } else {
            return "支付金额不能为空";
        }

    }

}
