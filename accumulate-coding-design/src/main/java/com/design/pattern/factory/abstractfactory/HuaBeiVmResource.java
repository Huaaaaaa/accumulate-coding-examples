package com.design.pattern.factory.abstractfactory;

import com.accumulate.coding.common.utils.RandomUtil;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo: 华北地区主机资源
 * Time 18:04
 */
public class HuaBeiVmResource extends AbstractResource{


    @Override
    void creatInstance() {
        System.out.println("华北地区主机资源创建成功，ID=" + RandomUtil.getUUID());
    }
}
