package com.design.pattern.structrual.bridge;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/14
 * Todo: 红色包包
 * Time 10:45
 */
public class RedBag implements IBagColor {

    @Override
    public String getColor() {
        System.out.println("红色包包");
        return "red";
    }
}
