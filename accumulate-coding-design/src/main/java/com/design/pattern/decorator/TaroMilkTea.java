package com.design.pattern.decorator;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/15
 * Todo: 鲜芋奶茶
 * Time 11:15
 */
public class TaroMilkTea extends MilkTea {

    public TaroMilkTea() {
        super.setDescription("鲜芋奶茶");
        super.setPrice(new BigDecimal(15));
    }
}
