package com.design.pattern.creational.factory.abstractfactory;

import com.accumulate.coding.common.utils.RandomUtil;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo: 华东地区主机资源
 * Time 18:07
 */
public class HuaDongVmResource extends AbstractResource {
    @Override
    void creatInstance() {
        System.out.println("华东地区主机资源创建成功，ID=" + RandomUtil.getUUID());
    }
}
