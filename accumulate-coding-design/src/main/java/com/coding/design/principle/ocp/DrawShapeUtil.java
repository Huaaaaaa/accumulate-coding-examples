package com.coding.design.principle.ocp;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 画图工具
 * Time 10:25
 */
public class DrawShapeUtil {

    /**
     * 画图工具类只需依赖抽象类即可
     *
     * @param serverShape
     */
    public static void drawShape(ServerShape serverShape) {
        serverShape.drawShape();
    }
}
