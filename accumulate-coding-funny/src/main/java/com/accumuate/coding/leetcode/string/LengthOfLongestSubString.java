package com.accumuate.coding.leetcode.string;

import com.baomidou.mybatisplus.generator.config.INameConvert;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: me
 * @createTime: 2021/12/21 2:33 下午
 * @description: 最长无重复子串
 */
public class LengthOfLongestSubString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int length = length(s);
        System.out.println(length);
    }


    public static int length(String data) {
        int left = 0;
        int right = 0;
        HashMap<String, Integer> window = new HashMap<>();
        int max = 0;
        char[] chars = data.toCharArray();
        while (right < chars.length) {
            String sub = String.valueOf(chars[right]);
            window.put(sub, window.getOrDefault(sub, 0) + 1);
            right++;
            while (window.get(sub) > 1) {
                String subLeft = String.valueOf(chars[left]);
                left++;
                window.put(subLeft, window.get(sub) - 1);
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
