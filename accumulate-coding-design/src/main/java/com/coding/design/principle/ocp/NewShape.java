package com.coding.design.principle.ocp;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 当增加一个新的图形时，只需继续继承图形类并重载方法drawShape即可
 * Time 10:31
 */
public class NewShape extends ServerShape {


    @Override
    public void drawShape() {
        System.out.println("画新增的图形");
    }
}
