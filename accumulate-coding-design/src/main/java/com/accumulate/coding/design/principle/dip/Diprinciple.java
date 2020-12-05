package com.accumulate.coding.design.principle.dip;

import com.accumulate.coding.design.principle.dipagainst.WeiXinPay;

/**
 * Author: huayingcao2
 * Date:  2020/12/5
 * Todo:
 * Time 22:14
 */
public class Diprinciple {

    public static void main(String[] args) {

        DipOrder dipOrder = new DipOrder();
        WeChatPay weChatPay = new WeChatPay();
        System.out.println(dipOrder.payOrder(weChatPay));
        BankPay bankPay = new BankPay();
        System.out.println(dipOrder.payOrder(bankPay));
        JdPay jdPay = new JdPay();
        System.out.println(dipOrder.payOrder(jdPay));

    }
}
