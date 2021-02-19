package com.design.pattern.structrual.decorator;

import java.math.BigDecimal;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/15
 * Todo: 珍珠奶茶
 * Time 10:57
 */
public class BubbleMilkTea extends MilkTea {

    public BubbleMilkTea() {
        super.setDescription("珍珠奶茶");
        super.setPrice(new BigDecimal(15));
    }
}
