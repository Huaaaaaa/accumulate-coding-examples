package com.accumuate.coding.leetcode.string;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/27 12:23 下午
 * @description:
 */
public class CommonPrefix {

    public static void main(String[] args) {
        CommonPrefix commonPrefix = new CommonPrefix();
        String[] strs = {"aaa", "aa", "aaa"};
        System.out.println(commonPrefix.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int size = strs.length;
        //刚开始让第一个元素作为前缀
        String prefix = strs[0];
        //从第二个元素开始遍历
        for (int i = 1; i < size; i++) {
            //取出较短的长度，来决定寻找公共前缀的最大遍历长度
            int min = Math.min(strs[i].length(), prefix.length());
            char[] currArray = strs[i].toCharArray();
            char[] prefixArray = prefix.toCharArray();
            int j = 0;
            for (; j < min; j++) {
                char c = prefixArray[j];
                char c1 = currArray[j];
                //比较字符，如果不相同则比较下一个
                if (c != c1) {
                    break;
                }
            }
            //每比较完一个字符串，都要更新前缀，然后与下一个元素进行比较
            prefix = prefix.substring(0, j);

        }
        return prefix;
    }
}
