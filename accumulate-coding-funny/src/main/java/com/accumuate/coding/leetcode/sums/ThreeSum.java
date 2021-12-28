package com.accumuate.coding.leetcode.sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/27 3:20 下午
 * @description: 三数之和
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] testCase = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum.threeSum(testCase));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        if (len < 3) {
            return lists;
        }

        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            //跳过已经计算过的
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int target = -nums[i];
            int left = i + 1;
            int right = len - 1;
            twoSum(left, right, nums[i], target, nums, lists);
        }
        return lists;
    }

    public void twoSum(int left, int right, int first, int target, int[] nums, List<List<Integer>> lists) {
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                lists.add(Arrays.asList(nums[left], nums[right], first));
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
