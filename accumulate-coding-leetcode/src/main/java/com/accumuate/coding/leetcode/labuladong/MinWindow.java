package com.accumuate.coding.leetcode.labuladong;

import com.accumuate.coding.leetcode.constants.ParamContants;
import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
 * @Author: huayingcao2
 * @DateTime: 2021/6/10  10:04
 * @Description: 滑动窗口方式查询最小子串
 */
public class MinWindow {

    public static void main(String[] args) {
        String source = "ADBECFEBANC";
        String target = "ABC";
        String subStr = minWindow(ParamContants.s, ParamContants.t);
        System.out.println("subStr=" + subStr);
//        System.out.println(Math.pow(10, 5));
//        System.out.println(Integer.MAX_VALUE);

    }

    public static String minWindow(String source, String target) {
        HashMap<String, Integer> window = new HashMap<>();
        HashMap<String, Integer> need = new HashMap<>();
        if (null == target || null == source || target.length() > Math.pow(10, 5)) {
            return null;
        }
        char[] chars = target.toCharArray();
        char[] sources = source.toCharArray();
        for (char c : chars) {
            String key = String.valueOf(c);
            Integer count = need.get(key);
            if (count == null) {
                count = 0;
            }
            need.put(key, ++count);
            window.put(key, 0);
        }
        Integer left = 0, right = 0, valid = 0, len = Integer.MAX_VALUE, start = 0;
        //开始向右滑动窗口
        while (right < source.length()) {
            String foundKey = String.valueOf(sources[right]);
            right++;
            //如果当前字符在需要查找的目标中，并且要找的个数与找到的个数一致，则找到的字符个数加1
            if (need.containsKey(foundKey)) {
                Integer found = window.get(foundKey);
                window.put(foundKey, ++found);
                if (need.get(foundKey) == window.get(foundKey)) {
                    valid++;
                }
            }
            System.out.println("开始滑动窗口：window=" + window + "start=" + start + "len=" + len);
            //开始收缩窗口，收缩条件是已找到所有target中的字符
            while (valid == need.size()) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                String leftKey = String.valueOf(sources[left]);
                left++;
                //如果要收缩的字符不在查找目标中，则继续，否则修改已找到的个数
                if (need.containsKey(leftKey)) {
                    if (need.get(leftKey) == window.get(leftKey)) {
                        valid--;
                    }
                    Integer winCount = window.get(leftKey);
                    window.put(leftKey, --winCount);
                }
                System.out.println("开始收缩窗口：window=" + window + "start=" + start + "len=" + len);
            }

        }

        return len != Integer.MAX_VALUE ? source.substring(start, start + len) : "";
    }
}
