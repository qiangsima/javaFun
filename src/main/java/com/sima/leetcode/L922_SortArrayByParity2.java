package com.sima.leetcode;

/**
 * Created by qisima on 2/14/2019 4:04 PM
 *
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * You may return any answer array that satisfies this condition.
 *
 * Example:
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 */
public class L922_SortArrayByParity2 {
    public int[] sortArrayByParity2(int[] A){
        int n = A.length;
        int odd = 1, even = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (A[i]%2 == 0){
                res[even] = A[i];
                even += 2;
            } else {
                res[odd] = A[i];
                odd += 2;
            }
        }

        return res;
    }
}
