package com.accumuate.coding.leetcode.shoppe;

import java.util.HashMap;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/17 6:17 下午
 * @Description: 最长无重复子序列
 */
public class MaxSub {

    public static void main(String[] args) {
        int[] data = {1, 3, 4, 5, 2, 1, 2, 3, 4};
        int length = maxLengthWithDoublePoint(data);
        System.out.println(length);

    }

    public static int maxLengthWithDoublePoint(int[] arr){
        // write code here
        if(arr.length < 2){
            return arr.length;
        }

        HashMap<Integer, Integer> windows = new HashMap<>();
        int res = 0;
        //用双指针来模拟一个滑动窗口
        int left = -1;
        //窗口向右滑动
        for(int right = 0; right < arr.length; right++){
            //遇到重复数字
            if(windows.containsKey(arr[right])){
                //因为有可能遇到的重复数字的位置 比 left还要前
                //所以不能把left置于该位置前一位， 而是比较哪个最大，目的还是为了缩小窗口
                //确保窗口内全是不重复的数字
                left = Math.max(left, windows.get(arr[right]));
            }
            //每次更新窗口大小
            res = Math.max(res, right-left);
            //将数字位置更新到windows中
            windows.put(arr[right], right);
        }
        return res;
    }


    public static int maxLength(int[] arr) {
        // write code here
        int len = arr.length;
        if (len == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            int maxi = 0;
            for (int j = i; j < len - 1; j++) {
                if (arr[j] + 1 <= arr[j + 1]) {
                    ++maxi;
                    max = Math.max(max, maxi == 0 ? maxi : maxi + 1);
                } else if (arr[j] == arr[j + 1]) {
                    ++maxi;
                    max = Math.max(max, maxi);
                    i = j;
                    break;
                } else {
                    i = j;
                    break;
                }
            }
        }
        return max;
    }
}
