package com.accumulate.coding.tool.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName OrderEntity
 * @Description TODO
 * @Date 2020/8/18  12:14
 */
@Data
public class OrderEntity {

    private String orderNumber;

    private String orderType;

    private String userName;

    private BigDecimal orderPrice;

    private String productType;

    private String productDetail;

    private String orderStatus;

    private String timeUnit;

    private Integer timeSpan;

    private String createTime;

    private String updateTime;

    private String payTime;

}
