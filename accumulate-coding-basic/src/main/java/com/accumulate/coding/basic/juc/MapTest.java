package com.accumulate.coding.basic.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: cyhua
 * @createTime: 2021/11/16
 * @description:
 */
public class MapTest {

    public static void main(String[] args) {
        MapTest mapTest = new MapTest();
        mapTest.testHashMap();
        mapTest.testProperties();

        String s = "h";
        System.out.println("s.hashCode=" + s.hashCode());
    }

    public void testHashMap() {
        HashMap<String, String> hashMap = new HashMap<>(6);
        hashMap.put("k1", "v1");
        hashMap.put("k2", "v2");
        hashMap.put("k3", "v3");
        hashMap.put("k4", "v4");
        hashMap.put("k5", "v5");
        hashMap.put("k6", "v6");
        String v1 = hashMap.remove("k1");
        System.out.println(v1);
        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println("key=" + next.getKey() + ";value=" + next.getValue());
        }
    }

    public void testHashtable() {
        Map<String, String> hashtable = new Hashtable<>(4);
        hashtable.put("k1", "v1");
        hashtable.put("k2", "v2");
        hashtable.put("k3", "v3");
        hashtable.put("k4", "v4");
        hashtable.put("k5", "v5");
        hashtable.put("k6", "v6");
        String v1 = hashtable.remove("k1");
        System.out.println(v1);
        Iterator<Map.Entry<String, String>> iterator = hashtable.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println("key=" + next.getKey() + ";value=" + next.getValue());
        }
    }

    public void testProperties() {
        Properties properties = new Properties();
        properties.put("user", "zhangsan");
        properties.put("age", 20);
        properties.put("sex", "female");
        System.out.println("testProperties=" + properties);
    }

    public void testConcurrentHashMap() {
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("k1", "v1");
        concurrentHashMap.put("k2", "v2");
        concurrentHashMap.put("k3", "v3");
        concurrentHashMap.put("k4", "v4");
        concurrentHashMap.put("k5", "v5");
        concurrentHashMap.put("k6", "v6");
        String v1 = concurrentHashMap.remove("k1");
        System.out.println(v1);
        Iterator<Map.Entry<String, String>> iterator = concurrentHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println("key=" + next.getKey() + ";value=" + next.getValue());
        }
    }
}
