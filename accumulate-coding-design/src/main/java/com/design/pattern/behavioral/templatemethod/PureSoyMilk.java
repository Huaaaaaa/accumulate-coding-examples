package com.design.pattern.behavioral.templatemethod;

/**
 * @Author: Huaaaaaa
 * Date:  2021/1/5
 * Todo: 制作纯豆浆：不加任何其它豆子和佐料
 * Time 11:35
 */
public class PureSoyMilk extends SoyBeanMilkMaker{

    @Override
    public String addSoyMilk() {
        return null;
    }

    @Override
    public String addCondiments() {
        return null;
    }
}
