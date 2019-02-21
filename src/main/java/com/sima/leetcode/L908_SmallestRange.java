package com.sima.leetcode;

/**
 * Created by qisima on 2/21/2019 11:36 AM
 *
 * Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
 * After this process, we have some array B.
 * Return the smallest possible difference between the maximum value of B and the minimum value of B.
 *
 * Example:
 * Input: A = [1,3,6], K = 3
 * Output: 0
 * Explanation: B = [3,3,3] or B = [4,4,4]
 */
public class L908_SmallestRange {
    public int smallestRange(int[] A, int K) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }
        int gap = max - min;
        if (gap > 2*K){
            return gap - 2*K;
        }
        return 0;
    }
}
