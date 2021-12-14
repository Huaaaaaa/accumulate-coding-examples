package com.accumuate.coding.leetcode.string;

import java.util.Scanner;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/14 10:22 上午
 * @Description:
 */
public class ReverseString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(solve(s));
    }

    public static String solve(String str) {
        // write code here
        int len = str.length();
        char[] chars = str.toCharArray();
        int low = 0, high = len - 1;
        while (low < high) {
            char tmp = chars[low];
            chars[low] = chars[high];
            chars[high] = tmp;
            low++;
            high--;
        }
        return new String(chars);
    }
}
