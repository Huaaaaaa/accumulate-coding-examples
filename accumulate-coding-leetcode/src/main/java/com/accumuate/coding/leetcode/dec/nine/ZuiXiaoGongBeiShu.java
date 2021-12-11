package com.accumuate.coding.leetcode.dec.nine;

import java.util.Scanner;

/**
 * @author: cyhua
 * @createTime: 2021/12/9
 * @description: 最小公倍数
 */
public class ZuiXiaoGongBeiShu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a * b / gcd(a, b));
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
