package com.design.pattern.creational.builder;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo: 定义一个抽象的购买构造器
 * Time 22:53
 */
public abstract class AbstractBuyBuilder {

    private Order order = new Order();

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    /**
     * 下单，返回订单号
     *
     * @param userName
     * @param productId
     * @return
     */
    abstract void createOrder(String userName, String productId);

    /**
     * 查询订单价格
     */
    abstract void getPrice();

    /**
     * 支付订单
     */
    abstract void payOrder();


    /**
     * 发货
     */
    abstract void delivery();

    /**
     * 通知用户
     */
    abstract void noticeUser(String message);

    public Order buy() {
        return order;
    }
}
