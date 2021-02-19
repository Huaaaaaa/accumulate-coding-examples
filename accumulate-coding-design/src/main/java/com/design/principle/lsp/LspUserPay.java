package com.design.principle.lsp;

import com.design.enums.UserTypeEnum;

import java.math.BigDecimal;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo:
 * Time 9:46
 */
public class LspUserPay {

    public static void main(String[] args) {
        LspUserPay lup = new LspUserPay();
        System.out.println(lup.payOrder("1", BigDecimal.valueOf(7)));
    }


    /**
     * 完成订单支付
     *
     * @param userType 用户类型：noFree-要支付；free-免支付
     * @param payMoney
     * @return
     */
    public String payOrder(String userType, BigDecimal payMoney) {
        LspOrderFreePay lofp = new LspOrderFreePay();
        return UserTypeEnum.getValueByCode(Integer.parseInt(userType)) + "开始支付：\r\n" + lofp.freePay(userType, payMoney);
    }
}
