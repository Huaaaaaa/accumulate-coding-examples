package com.accumulate.coding.basic.utils;

import com.accumulate.coding.basic.res.ShiftRes;

/**
 *
 */
public class ShiftUtil {

    /**
     * 位移运算
     *
     * @param data      原数据
     * @param bit       位移个数
     * @param shiftType 位移类型；left-左移；right-右移；unRight-无符号右移
     * @return
     */
    public static ShiftRes shift(int data, int bit, String shiftType) {
        String afterLeftShift;
        Integer afterShift;
        if (shiftType.equals("left")) {
            afterLeftShift = Integer.toBinaryString(data << bit);
            afterShift = data << bit;
        } else if (shiftType.equals("right")) {
            afterLeftShift = Integer.toBinaryString(data >> bit);
            afterShift = data >> bit;
        } else if (shiftType.equals("unRight")) {
            afterLeftShift = Integer.toBinaryString(data >>> bit);
            afterShift = data >> bit;
        } else {
            afterLeftShift = Integer.toBinaryString(data);
            afterShift = data;
        }

        ShiftRes<Integer> shiftRes = new ShiftRes(afterLeftShift, afterShift);
        return shiftRes;
    }
}
