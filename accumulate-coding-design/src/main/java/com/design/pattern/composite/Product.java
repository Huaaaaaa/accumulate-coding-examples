package com.design.pattern.composite;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/20
 * Todo: 抽象构件Component
 * Time 16:38
 */
public abstract class Product {


    abstract BigDecimal calculatePrice();

    abstract String show();
}
