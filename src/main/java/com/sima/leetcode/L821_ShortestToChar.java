package com.sima.leetcode;

/**
 * Created by qisima on 2/21/2019 3:46 PM
 *
 *  Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
 *
 * Example 1:
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 */
public class L821_ShortestToChar {
    public int[] shortestToChar(String S, char C){
        int[] res = new int[S.length()];
        for (int i = 0; i < res.length; i++) {
            if (S.charAt(i) == C){
                res[i] = 0;
            }else if (i > 0 && res[i-1] != Integer.MAX_VALUE){
                res[i] = res[i-1]+1;
            }else {
                res[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = res.length-2; i >= 0 ; i--) {
            res[i] = Math.min(res[i], 1 + res[i+1]);
        }
        return res;
    }
}
