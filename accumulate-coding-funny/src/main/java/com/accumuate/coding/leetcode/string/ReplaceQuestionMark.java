package com.accumuate.coding.leetcode.string;

import org.checkerframework.checker.units.qual.A;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/5 11:25 上午
 * @description: 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 * 注意：你 不能 修改非 '?' 字符。
 */
public class ReplaceQuestionMark {

    private char[] letters = {'a', 'b', 'c'};

    public static void main(String[] args) {
        ReplaceQuestionMark mark = new ReplaceQuestionMark();
        Scanner scanner = new Scanner(System.in);
        String test = "??yw?ipkj?";
        String s = mark.modifyString(scanner.nextLine());
        System.out.println(s);
    }

    public String modifyString(String s) {
        if ("".equals(s) || null == s) {
            return "";
        }
        if ("?".equals(s)) {
            return "a";
        }
        char qm = '?';
        char[] chars = s.toCharArray();
        int len = s.length();
        int letterLen = letters.length;
        int letterIndex = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] == qm) {
                if (i == 0 && i < len - 1) {
                    while (chars[i + 1] == letters[letterIndex]) {
                        letterIndex++;
                        if (letterIndex == letterLen - 1) {
                            letterIndex = 0;
                        }
                    }
                } else if (i > 0 && i == len - 1) {
                    while (chars[i - 1] == letters[letterIndex]) {
                        letterIndex++;
                        if (letterIndex == letterLen - 1) {
                            letterIndex = 0;
                        }
                    }
                } else {
                    while (chars[i - 1] == letters[letterIndex] || chars[i + 1] == letters[letterIndex]) {
                        letterIndex++;
                        if (letterIndex == letterLen - 1) {
                            letterIndex = 0;
                        }
                    }
                }

                chars[i] = letters[letterIndex];
            }
        }
        return new String(chars);
    }

}
