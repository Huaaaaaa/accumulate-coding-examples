package com.coding.design.principle.isp;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/5
 * Todo: An example to against ISP(Interface Segregation Principle)
 * Time 19:32
 */
public class AgainstISPrinciple {


    /**
     * 定义一个公共的订单接口
     */
    interface OrderInterface {

        void getOrder();

        void createOrder();

        void deleteOrder();

        void updateOrder();

        void payOrder();

    }

    /**
     * 用户服务实现订单接口完成用户需求
     */
    class userServiceOrderInterfaceImpl implements OrderInterface {
        @Override
        public void getOrder() {
            System.out.println("用户服务获取订单");
        }

        @Override
        public void createOrder() {
            System.out.println("用户服务创建订单");
        }

        @Override
        public void deleteOrder() {
            System.out.println("用户服务删除订单");
        }

        @Override
        public void updateOrder() {
            System.out.println("用户服务修改订单列表");
        }

        @Override
        public void payOrder() {
            System.out.println("用户服务支付订单");
        }
    }

    /**
     * 管理员服务实现订单接口实现管理员需求
     */
    class adminServiceOrderInterfaceImpl implements OrderInterface {
        @Override
        public void getOrder() {
            System.out.println("管理员服务获取订单");
        }

        @Override
        public void createOrder() {
            System.out.println("管理员服务创建订单");
        }

        @Override
        public void deleteOrder() {
            System.out.println("管理员服务删除订单");
        }

        @Override
        public void updateOrder() {
            System.out.println("管理员服务修改订单列表");
        }

        @Override
        public void payOrder() {
            System.out.println("管理员服务支付订单");
        }
    }

    /**
     * 需求：用户通过依赖用户服务进行创建、获取、支付订单
     * 问题：当用户依赖订单接口时，还能进行订单的修改和删除操作，违背接口隔离原则
     */
    class User {
        public void createOrder(OrderInterface oi) {
            oi.createOrder();
        }

        public void getOrder(OrderInterface oi) {
            oi.getOrder();
        }

        public void payOrder(OrderInterface oi) {
            oi.payOrder();
        }
    }

    /**
     * 需求：管理员通过依赖管理员服务进行获取、修改、删除订单
     * 问题：当管理员依赖订单接口时，还能进行创建和支付订单操作，违背接口隔离原则
     */
    class Admin {
        public void getOrder(OrderInterface oi) {
            oi.getOrder();
        }

        public void updateOrder(OrderInterface oi) {
            oi.updateOrder();
        }

        public void deleteOrder(OrderInterface oi) {
            oi.deleteOrder();
        }

    }
}
