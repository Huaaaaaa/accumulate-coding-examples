package com.accumuate.coding.leetcode.sort;

import java.util.Arrays;

/**
 * @Author: huahaha
 * @DateTime: 2021/4/21  11:33
 * @Description: 冒泡排序：比较相邻两个元素的大小，并交换为位置
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 *
 */
public class BubbleSort extends BaseSort {

    public static void main(String[] args) {
        bubbleSort(data());
    }


    public static void bubbleSort(Integer[] data) {
        System.out.println("before sorting:data=" + Arrays.asList(data));
        for (int i = 0; i < data.length-1; i++) {
            for (int j = data.length-1; j >i; j--) {
                if (data[j] < data[j-1]) {
                    int tmp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = tmp;
                }
            }
        }
        System.out.println("after sorting:data=" + Arrays.asList(data));
    }

}
