package com.accumuate.coding.leetcode.linked;

import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * @author: huayingcao
 * @createTime: 2021/12/12 12:37 下午
 * @description:
 */
public class LRUCache {

    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    int cap;

    public static void main(String[] args) {
        int[][] data = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        LRUCache lruCache = new LRUCache();
        int[] lru = lruCache.LRU(data, 3);
        Arrays.stream(lru).forEach(e-> System.out.println(e));
    }

    public int[] LRU(int[][] operators, int k) {
        cap = k;
        int i = 0, j = 0;
        //计算返回长度=查询操作的个数
        int count = (int) Arrays.stream(operators).filter(data -> data[0] == 2).count();
        int[] res = new int[count];
        int m = 0;
        for (; i < operators.length; i++) {
            int op = operators[i][0];
            int key = operators[i][1];
            int val = -1;
            if (op == 1) {
                val = operators[i][2];
            }

            //set操作
            if (op == 2) {
                int i1 = get(key);
                res[m++] = i1;
            } else if (op == 1) {
                set(key, val);
            } else {
                return res;
            }
        }
        return res;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        recentlyUsed(key);
        return cache.get(key);
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            recentlyUsed(key);
            return;
        }
        if (cache.size() >= cap) {
            Integer head = cache.keySet().iterator().next();
            cache.remove(head);
        }
        cache.put(key, value);
    }

    public void recentlyUsed(int key) {
        Integer val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}
