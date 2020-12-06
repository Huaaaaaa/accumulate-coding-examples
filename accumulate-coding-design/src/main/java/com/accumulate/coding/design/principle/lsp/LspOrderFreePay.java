package com.accumulate.coding.design.principle.lsp;

import com.accumulate.coding.design.enums.UserTypeEnum;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 定义一个免支付类
 * Time 9:20
 */
public class LspOrderFreePay extends LspOrderBasePay {

    /**
     * 通过两个实现了基类的子类聚合的方式，实现免支付与支付方法
     */
    private LspOrderPay lspOrderPay = new LspOrderPay();

    /**
     * 定义一个免支付方法，用来实现免支付
     *
     * @param payMoney
     * @return
     */
    public String freePay(String userType, BigDecimal payMoney) {
        String useType = UserTypeEnum.getValueByCode(Integer.parseInt(userType));
        if (userType.equals("2")) {
            return useType + ":完成免支付，免费金额=" + payMoney;
        } else {
            //实现了在用到基类的地方可以用子类代替
            return useType + ":" + lspOrderPay.payOrder(payMoney);
        }
    }


}
