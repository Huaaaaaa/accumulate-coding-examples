package com.accumuate.coding.leetcode.string;

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
        //int res = stringToInteger.myAtoi("-2147483647");
        // int res = stringToInteger.myAtoi("2147483646");
        //int res = stringToInteger.myAtoi("-91283472332");
        int res = stringToInteger.myAtoi("21474836460");
        System.out.println(res);
    }

    public int myAtoi(String s) {
        //1、先去掉头部空格：需要循环去
        while (s.startsWith(" ")) {
            s = s.substring(s.indexOf(" ") + 1);
        }
        //2、如果去掉空格还为空串，则直接返回0
        if ("".equals(s)) {
            return 0;
        }
        //3、分隔成字符数组并判断第一个字符是否为符号位，如果时符号位，有效为从下标1开始
        char[] chars = s.toCharArray();
        boolean isNegative = chars[0] == '-';
        int i = 0;
        if (chars[0] == '+' || chars[0] == '-') {
            i = 1;
        }
        //4、遍历字符数组，遇到第一个非数字字符时直接截取该字符之前的
        for (int j = i; j < chars.length; j++) {
            if ('0' > chars[j] || chars[j] > '9') {
                s = s.substring(i, j);
                break;
            }
        }

        //5、初始化：结果data=0,符号位为-1或1
        int data = 0;
        int sign = isNegative ? -1 : 1;
        if (s.length() > 0) {
            int size = s.length();
            char[] chars1 = s.toCharArray();
            //6、开始遍历有效的字符串
            for (int j = 0; j < size; j++) {
                //6.1 取出当前字符
                char currChar = chars1[j];
                //6.2 判断当前结果是否超出整型最大值:当前值大于214748364，或等于214748364且当前的数字大于整型最大值除以10后的余数，即7
                if (data > Integer.MAX_VALUE / 10 || (data == Integer.MAX_VALUE / 10 && (currChar - '0') > 7)) {
                    return Integer.MAX_VALUE;
                }
                //6.3 判断当前结果是否超出整型最小值：当前值小于-214748364，或等于-214748364且当前的数字小于整型最小值除以10后的余数，即-8
                if (data < Integer.MIN_VALUE / 10 || (data == Integer.MIN_VALUE / 10 && (currChar - '0') < -8)) {
                    return Integer.MIN_VALUE;
                }

                //6.4 当前值不越界的情况下，计算新值：旧值*10+符号位*（当前字符-0）
                data = data * 10 + sign * (currChar - '0');
            }
        }

        return data;
    }
}
