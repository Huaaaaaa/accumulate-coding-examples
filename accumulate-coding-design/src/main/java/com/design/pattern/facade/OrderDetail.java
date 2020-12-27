package com.design.pattern.facade;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo:
 * Time 8:59
 */
@Data
public class OrderDetail {

    /**
     * 商品
     */
    private Goods goods;

    /**
     * 购买数量
     */
    private Integer quantity;

    /**
     * 订单号
     */
    private String orderNumber;

    /**
     * 购买用户
     */
    private String userName;

    /**
     * 全部价格
     */
    private BigDecimal totalPrice;

    /**
     * 实际需支付价格
     */
    private BigDecimal actualPrice;

    /**
     * 优惠券价格
     */
    private BigDecimal couponPrice;
}
