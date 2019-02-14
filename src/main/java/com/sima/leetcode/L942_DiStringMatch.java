package com.sima.leetcode;

/**
 * Created by qisima on 2/14/2019 3:31 PM
 *
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 *
 * Example:
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 */
public class L942_DiStringMatch {
    public int[] diStringMatch(String S){
        int n = S.length();
        int lo = 0, hi = n;
        int[] res = new int[n+1];
        for (int i = 0; i < n; i++){
            if (S.charAt(i) == 'I'){
                res[i] = lo++;
            } else {
                res[i] = hi--;
            }
        }
        res[n] = lo;

        return res;
    }
}
