package com.accumuate.coding.leetcode.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: cyhua
 * @createTime: 2021/12/11
 * @description: 快速排序
 * 第一步：找到基准值，初始值为第一个值
 * 第二步：从右端开始往前遍历比较，当右边值大于基准值时，高位指针往前移动；否则将高位值赋值给低位，替换原来基准值
 * 第三步：从左端开始往后遍历比较，当左边值小于基准值时，低位指针往后移动；否则将低位值赋值给高位,替换原来高位值
 */
public class QuickSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input");
        String src = scanner.nextLine();
        String[] srcString = src.split(" ");
        int length = srcString.length;
        int[] number = new int[length];
        for (int i = 0; i < length; i++) {
            number[i] = Integer.parseInt(srcString[i]);
        }

        //System.out.println("pre:" + getPre(number, 2));
        Arrays.sort(number);

        int[] ints = quickSort(number, 0, length - 1);
        ArrayList<Integer> collect = (ArrayList<Integer>) Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println(collect.subList(0, 3));
    }

    public static int[] quickSort(int[] data, int low, int high) {
        if (low < high) {
            int index = getIndex(data, low, high);
            quickSort(data, low, index - 1);
            quickSort(data, index + 1, high);
        }
        return data;
    }

    public static int getIndex(int[] data, int low, int high) {
        int tmp = data[low];
        while (low < high) {
            //从后往前遍历，如果高位大于基准值，则高位指针左移
            while (low < high && data[high] >= tmp) {
                high--;
            }
            //否则高位大于基准值，则将高位的值赋值给低位（临时值）
            data[low] = data[high];

            //然后从前往后遍历，如果低位值小于基准值，则低位指针右移
            while (low < high && data[low] <= tmp) {
                low++;
            }
            //否则低位大于基准值，则将低位的值赋值给高位
            data[high] = data[low];
        }
        //将基准值赋值给低位
        data[low] = tmp;
        //基准值即为low的指针
        return low;
    }

    public static List<Integer> getPre(int[] data, int k) {
        Arrays.sort(data);
        List<Integer> collect = Arrays.stream(data).boxed().collect(Collectors.toList());
        return collect.subList(0, k);
    }
}
