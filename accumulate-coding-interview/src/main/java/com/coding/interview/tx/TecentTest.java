package com.coding.interview.tx;

import java.util.Scanner;

/**
 * @author: me
 * @createTime: 2021/12/20 8:22 下午
 * @description: 样例1:
 * [输入]
 * 3c8-8c-Ea-S-a886-99-ReSTaRT, 4
 * [输出]
 * 3-C88C-EASA-8869-9RES-TART
 */
public class TecentTest {

    public static void main(String[] args) {
        String format = format("3c8-8c-Ea-S-a886-99-ReSTaRT-fs", 4);
        System.out.println(format);
    }

    public static String format(String data, int k) {
        if (data.contains("-")) {
            data = data.replaceAll("-", "").toUpperCase();
        }
        int length = data.length();
        int firstIndex = length % k;
        if (firstIndex == 0) {
            firstIndex = k;
        }
        StringBuffer temp = new StringBuffer();
        int begin = 0;
        for (int i = firstIndex; i <= length; i = i + k) {
            if (i != length) {
                temp.append(data.substring(begin, i)).append("-");
            } else {
                temp.append(data.substring(begin, i));
            }

            begin = i;
        }
        /*String s = temp.toString();
        if (s.endsWith("-")) {
            s = s.substring(0, s.lastIndexOf("-"));
        }*/
        return temp.toString();
    }
}
