package com.accumuate.coding.leetcode.sort;

import org.springframework.util.CollectionUtils;

import java.util.Scanner;

/**
 * @author: huayingcao
 * @createTime: 2021/12/11 12:12 下午
 * @description: 归并排序
 * 第一步：先将待排序列表进行拆分，分成只有一个元素的列表（分成二叉树）
 * 第二步：对每一颗子树进行排序
 * 第三步：合并最后的两个已经排好序的列表
 */
public class MergeSort {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("please input");
        String src = scanner.nextLine();
        String[] srcString = src.split(" ");
        int length = srcString.length;
        int[] data = new int[length];
        for (int i = 0; i < length; i++) {
            data[i] = Integer.parseInt(srcString[i]);
        }
        int[] tmp = new int[length];
        int[] res = mergeSort(data, 0, length - 1, tmp);
        System.out.println(CollectionUtils.arrayToList(res));

    }

    public static int[] mergeSort(int[] data, int left, int right, int[] tmp) {
        if (left < right) {
            //注意中点的获取方法
            int mid = (left + right) / 2;
            mergeSort(data, left, mid, tmp);
            mergeSort(data, mid + 1, right, tmp);
            merge(data, left, mid, right, tmp);
        }
        return data;
    }


    public static int[] merge(int[] data, int left, int mid, int right, int[] tmp) {
        //左边数组开始位置指针：第1个
        int i = left;
        //右边数组开始位置指针：第mid+1个
        int j = mid + 1;
        //临时数组开始指针
        int t = 0;
        while (i <= mid && j <= right) {
            if (data[i] < data[j]) {
                //当左边数组的第一个元素比右边数组第一个小时，将左边第一个移入临时数组
                tmp[t++] = data[i++];
            } else {
                //当左边数组的第一个元素比右边数组第一个大时，将右边第一个移入临时数组
                tmp[t++] = data[j++];
            }
        }
        //当右边数组先遍历完时，将左边数组中剩下的元素移入临时数组
        while (i <= mid) {
            tmp[t++] = data[i++];
        }
        //当左边数组先遍历完时，将🈶️边数组中剩下的元素移入临时数组
        while (j <= right) {
            tmp[t++] = data[j++];
        }
        //将临时数组中的数据移入原始数据
        t = 0;
        while (left <= right) {
            data[left++] = tmp[t++];
        }

        return data;
    }


}
