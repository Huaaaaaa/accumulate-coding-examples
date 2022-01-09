package com.accumuate.coding.leetcode.string;

import java.util.*;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/6 11:08 上午
 * @description: 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>{}()[][]
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class ValidKuoHao {

    public static void main(String[] args) {
        ValidKuoHao validKuoHao = new ValidKuoHao();
        Scanner scanner = new Scanner(System.in);
        boolean valid = validKuoHao.isValid(scanner.nextLine());
        System.out.println(valid);
    }

    /**
     * 分析：后面遇到的左括号要先关闭，满足栈的特点，所以将左括号入栈，遇到右括号出栈，并判断value是否与栈顶数据一致
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        //空串、奇数长度都直接返回false
        if ("".equals(s) || null == s || s.length() % 2 != 0) {
            return false;
        }

        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put(')', '(');
        charMap.put('}', '{');
        charMap.put(']', '[');
        int len = s.length();

        Deque<Character> leftCharStack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (charMap.containsKey(c)) {
                if (leftCharStack.isEmpty() || leftCharStack.peek() != charMap.get(c)) {
                    return false;
                }
                leftCharStack.pop();
            } else {
                leftCharStack.push(c);
            }
        }
        return leftCharStack.isEmpty();
    }
}
