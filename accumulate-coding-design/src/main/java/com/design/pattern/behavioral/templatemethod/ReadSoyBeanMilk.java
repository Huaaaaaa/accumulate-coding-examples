package com.design.pattern.behavioral.templatemethod;

/**
 * @Author: Huaaaaaa
 * Date:  2021/1/5
 * Todo:  制作红豆豆浆:实现红豆豆浆自己的业务逻辑即可
 * Time 11:01
 */
public class ReadSoyBeanMilk extends SoyBeanMilkMaker {

    @Override
    public String addSoyMilk() {
        return "加入红豆";
    }

    @Override
    public String addCondiments() {
        return null;
    }

    @Override
    public boolean isAddSoy() {
        return true;
    }

    @Override
    public boolean isAddCondiments() {
        return false;
    }
}
