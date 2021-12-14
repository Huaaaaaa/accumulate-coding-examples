package com.accumuate.coding.leetcode.string;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/14 12:16 下午
 * @Description: 最长回文子串
 */
public class MaxSubHuiWen {

    public static void main(String[] args) {
        int res = getLongestPalindrome("abacdd");
        System.out.println(res);
    }

    public static int getLongestPalindrome(String A) {
        // write code here
        int maxLen = 0;

        for (int i = 0; i < A.length(); i++) {
            for (int j = i; j <= A.length(); j++) {
                String curr = A.substring(i, j);
                if (isFind(curr) && curr.length() > maxLen) {
                    maxLen = curr.length();
                }
            }
        }
        return maxLen;
    }

    public static boolean isFind(String curr) {
        int len = curr.length();
        for (int k = 0; k < len / 2; k++) {
            if (curr.charAt(k) != curr.charAt(len - k - 1)) {
                return false;
            }
        }

        return true;
    }
}
