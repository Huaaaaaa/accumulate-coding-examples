package com.design.pattern.behavioral.templatemethod;

import org.springframework.util.StringUtils;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/5
 * Todo: 豆浆机
 * Time 10:50
 */
public abstract class SoyBeanMilkMaker {

    /**
     * 模板方法：定义制作豆浆的流程，使用final修饰，避免被子类重写
     */
    final void makeSoyBeanMilk() {
        System.out.println("第一步：" + addSoyBean());
        System.out.println("第二步：" + (isAddSoy() ? addSoyMilk() : "不加其它豆子"));
        System.out.println("第三步：" + (isAddCondiments() ? addCondiments() : "不加其它佐料"));
        System.out.println("第四步：" + addWater());
        System.out.println("第五步：" + soak());
        System.out.println("第六步：" + mill());
    }

    private String addSoyBean() {
        return "加入黄豆";
    }

    /**
     * 抽象方法加豆子：延迟到子类中执行，由子类决定加入什么豆子
     */
    public abstract String addSoyMilk();

    /**
     * 抽象方法加佐料：延迟到子类中执行，由子类决定加入什么样的佐料
     */
    public abstract String addCondiments();


    /**
     * 基本方法加水 ：公共流程可复用
     */
    private String addWater() {
        return "加入水";
    }

    /**
     * 基本方法浸泡：公共流程可复用
     */
    private String soak() {
        return "开始浸泡";
    }

    /**
     * 基本方法磨豆浆：公共流程可复用
     */
    private String mill() {
        return "开始打磨豆浆";
    }

    /**
     * 钩子方法：控制是否加入其它的豆浆
     *
     * @return
     */
    public boolean isAddSoy() {
        return false;
    }

    /**
     * 钩子方法：控制是否加入佐料
     *
     * @return
     */
    public boolean isAddCondiments() {
        return false;
    }

}
