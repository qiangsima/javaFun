package com.sima.leetcode;

import java.util.*;

/**
 * Created by qisima on 2/28/2019 3:31 PM
 */
public class L884_UncommonWords {
    public String[] uncommonFromSentences(String A, String B){
        String[] arr1 = A.split(" ");
        String[] arr2 = B.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String str : arr1){
            map.put(str, map.getOrDefault(str, 0)+1);
        }
        for (String str : arr2){
            map.put(str, map.getOrDefault(str, 0)+1);
        }
        Set<String> set = new HashSet<>();
        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()){
            String key = iter.next();
            if (map.get(key) == 1){
                set.add(key);
            }
        }

        return set.toArray(new String[0]);
    }
}
