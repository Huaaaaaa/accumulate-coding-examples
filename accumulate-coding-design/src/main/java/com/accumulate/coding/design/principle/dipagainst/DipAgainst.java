package com.accumulate.coding.design.principle.dipagainst;

/**
 * Author: huayingcao2
 * Date:  2020/12/5
 * Todo: An example to against DIP(Dependency Inversion Principle)
 * Time 22:05
 */
public class DipAgainst {

    public static void main(String[] args) {
        Order order = new Order();
        WeiXinPay wxp = new WeiXinPay();
        System.out.println(order.payOrder(wxp));
    }


}
