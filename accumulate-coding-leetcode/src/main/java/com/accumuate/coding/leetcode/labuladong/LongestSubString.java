package com.accumuate.coding.leetcode.labuladong;

import java.util.HashMap;

/**
 * @author: cyhua
 * @createTime: 2021/6/12
 * @description: length of longest sub string:无重复字符的最长子串
 */
public class LongestSubString {

    public static void main(String[] args) {
        int res = lengthOfLongestSubString("abcabcbb");
        System.out.println(res);
    }

    private static int lengthOfLongestSubString(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        char[] chars = s.toCharArray();
        int res = 0;
        while (right < s.length()) {
            char c = chars[right];
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            //开始收缩窗口
            while (window.get(c) > 1) {
                char c1 = chars[left];
                left++;
                window.put(c1, window.get(c1) - 1);
            }
            res = Integer.compare(res, right - left) > 0 ? res : right - left;
        }
        System.out.println("subStr=" + s.substring(left, right));
        return res;
    }
}
