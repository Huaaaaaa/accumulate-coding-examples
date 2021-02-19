package com.design.pattern.structrual.decorator;

import java.math.BigDecimal;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/20
 * Todo:
 * Time 10:34
 */
public abstract class Drink {

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 份数
     */
    private int count = 1;

    /**
     * 奶茶描述信息
     */
    private String description;

    abstract BigDecimal cost();

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
