package com.design.pattern.structrual.adapter.interfaceadapter;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/13
 * Todo: 定义一个抽象电压适配器，实现适配器接口
 * Time 15:57
 */
public abstract class AbstractVoltageAdapter implements IVoltageAdapter {

    @Override
    public int voltage5v() {
        return 0;
    }

    @Override
    public int voltage50v() {
        return 0;
    }

    @Override
    public int voltage200v() {
        return 0;
    }

    @Override
    public int voltage220v() {
        return 0;
    }
}
