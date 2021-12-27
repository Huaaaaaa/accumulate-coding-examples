package com.accumuate.coding.leetcode.string;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/27 7:41 上午
 * @description:给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int reverse = reverseInteger.reverse1(2147483646);
        System.out.println(reverse);
    }

    /**
     * 通过字符串的方式：较占内存
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        String s = String.valueOf(x);
        int sign = 1;
        if (s.startsWith("-")) {
            sign = -1;
            s = s.substring(1);
        }
        int res = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = len - 1; i >= 0; i--) {
            char currChar = chars[i];
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10) && (currChar - '0') > 7) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10) && (currChar - '0') < -8) {
                return 0;
            }
            res = res * 10 + sign * (currChar - '0');
        }
        return res;
    }

    /**
     * 优化，通过取余的方式获取最后一个数字
     *
     * @param x
     * @return
     */
    public int reverse1(int x) {
        int res = 0;
        //循环退出条件：x==0
        while (x != 0) {
            //1.取最后一个数
            int mod = x % 10;
            //2.判断当前数是否会大于整型最大值2147483647
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10) && mod > 7) {
                return 0;
            }
            //3.判断当前数是否会小于整型最小值-2147483648
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10) && mod < -8) {
                return 0;
            }
            //4.计算当前数：前一次的值*10+最低位的值
            res = res * 10 + mod;
            //5.更新原值
            x = x / 10;
        }
        return res;
    }
}
