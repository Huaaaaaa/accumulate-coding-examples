package com.coding.interview.hw;

import java.util.Scanner;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/15 12:03 下午
 * @Description: 分糖果，求最少次数
 */
public class Candy {

    public static void main(String[] args) {
        Candy candy = new Candy();
        int shareTime = 0;
        Scanner scanner = new Scanner(System.in);
        int candyCount = scanner.nextInt();
        shareTime = candy.shareCandy(candyCount, shareTime);
        System.out.println("shareTime=" + shareTime);
    }


    public int shareCandy(int candyCount, int shareTime) {
        int mod = candyCount % 2;
        if (mod != 0) {
            candyCount = candyCount + mod;
            shareTime += mod;
        }
        candyCount = candyCount / 2;
        shareTime = shareTime + 1;
        if (candyCount == 2) {
            shareTime = shareTime + 1;
            candyCount = 1;
        }

        if (candyCount == 1) {
            return shareTime;
        }
        return shareCandy(candyCount, shareTime);
    }

}
