package com.coding.design.principle.isp;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: An example to finish ISP(Interface Segregation Principle)
 * Time 21:14
 */
public class InterfaceSegregationPrinciple {

    public static void main(String[] args) {

        System.out.println("An example to finish ISP");
        UserOrderService uos = new UserOrderService();
        User user = new User();
        user.createOrder(uos);
        user.createOrder(uos);
        user.payOrder(uos);

        AdminOrderService aos = new AdminOrderService();
        Admin admin = new Admin();
        admin.getOrder(aos);
        admin.updateOrder(aos);
        admin.deleteOrder(aos);
    }
}
