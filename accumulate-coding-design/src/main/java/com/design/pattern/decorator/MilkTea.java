package com.design.pattern.decorator;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/15
 * Todo: Component类
 * Time 10:54
 */
public class MilkTea extends Drink {


    @Override
    BigDecimal cost() {
        return super.getPrice().multiply(new BigDecimal(super.getCount()));
    }

    @Override
    public String getDescription() {
        return super.getCount() + "份" + super.getDescription();
    }
}
