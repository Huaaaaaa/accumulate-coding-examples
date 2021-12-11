package com.accumuate.coding.leetcode.dec.nine;

import java.util.Scanner;

/**
 * @author: cyhua
 * @createTime: 2021/12/9
 * @description: 统计字符串中某个字符出现的次数
 */
public class StatisticCharTime {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();
        String s = scanner.nextLine();
        System.out.println(statisticNum(src, s));
    }

    public static int statistic(String src, String c) {
        char[] chars = src.toLowerCase().toCharArray();
        char des = c.toLowerCase().charAt(0);
        int num = 0;
        for (char srcChar : chars) {
            if (srcChar == des) {
                ++num;
            }
        }
        return num;
    }

    public static int statisticNum(String src, String c) {
        String s = src.toLowerCase().replaceAll(c.toLowerCase(), "");
        return src.length() - s.length();
    }

}
