package com.sima.leetcode;

import java.util.Arrays;

/**
 * Created by qisima on 1/13/2019 4:41 PM
 */
public class L961_NRepeatedElements {
    /**
     * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
     * Return the element repeated N times.
     * Note:
     * 4 <= A.length <= 10000
     * 0 <= A[i] < 10000
     * A.length is even
     * */
    public int repeatedNTimes(int[] A) {
        int n = A.length / 2;
        Arrays.sort(A);
        if (A[n] == A[n-1])return A[n];
        else return A[n+1];
    }

    /**
     * 时间复杂度O(N),空间复杂度O(1)
     * */
    public int repeatedNTimes2(int[] A) {
        for (int i=0; i<A.length-2; i++)
            if (A[i] == A[i+1] || A[i] == A[i+2])
                return A[i];
        return A[A.length-1];
    }
}
