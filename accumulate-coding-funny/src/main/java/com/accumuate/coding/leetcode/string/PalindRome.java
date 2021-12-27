package com.accumuate.coding.leetcode.string;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/27 10:27 上午
 * @description:
 */
public class PalindRome {

    public static void main(String[] args) {
        PalindRome palindRome = new PalindRome();
        System.out.println(palindRome.isPalindrome(121));
    }

    public boolean isPalindrome(int x) {

        //1.如果时负数，一定不是回文数，直接返回
        if (x < 0) {
            return false;
        }

        //2.临时变量，更新原始值
        int tmp = x;
        //3.存储逆序的原始数
        int reverse = 0;
        //4.循环临时变量，直至0，说明循环完毕
        while (tmp != 0) {
            //4.1 倒转原数：上一个数*10+当前数除以10的余数，即最后一个数
            reverse = reverse * 10 + (tmp % 10);
            //4.2 更新临时值为商
            tmp = tmp / 10;
        }
        //5.如果倒转值与原始值相同说明是回文
        return reverse == x;
    }
}
