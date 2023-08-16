package org.example.algorithm.lru;

import java.util.LinkedHashMap;

public class LRUCache<K, V> extends LinkedHashMap {

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> cache = new LinkedHashMap<>(16, (float) 0.75, true);
        for (int i = 0; i < 10; i++) {
            cache.put("k" + i, i);
        }
        System.out.println("catch1: " + cache);
        cache.get("k2");
        System.out.println("catch2: " + cache);
        System.out.println("catch.size: " + cache.size());
        cache.put("k10", 10);
        System.out.println("catch3: " + cache);
        System.out.println("catch.size1: " + cache.size());
    }
}
