package com.accumuate.coding.leetcode.basic;

/**
 * @Author: huayingcao2
 * @DateTime: 2021/5/27  12:57
 * @Description: 汉明距离： 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 */
public class HammingDistance {

    public static void main(String[] args) {
        int hammingDistance = hammingDistance2(1, 2);
        System.out.println("hammingDistance=" + hammingDistance);
    }

    public static int hammingDistance(int x, int y) {
        int xo = x ^ y;
        String s = Integer.toBinaryString(xo);
        char[] chars = s.toCharArray();
        int size = chars.length;
        int distance = 0;
        for (char val : chars) {
            if (String.valueOf(val).equals("1")) {
                ++distance;
            }
        }
        return distance;
    }

    public static int hammingDistance2(int x, int y) {
        int xo = x ^ y;
        int res = 0;
        while (xo != 0) {
            res += xo & 1;
            xo = xo >> 1;
        }
        return res;
    }
}
