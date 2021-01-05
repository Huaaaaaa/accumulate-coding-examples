package com.design.pattern.creational.factory.abstractfactory;

import com.accumulate.coding.common.utils.RandomUtil;

/**
 * Author:
 * Date:  2020/12/12
 * Todo: 华北地区数据库资源
 * Time 18:06
 */
public class HuaBeiDbResource extends AbstractResource {
    @Override
    void creatInstance() {
        System.out.println("华北地区数据库资源创建成功，ID=" + RandomUtil.getUUID());
    }
}
