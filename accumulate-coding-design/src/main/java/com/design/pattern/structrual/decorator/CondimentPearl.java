package com.design.pattern.structrual.decorator;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/20
 * Todo: 小料珍珠
 * Time 9:49
 */
public class CondimentPearl extends CondimentDecorator {

    public CondimentPearl(Drink milkTea) {

        super(milkTea);
        setPrice(new BigDecimal(1.5));
        setDescription("珍珠");
    }
}
