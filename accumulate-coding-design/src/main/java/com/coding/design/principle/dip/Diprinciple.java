package com.coding.design.principle.dip;

/**
 * Author: Huaaaaaa
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
