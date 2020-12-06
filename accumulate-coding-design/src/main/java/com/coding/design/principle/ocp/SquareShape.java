package com.coding.design.principle.ocp;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 正方形，继承图形类并重载方法drawShape
 * Time 10:24
 */
public class SquareShape extends ServerShape {

    @Override
    public void drawShape() {
        System.out.println("画正方形");
    }
}