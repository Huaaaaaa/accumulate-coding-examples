package com.accumulate.coding.basic.base;

/**
 * @author: cyhua
 * @createTime: 2021/11/16
 * @description:
 */
public class BitCalculate {

    public static void main(String[] args) {
        BitCalculate bitCalculate = new BitCalculate();
        bitCalculate.testBitCal();
    }

    public void testNonBitCal() {
        int a = 2;
        int b = 3;
        int aleft = a << b;
        int aRight = aleft >> b;

        System.out.println("a=" + a + ";aLeft=" + aleft + ";aRight=" + aRight);


        int a1 = -2;
        int a1left = a1 << b;
        int a1Right = a1left >> b;

        System.out.println("a1=" + a1 + ";a1Left=" + a1left + ";a1Right=" + a1Right);
    }

    public void testBitCal() {
        int a = 2;
        int b = 1;
        int aRight = a >>> b;
        System.out.println("a=" + a + ";aRight=" + aRight);


        int a1 = -2;
        int a1Right = a1 >>> b;
        System.out.println("a1=" + a1 + ";a1Right=" + a1Right);
    }
}
