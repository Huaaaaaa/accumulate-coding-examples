package com.design.pattern.decorator;

import java.math.BigDecimal;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/15
 * Todo: 小料装饰器:和Component行程继承和组合的关系，继承是让小料定义自己的价格，组合是获取奶茶的价格
 * Time 11:18
 */
public class CondimentDecorator extends Drink {

    private Drink milkTea;

    public CondimentDecorator(Drink milkTea) {
        this.milkTea = milkTea;
    }

    /**
     * 装饰器的价格为:单品价格+小料价格
     *
     * @return
     */
    @Override
    public BigDecimal cost() {
        return milkTea.cost().add(super.getPrice().multiply(new BigDecimal(super.getCount())));
    }


    @Override
    public String getDescription() {
        return this.milkTea.getDescription() + "另加" + super.getCount() + "份" + super.getDescription();
    }

}
