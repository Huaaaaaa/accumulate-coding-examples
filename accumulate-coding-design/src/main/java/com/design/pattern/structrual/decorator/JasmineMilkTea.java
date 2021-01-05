package com.design.pattern.structrual.decorator;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/15
 * Todo: 茉香奶茶
 * Time 11:14
 */
public class JasmineMilkTea extends MilkTea {

    public JasmineMilkTea() {
        super.setDescription("茉香奶茶");
        super.setPrice(new BigDecimal(21));
    }
}
