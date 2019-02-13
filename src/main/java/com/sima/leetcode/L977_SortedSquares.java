package com.sima.leetcode;

/**
 * Created by qisima on 2/13/2019 4:42 PM
 *
 * Given an array of integers A sorted in non-decreasing order,
 * return an array of the squares of each number, also in sorted non-decreasing order.
 *
 * Example:
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 */
public class L977_SortedSquares {
    /**
     * Two pointers: O(N)
     * */
    public int[] sortedSquares(int[] A){
        int len = A.length;
        int[] res = new int[len];
        int i = 0, j = len-1;
        for (int p = len-1; p >= 0; p--){
            if (Math.abs(A[i]) > Math.abs(A[j])){
                res[p] = A[i] * A[i];
                i++;
            } else {
                res[p] = A[j] * A[j];
                j--;
            }
        }

        return res;
    }
}
