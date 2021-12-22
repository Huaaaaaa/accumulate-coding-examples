package com.coding.interview.shop;

import java.util.Scanner;

/**
 * @author: me
 * @createTime: 2021/12/22 2:30 下午
 * @description: 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reformat-the-string
 */
public class StringFormat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String reformat = reformat(s);
        System.out.println(reformat);
    }


    public static String reformat(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        //长度为1，直接返回
        if (length == 1) {
            return s;
        }
        char[] formatChar = new char[length];
        int numberCount = 0;
        int strCount = 0;
        //统计字母和数字的个数，哪个多，偶数位放哪个
        for (int i = 0; i < length; i++) {
            char aChar = chars[i];
            boolean digit = Character.isDigit(aChar);
            if (digit) {
                numberCount++;
            } else {
                strCount++;
            }
        }
        //判断个数是否平衡
        if (numberCount == length || strCount == length || Math.abs(numberCount - strCount) > 1) {
            return "";
        }
        //奇数位从1开始，偶数位从0开始
        int evenCount = 1;
        int oddCount = 0;
        for (int i = 0; i < length; i++) {
            char aChar = chars[i];
            boolean digit = Character.isDigit(aChar);
            if (strCount > numberCount) {
                if (digit) {
                    formatChar[evenCount] = aChar;
                    evenCount = evenCount + 2;
                } else {
                    formatChar[oddCount] = aChar;
                    oddCount = oddCount + 2;
                }

            } else {
                if (digit) {
                    formatChar[oddCount] = aChar;
                    oddCount = oddCount + 2;
                } else {
                    formatChar[evenCount] = aChar;
                    evenCount = evenCount + 2;
                }
            }
        }
        return new String(formatChar);
    }
}
