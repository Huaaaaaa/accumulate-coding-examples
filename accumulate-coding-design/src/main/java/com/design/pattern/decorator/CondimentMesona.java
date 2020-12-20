package com.design.pattern.decorator;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/20
 * Todo: 小料仙草
 * Time 9:54
 */
public class CondimentMesona extends CondimentDecorator {

    public CondimentMesona(Drink milkTea) {
        super(milkTea);
        setPrice(new BigDecimal(3));
        setDescription("仙草");
    }
}
