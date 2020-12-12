package com.design.pattern.factory.factorymethod;

import com.accumulate.coding.common.utils.RandomUtil;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo:
 * Time 15:09
 */
public class Vm extends Resource {

    @Override
    void creatInstance() {
        System.out.println("云主机创建完成，id=" + RandomUtil.getUUID());
    }
}
