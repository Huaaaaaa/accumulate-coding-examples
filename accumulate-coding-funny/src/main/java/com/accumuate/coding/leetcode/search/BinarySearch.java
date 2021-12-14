package com.accumuate.coding.leetcode.search;

import com.accumuate.coding.leetcode.BaseArray;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/14 9:46 上午
 * @Description: 二分查找算法
 */
public class BinarySearch extends BaseArray {

    public static void main(String[] args) {
        int[] array = getArray();
        System.out.println("find:"+find(array, 5));
        System.out.println("findRecurve:"+findRecurve(array, 5,array.length-1,5));
    }


    /**
     * while循环法
     * @param numbers
     * @param target
     * @return
     */
    public static int find(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            int middle = numbers[mid];
            if (middle == target) {
                return mid;
            } else if (target < middle) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归法
     * @param numbers
     * @param low
     * @param high
     * @param target
     * @return
     */
    public static int findRecurve(int[] numbers, int low, int high, int target) {
        if (low < high)
            return -1;
        int mid = low + ((high - low) >> 2);
        if (numbers[mid] == target) {
            return mid;
        } else if (target > numbers[mid]) {
            return findRecurve(numbers, mid + 1, high, target);
        } else {
            return findRecurve(numbers, low, mid - 1, target);
        }
    }
}
