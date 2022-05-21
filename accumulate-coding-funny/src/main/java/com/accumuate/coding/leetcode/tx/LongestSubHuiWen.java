package com.accumuate.coding.leetcode.tx;

import org.springframework.util.StringUtils;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/24 11:13 上午
 * @description: 最长回文字串
 */
public class LongestSubHuiWen {

    public static void main(String[] args) {
        LongestSubHuiWen lshw = new LongestSubHuiWen();
        String res = lshw.longestPalindrome("abac");
        System.out.println(!StringUtils.isEmpty(res) ? res : "没有回文串");
    }

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        if (size < 2) {
            return s;
        }
        int left = 0, right = 0;
        int maxStart = 0, maxLen = 0;
        int len = 0;
        for (int i = 0; i < size; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && chars[left] == chars[i]) {
                len++;
                left--;
            }
            while (right < size && chars[right] == chars[i]) {
                len++;
                right++;
            }

            while (left >= 0 && right < size && chars[left] == chars[right]) {
                len = len + 2;
                left--;
                right++;
            }

            if (len > maxLen) {
                maxLen = len;
                maxStart = left + 1;
            }
        }
        return s.substring(maxStart, maxStart + maxLen + 1);
    }

}
