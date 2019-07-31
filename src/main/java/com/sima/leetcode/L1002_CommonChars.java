package main.java.com.sima.leetcode;

import java.util.*;

/**
 * Created by qisima on 7/1/2019 12:54 PM
 */
public class L1002_CommonChars {
    public List<String> commonChars(String[] A){
        List<String> res = new ArrayList<>();
        if (A == null || A.length < 1)return res;

        Map<Character, Integer> map = toMap(A[0]);
        for (int i = 1; i < A.length; i++){
            Map<Character, Integer> m = toMap(A[i]);
            Iterator<Character> iter = map.keySet().iterator();
            Set<Character> set = new HashSet<>();
            while (iter.hasNext()){
                Character key = iter.next();
                if (m.containsKey(key)){
                    map.put(key, Math.min(m.get(key), map.get(key)));
                }else{
                    set.add(key);
                }
            }
            iter = set.iterator();
            while(iter.hasNext()){
                map.remove(iter.next());
            }
        }

        Iterator<Character> iter = map.keySet().iterator();
        while (iter.hasNext()){
            Character key = iter.next();
            for (int i = 0; i < map.get(key); i++) {
                res.add(String.valueOf(key));
            }
        }

        return res;
    }

    private Map<Character, Integer> toMap(String str){
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        return map;
    }
}
