package com.design.principle.ocp;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo:
 * Time 10:29
 */
public class ClientDrawShape {

    public static void main(String[] args) {
        DrawShapeUtil.drawShape(new CircleShape());
        DrawShapeUtil.drawShape(new TriangleShape());
        DrawShapeUtil.drawShape(new SquareShape());
        DrawShapeUtil.drawShape(new NewShape());

    }
}
