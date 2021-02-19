package com.design.principle.dip;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: JD支付实现类
 * Time 22:12
 */
public class JdPay implements IPay {

    @Override
    public String pay() {
        return "京东支付";
    }
}
