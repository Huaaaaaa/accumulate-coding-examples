package com.accumulate.coding.design.principle.srp;

import lombok.var;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo:
 * Time 23:53
 */
public class SrpPayTest {

    public static void main(String[] args) {
        SrpIPay srpIPay = new SrpOrderPay();
        System.out.println(srpIPay.weiXinPay());
        System.out.println(srpIPay.couponPay());
        System.out.println(srpIPay.zhiFuBaoPay());
    }
}
