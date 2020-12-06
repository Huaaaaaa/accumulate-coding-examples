package com.accumulate.coding.design.principle.ocpagainst;

import java.util.Date;

/**
 * Author: Huaaaaaa
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
