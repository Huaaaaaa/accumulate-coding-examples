package com.design.pattern.creational.builder;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo:
 * Time 22:51
 */
@Data
public class Order {

    private String orderNumber;

    private BigDecimal price;

    private String productId;

    private String userName;

    private String status;
}
