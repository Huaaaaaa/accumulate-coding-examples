package com.accumuate.coding.leetcode.string;

import java.util.*;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/5 12:05 下午
 * @description: 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 2->abc
 * 3->def
 * 4->ghi
 * 5->jkl
 * 6->mno
 * 7->pqrs
 * 8->tuv
 * 9->wxyz
 */
public class Number2Letter {

    private static Map<Character, String> dict = new HashMap<>();

    static {
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");
    }

    public static void main(String[] args) {
        Number2Letter number2Letter = new Number2Letter();
        Scanner scanner = new Scanner(System.in);
        List<String> res = number2Letter.letterCombinations(scanner.nextLine());
        System.out.println(res);

    }

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits) || null == digits) {
            return null;
        }
        List<String> result = new ArrayList<>();
        combination(result, dict, digits, 0, new StringBuffer());
        return result;
    }


    public void combination(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (digits.length() == index) {
            combinations.add(combination.toString());
        } else {
            char[] chars = digits.toCharArray();
            char letter = chars[index];
            String s = phoneMap.get(letter);
            int len = s.length();
            for (int i = 0; i < len; i++) {
                combination.append(s.charAt(i));
                combination(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

}
