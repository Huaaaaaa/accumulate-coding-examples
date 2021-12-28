package com.accumuate.coding.leetcode.sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/27 4:40 下午
 * @description:
 */
public class FourSum {

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] testCase = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum.fourSum(testCase, target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 4) {
            return lists;
        }
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int tar = target - nums[i];
            threeSum(nums[i], nums, tar, lists);
        }

        return lists;
    }

    public void threeSum(int four, int[] nums, int target, List<List<Integer>> lists) {
        for (int three = four + 1; three < nums.length - 2; three++) {
            int left = three + 1;
            int right = nums.length - 1;
            int tar = target - nums[three];
            twoSum(left, right, nums[three], four, tar, nums, lists);

        }
    }

    public void twoSum(int left, int right, int three, int four, int target, int[] nums, List<List<Integer>> lists) {
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                lists.add(Arrays.asList(nums[left], nums[right], three, four));
                left++;
                right--;
                while (left < right && nums[left - 1] == nums[left]) left++;
                while (left < right && nums[right] == nums[right + 1]) right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
    }

}
