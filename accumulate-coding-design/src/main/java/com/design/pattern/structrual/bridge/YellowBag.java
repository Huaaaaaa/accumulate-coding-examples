package com.design.pattern.structrual.bridge;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/14
 * Todo: 黄色包包
 * Time 10:43
 */
public class YellowBag implements IBagColor {

    @Override
    public String getColor() {
        System.out.println("黄色包包");
        return "yellow";
    }
}
