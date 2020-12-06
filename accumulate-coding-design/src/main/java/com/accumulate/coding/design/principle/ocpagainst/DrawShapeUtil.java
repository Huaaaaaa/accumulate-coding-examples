package com.accumulate.coding.design.principle.ocpagainst;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 画图工具
 * Time 10:25
 */
public class DrawShapeUtil {

    public static void drawShape(ServerShape serverShape) {
        if (serverShape.shapeType.equals("1")) {
            drawCircle();
        } else if (serverShape.shapeType.equals("2")) {
            drawTriangle();
        } else if (serverShape.shapeType.equals("3")) {
            drawSquare();
        } else if (serverShape.shapeType.equals("4")) {
//            扩展时服务端需增加逻辑,违背了扩展开放，修改关闭的原则
            drawNewShape();
        }
    }

    private static void drawCircle() {
        System.out.println("画圆形");
    }

    private static void drawTriangle() {
        System.out.println("画三角形");
    }

    private static void drawSquare() {
        System.out.println("画正方形");
    }

    /**
     * 扩展时服务端需增加逻辑
     */
    private static void drawNewShape() {
        System.out.println("画新增图形");
    }
}
