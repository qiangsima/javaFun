package com.sima.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qisima on 2/27/2019 4:33 PM
 */
public class L893_SpecialEquivalentStrings {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for( String str : A){
            int[] arr = new int[26*2];
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                arr[2*(ch-'a')+(i%2)]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
