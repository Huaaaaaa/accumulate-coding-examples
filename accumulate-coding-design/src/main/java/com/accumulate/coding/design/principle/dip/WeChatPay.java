package com.accumulate.coding.design.principle.dip;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: 微信支付实现类
 * Time 22:10
 */
public class WeChatPay implements IPay {

    @Override
    public String pay() {
        return "微信支付";
    }
}
