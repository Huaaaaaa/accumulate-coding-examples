package com.design.principle.srpagainst;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo:
 * Time 23:48
 */
public class SrpAgainstPayTest {


    public static void main(String[] args) {
        /**
         * 问题在于：一个接口中有多种支付方式
         */
        SrpAgainstIPay srpIPay = new SrpAgainstOrderIPay();
        srpIPay.pay("微信支付");
        srpIPay.pay("支付宝支付");
        srpIPay.pay("代金券支付");
    }
}
