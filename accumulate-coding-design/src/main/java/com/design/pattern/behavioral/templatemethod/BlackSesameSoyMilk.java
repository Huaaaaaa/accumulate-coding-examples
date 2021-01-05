package com.design.pattern.behavioral.templatemethod;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/5
 * Todo: 制作纯豆浆：只加佐料不加豆浆
 * Time 11:37
 */
public class BlackSesameSoyMilk extends SoyBeanMilkMaker {

    @Override
    public String addSoyMilk() {
        return null;
    }

    /**
     * 自定义实现
     *
     * @return
     */
    @Override
    public String addCondiments() {
        return "加入黑芝麻";
    }

    /**
     * 只有重写该钩子方法，才能保证自定义实现在父类的模板方法中被调用
     *
     * @return
     */
    @Override
    public boolean isAddCondiments() {
        return true;
    }
}
