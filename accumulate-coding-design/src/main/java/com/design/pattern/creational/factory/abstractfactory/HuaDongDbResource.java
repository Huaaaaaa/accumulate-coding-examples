package com.design.pattern.creational.factory.abstractfactory;

import com.accumulate.coding.common.utils.RandomUtil;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo: 华东数据库资源
 * Time 18:07
 */
public class HuaDongDbResource extends AbstractResource {
    @Override
    void creatInstance() {
        System.out.println("华东地区数据库资源创建成功，ID=" + RandomUtil.getUUID());
    }
}
