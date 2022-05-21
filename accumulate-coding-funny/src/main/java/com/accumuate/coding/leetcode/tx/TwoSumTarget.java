package com.accumuate.coding.leetcode.tx;

import io.swagger.models.auth.In;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/24 7:35 上午
 * @description:
 */
public class TwoSumTarget {

    public static void main(String[] args) {
        TwoSumTarget target = new TwoSumTarget();
        int[] num = {3, 2, 4};
        int[] res = target.twoSum(num, 6);
        Arrays.stream(res).forEach(System.out::println);
    }

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
