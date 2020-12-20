package com.design.pattern.composite;

import com.baomidou.mybatisplus.generator.config.PackageConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/20
 * Todo: 叶子构件
 * Time 16:39
 */
public class Goods extends Product {

    /**
     * 物品名称
     */
    private String name;

    /**
     * 物品数量
     */
    private int quantity = 1;

    /**
     * 物品价格
     */
    private BigDecimal price;

    public Goods(String name, int quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    BigDecimal calculatePrice() {
        return price.multiply(new BigDecimal(quantity));
    }

    @Override
    String show() {
        return this.name;
    }
}
