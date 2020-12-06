package com.design.principle.ispagainst;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: An example to against ISP(Interface Segregation Principle)
 * Time 21:28
 */
public class AgainstInterfaceSegregationPrinciple {

    public static void main(String[] args) {
        System.out.println("An example to against ISP");
        UserOrderService uos  = new UserOrderService();
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
