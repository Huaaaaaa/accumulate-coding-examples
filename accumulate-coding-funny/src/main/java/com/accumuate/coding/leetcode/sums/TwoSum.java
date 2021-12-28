package com.accumuate.coding.leetcode.sums;

import java.util.Arrays;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/27 4:58 下午
 * @description:
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum.twoSum(nums, target);
        if (ints.length > 0) {
            for (int i : ints) {
                System.out.println(i);
            }
        }

    }

    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        int[] res = new int[2];
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                res[0] = left;
                res[1] = right;
                return res;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
