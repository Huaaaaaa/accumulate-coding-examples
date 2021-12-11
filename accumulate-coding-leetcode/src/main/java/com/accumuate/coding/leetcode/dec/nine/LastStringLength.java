package com.accumuate.coding.leetcode.dec.nine;

import java.util.Scanner;

/**
 * @author: cyhua
 * @createTime: 2021/12/9
 * @description:
 */
public class LastStringLength {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String src = scanner.nextLine();
            int len = 0;
            for (int i = src.length() - 1; i >= 0; i--) {
                String letter = String.valueOf(src.charAt(i));
                if (" ".equals(letter)) {
                    break;
                }
                len++;
            }
            System.out.println(len);
        }
    }
}
