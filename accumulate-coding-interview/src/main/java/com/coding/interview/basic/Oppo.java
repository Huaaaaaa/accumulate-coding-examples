package com.coding.interview.basic;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/29 8:01 下午
 * @description:
 */
public class Oppo {

    public static void main(String[] args) {
        HashMap<String, Long> map = new HashMap<>();
        map.put("key1", 2000L);
        long v2 = map.get("key2");
        System.out.println(v2);
    }
}
