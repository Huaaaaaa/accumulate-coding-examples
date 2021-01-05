package com.design.pattern.structrual.bridge;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/14
 * Todo: 斜挎包
 * Time 10:50
 */
public class SatchelBag extends AbstractBag {
    @Override
    String getStyle() {
        System.out.println("斜挎包");
        return bagColor.getColor() + "SatchelBag";
    }
}
