package com.design.pattern.creational.factory.factorymethod;

import com.accumulate.coding.common.utils.RandomUtil;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo:
 * Time 15:15
 */
public class Db extends Resource {

    @Override
    void creatInstance() {
        System.out.println("云数据库创建完成，id=" + RandomUtil.getUUID());
    }
}
