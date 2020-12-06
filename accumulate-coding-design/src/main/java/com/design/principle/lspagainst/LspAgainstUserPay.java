package com.design.principle.lspagainst;

import com.design.enums.UserTypeEnum;
import lombok.var;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 定义一个用户支付类，区分要支付和免支付
 * Time 8:25
 */
public class LspAgainstUserPay {

    public static void main(String[] args) {
        var lspAgainstUserPay = new LspAgainstUserPay();
        System.out.println(lspAgainstUserPay.payOrder("1", BigDecimal.valueOf(9)));
    }


    /**
     * 完成订单支付
     *
     * @param userType 用户类型：noFree-要支付；free-免支付
     * @param payMoney
     * @return
     */
    public String payOrder(String userType, BigDecimal payMoney) {
        LspAgainstOrderFreePay lspAgainstOrderFreePay = new LspAgainstOrderFreePay();
        //在使用基类的地方不能用子类代替，因为子类重写了父类的方法，导致父类语义变更
        return UserTypeEnum.getValueByCode(Integer.parseInt(userType)) + "开始支付：\r\n" + lspAgainstOrderFreePay.payOrder(payMoney);
    }

}
