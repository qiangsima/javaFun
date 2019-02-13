package com.sima.leetcode;

/**
 * Created by qisima on 2/13/2019 4:59 PM
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 *
 * Example:
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class L905_SortArrayByParity {
    /**
     * Two pointers: O(N)
     * */
    public int[] sortArrayByParity(int[] A){
        int len = A.length;
        int[] res = new int[len];
        int i = 0, j = len-1;
        for (int c = 0; c < len; c++){
            if (A[c]%2 == 0){
                res[i++] = A[c];
            } else {
                res[j--] = A[c];
            }
        }

        return res;
    }
}
