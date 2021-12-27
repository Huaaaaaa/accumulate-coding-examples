package com.accumuate.coding.leetcode.string;

import java.util.HashMap;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/27 11:20 上午
 * @description:
 */
public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        s=s.replace("IV", "a");
        s=s.replace("IX", "b");
        s=s.replace("XL", "c");
        s=s.replace("XC", "d");
        s=s.replace("CD", "e");
        s=s.replace("CM", "f");
        int sum = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            sum += getData(chars[i]);
        }
        return sum;
    }

    public int getData(char key) {
        switch (key) {
            case 'a':
                return 4;
            case 'b':
                return 9;
            case 'c':
                return 40;
            case 'd':
                return 90;
            case 'e':
                return 400;
            case 'f':
                return 900;
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
