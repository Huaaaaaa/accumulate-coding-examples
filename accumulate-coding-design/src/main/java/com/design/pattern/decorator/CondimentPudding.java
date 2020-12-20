package com.design.pattern.decorator;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/15
 * Todo: 小料布丁
 * Time 11:24
 */
public class CondimentPudding extends CondimentDecorator {

    public CondimentPudding(Drink milkTea) {
        super(milkTea);
        setPrice(new BigDecimal(2));
        setDescription("布丁");
    }
}
