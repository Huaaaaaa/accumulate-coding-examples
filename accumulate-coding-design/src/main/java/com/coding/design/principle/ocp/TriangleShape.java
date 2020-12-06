package com.coding.design.principle.ocp;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo:  三角形，继承图形类并重载方法drawShape
 * Time 10:23
 */
public class TriangleShape extends ServerShape {

    @Override
    public void drawShape() {
        System.out.println("画三角形");
    }
}
