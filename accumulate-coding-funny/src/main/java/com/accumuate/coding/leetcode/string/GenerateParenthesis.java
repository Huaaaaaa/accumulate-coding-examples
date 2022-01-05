package com.accumuate.coding.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/5 2:55 下午
 * @description: 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> strings = gp.generateParenthesis(2);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        generate(result, 0, 0, n, new StringBuffer());
        return result;
    }


    public void generate(List<String> data, int open, int close, int n, StringBuffer ele) {
        if (ele.length() == 2 * n) {
            data.add(ele.toString());
        }
        if (open < n) {
            ele.append("(");
            generate(data, open + 1, close, n, ele);
            ele.deleteCharAt(ele.length() - 1);
        }

        if (close < open) {
            ele.append(")");
            generate(data, open, close + 1, n, ele);
            ele.deleteCharAt(ele.length() - 1);
        }
    }


}
