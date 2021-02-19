package com.design.pattern.structrual.facade;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo: 商品类
 * Time 8:57
 */

@Data
public class Goods implements Serializable {

    private static final long serialVersionUID = -7964995894392848078L;

    private String goodId;

    private String name;

    private BigDecimal price;

    public Goods(String goodId, String name, BigDecimal price) {
        this.goodId = goodId;
        this.name = name;
        this.price = price;
    }
}
