package com.accumulate.coding.design.principle.ocp;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 圆形类，继承图形类并重载方法drawShape
 * Time 10:21
 */
public class CircleShape extends ServerShape {

    @Override
    public void drawShape() {
        System.out.println("画圆形");
    }
}
