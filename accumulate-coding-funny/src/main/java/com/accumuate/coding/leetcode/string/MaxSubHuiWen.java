package com.accumuate.coding.leetcode.string;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/14 12:16 下午
 * @Description: 最长回文子串
 */
public class MaxSubHuiWen {

    public static void main(String[] args) {
        String res = longestSubStr("abacdd");
        System.out.println(res);
    }


    public static String longestSubStr(String s) {
        if ("".equals(s) || s.length() < 1) {
            return "";
        }
        int len = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            int len1 = checkSub(s, i, i);
            int len2 = checkSub(s, i, i + 1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int checkSub(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
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
