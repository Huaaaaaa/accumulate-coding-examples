package com.accumuate.coding.leetcode.string;

import com.sun.xml.internal.ws.wsdl.writer.UsingAddressing;

import java.util.Arrays;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/26 8:15 下午
 * @description: 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数 myAtoi(string s) 的算法如下：
 * <p>
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 */
public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        int res = stringToInteger.myAtoi("-2147483647");
        //int res = stringToInteger.myAtoi("-91283472332");
        System.out.println(res);
    }

    public int myAtoi(String s) {
        while (s.startsWith(" ")) {
            s = s.substring(s.indexOf(" ") + 1);
        }
        if ("".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        boolean isNegative = chars[0] == '-';
        int i = 0;
        if (chars[0] == '+' || chars[0] == '-') {
            i = 1;
        }
        StringBuilder number = new StringBuilder();
        for (; i < chars.length; i++) {
            if ('0' <= chars[i] && chars[i] <= '9') {
                number.append(chars[i]);
            } else {
                break;
            }
        }

        String s1 = number.toString();
        int data = 0;
        if (s1 != null && s1.length() > 0) {
            int size = s1.length();
            char[] chars1 = s1.toCharArray();
            int pow = size;
            for (int j = 0; j < size; j++) {
                int numericValue = isNegative ? -Character.getNumericValue(chars1[j]) : Character.getNumericValue(chars1[j]);
                data += numericValue * Math.pow(10, pow);
                if (isNegative && data <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                if (data - 1 >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }
        }

        return data;
    }
}
