package com.accumuate.coding.leetcode.basic;

import com.accumuate.coding.leetcode.BaseArray;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;

/**
 * @author: huayingcao
 * @createTime: 2021/12/11 1:05 下午
 * @description: 两数之和
 */
public class TwoSum extends BaseArray {

    public static void main(String[] args) {
        int[] data = getArray();
        int[] res = map(data, 20);
        System.out.println(CollectionUtils.arrayToList(res));
    }


    /**
     * 暴力法
     *
     * @param data
     * @return
     */
    public static int[] force(int[] data, int target) {
        int[] res = new int[2];
        int length = data.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (data[i] + data[j] == target) {
                    if (i > j) {
                        res[0] = j + 1;
                        res[1] = i + 1;
                    } else {
                        res[0] = i + 1;
                        res[1] = j + 1;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 通过map方式处理
     *
     * @param data
     * @param target
     * @return
     */
    public static int[] map(int[] data, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = data.length;
        for (int i = 0; i < length; i++) {
            int sub = target - data[i];
            if (map.get(sub) != null) {
                return new int[]{map.get(sub) + 1, i + 1};
            }
            map.put(data[i], i);
        }
        return new int[]{0, 0};
    }
}
