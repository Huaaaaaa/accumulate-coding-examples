package com.coding.interview.algo;

import java.util.Scanner;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/14 3:43 下午
 * @Description:
 */
public class MaxSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int length = s1.length;
        int[] data = new int[length];
        int i = 0;
        while (i < length) {
            data[i] = Integer.parseInt(s1[i]);
            i++;
        }

        int sum = 0;
        for (int j = 0; j < length; j++) {
            if (data[j] <= 0 || data[j] + data[j - 1] < 0) {
                continue;
            }
            System.out.println("j=" + j);
            sum += data[j];
        }

        System.out.println(sum);
    }
}
