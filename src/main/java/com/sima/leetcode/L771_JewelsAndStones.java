package com.sima.leetcode;

import java.util.*;

/**
 * Created by {USER} on {DATE} {TIME}
 */
public class L771_JewelsAndStones {
    public int numJewelsInStones(String J, String S){
        char[] jarr = J.toCharArray();
        char[] sarr = S.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char ch : jarr){
            set.add(ch);
        }
        int res = 0;
        for (int i = 0; i < sarr.length; i++){
            if (set.contains(sarr[i])){
                res++;
            }
        }
        return res;
    }
}
