package com.accumuate.coding.leetcode.tx;

import io.swagger.models.auth.In;

import java.util.HashMap;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/24 9:49 上午
 * @description: 最长无重复字串：使用滑动窗口解决
 */
public class MaxSubStringNoRepeat {

    public static void main(String[] args) {
        MaxSubStringNoRepeat mssnr = new MaxSubStringNoRepeat();
        int length = mssnr.lengthOfLongestSubstring("pwwkew");
        System.out.println(length);

    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        int max = 0;
        //窗口，用来存储已经遍历过的元素及其出现的次数
        HashMap<Character, Integer> window = new HashMap<>();
        while (right < len) {
            char aChar = chars[right];
            Integer count = window.getOrDefault(aChar, 0);
            window.put(aChar, count + 1);
            ++right;
            //开始收缩左边窗口
            while (window.get(aChar) > 1) {
                //先将左边元素的出现次数减1
                window.put(chars[left], window.get(chars[left]) - 1);
                //然后收缩左边窗口
                ++left;
            }

            max = Math.max(max, right - left);

        }
        return max;
    }
}
