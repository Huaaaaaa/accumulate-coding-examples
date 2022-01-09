package com.accumuate.coding.leetcode.sort;

import java.util.Arrays;

/**
 * @author: cyhua
 * @createTime: 2021/12/9
 * @description: 选择排序：先选出最大值或最小值，然后依此与其他的元素进行比较，并交换位置
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
public class SelectSort extends BaseSort {

    public static void main(String[] args) {
        quickSort(data());
    }

    public static void quickSort(Integer[] data) {
        System.out.println("before quickSort:data=" + Arrays.asList(data));
        for (int i = 0; i < data.length; i++) {
            int min = i;
            //先找出最小的元素
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            //将最小元素与剩下的第一个元素进行交换
            int tmp = data[i];
            data[i] = data[min];
            data[min] = tmp;
        }
        System.out.println("after quickSort:data=" + Arrays.asList(data));
    }
}
