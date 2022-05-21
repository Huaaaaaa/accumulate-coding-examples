package com.coding.interview.tx;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private static LinkedHashMap<String, String> cache = new LinkedHashMap<>();
    private Map<String, Long> cacheGenerateTime = new HashMap<>();
    private long expire = 5000;
    private int maxSize = 10;

    public static void main(String[] args) {

        LRUCache test = new LRUCache();
        for (int i = 0; i < 11; i++) {
            String key = "key-" + i;
            test.put(key, "val-" + i);
        }

        Iterator<Map.Entry<String, String>> iteratorBefore = cache.entrySet().iterator();
        /*while (iteratorBefore.hasNext()) {
            Map.Entry<String, String> next = iteratorBefore.next();
            System.out.println(next.getKey());
        }
        System.out.println("------------------");
        String s = test.get("key-8");
        test.put("key-11", "val-11");
        Iterator<Map.Entry<String, String>> iteratorAfter = cache.entrySet().iterator();
        while (iteratorAfter.hasNext()) {
            Map.Entry<String, String> next = iteratorAfter.next();
            System.out.println(next.getKey());
        }*/
        Iterator<String> iterator = cache.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("key=" + key);
            System.out.println("value=" + test.get(key));
        }

    }

    public String get(String key) {
        if (cache.containsKey(key)) {
            updateKey(key);
            return cache.get(key);
        }
        return null;
    }


    public void put(String key, String val) {
        if (cache.containsKey(key)) {
            cache.put(key, val);
            updateKey(key);
            return;
        }
        if (cache.size() > maxSize) {
            String first = cache.keySet().iterator().next();
            cache.remove(first);
        }
        cache.put(key, val);
        cacheGenerateTime.put(key, System.currentTimeMillis());
    }


    public void updateKey(String key) {
        String val = cache.get(key);
        if (cacheGenerateTime.containsKey(key)) {
            Long start = cacheGenerateTime.get(key);
            long end = System.currentTimeMillis();
            if (end - start > expire) {
                cache.remove(key);
                return;
            }
        }
        cache.remove(key);
        cache.put(key, val);
    }
}
