package com.sima.leetcode;

import java.util.Arrays;

/**
 * Created by qisima on 12/26/2018 6:15 PM
 */
public class L567_PermutationInString {
    /**
     * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words,
     * one of the first string's permutations is the substring of the second string.
     *
     * Note:
     * The input strings only contain lower case letters.
     * The length of both given strings is in range [1, 10,000].
     * */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        for (char ch : arr1){
            cnt1[ch - 'a']++;
        }
        int i = 0;
        for (; i < arr1.length - 1; i++) {
            cnt2[arr2[i] - 'a']++;
        }
        for (; i < arr2.length; i++){
            cnt2[arr2[i] - 'a']++;
            if (i >= arr1.length) {
                cnt2[arr2[i - arr1.length] - 'a']--;
            }
            if (Arrays.equals(cnt1, cnt2)){
                return true;
            }
        }

        return false;
    }
}
