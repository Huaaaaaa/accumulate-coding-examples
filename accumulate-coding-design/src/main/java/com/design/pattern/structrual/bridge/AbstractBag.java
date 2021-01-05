package com.design.pattern.structrual.bridge;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/14
 * Todo: 包包抽象类（样式）
 * Time 10:45
 */
public abstract class AbstractBag {

    protected IBagColor bagColor;

    abstract String getStyle();

    public void setBagColor(IBagColor bagColor) {
        this.bagColor = bagColor;
    }
}
