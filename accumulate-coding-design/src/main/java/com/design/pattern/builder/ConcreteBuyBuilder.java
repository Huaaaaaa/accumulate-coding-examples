package com.design.pattern.builder;

import com.accumulate.coding.common.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo: 定义一个购买电脑的具体类，实现抽象构造器
 * Time 23:00
 */
@Slf4j
public class ConcreteBuyBuilder extends AbstractBuyBuilder {

    @Override
    void createOrder(String userName, String productId) {
        Order order = getOrder();
        order.setUserName(userName);
        order.setProductId(productId);
        order.setOrderNumber(RandomUtil.getUUID());
        log.info("订单创建完成:orderNumber={}", getOrder().getOrderNumber());

    }

    @Override
    void getPrice() {
        getOrder().setPrice(new BigDecimal(200));
        log.info("订单查价完成:price={}", getOrder().getPrice());

    }

    @Override
    void payOrder() {
        getOrder().setStatus("已支付");
        log.info("订单支付完成:status={}", getOrder().getStatus());
    }

    @Override
    void delivery() {
        if ("已支付".equals(getOrder().getStatus())) {
            getOrder().setStatus("已发货");
            noticeUser("您的订单已发货");
        } else {
            noticeUser("余额不足，无法购买，请您尽快充值！！！");
        }

    }

    @Override
    void noticeUser(String message) {
        log.info("通知用户购买结果:status={},message={}", getOrder().getStatus(), message);
    }
}
