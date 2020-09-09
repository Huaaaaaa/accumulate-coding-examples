package com.accumulate.coding.tool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName OrderEntity
 * @Description TODO
 * @Date 2020/8/18  12:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 5322426369045334401L;

    private String orderNumber;

    private String orderType;

    private String userName;

    private BigDecimal orderPrice;

    private String productType;

    private String productInfo;

    private String orderStatus;

    private String timeUnit;

    private Integer timeSpan;

    private String createTime;

    private String updateTime;

    private String payTime;

}
