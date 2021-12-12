package com.accumuate.coding.leetcode.linked;

import io.swagger.models.auth.In;
import org.springframework.util.CollectionUtils;
import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * @author: huayingcao
 * @createTime: 2021/12/12 10:45 上午
 * @description: LRU淘汰算法
 */
public class LRUObsolete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] outer = s.split(",");
        String[][] data = new String[outer.length][3];
        for (int o = 0; o < outer.length; o++) {
            String[] inner = outer[o].split(" ");
            data[o] = inner;
        }
        LRUObsolete lruObsolete = new LRUObsolete();
        int[] lru = lruObsolete.LRU(data, 3);
        Arrays.stream(lru).forEach(res -> System.out.println(res));
    }

    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    int cap;

    public int[] LRU(String[][] operators, int k) {
        cap = k;
        int i = 0, j = 0;
        //计算返回长度=查询操作的个数
        int count = (int) Arrays.stream(operators).filter(data -> data[0].equals("2")).count();
        int[] res = new int[count];
        int m = 0;
        for (; i < operators.length; i++) {
            String op = operators[i][0];
            String key = operators[i][1];
            String val = null;
            if (op.equals("1")) {
                val = operators[i][2];
            }

            //set操作
            if (op.equals("2")) {
                int i1 = get(Integer.parseInt(key));
                res[m++] = i1;
            } else if (op.equals("1")) {
                set(Integer.parseInt(key), Integer.parseInt(val));
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
