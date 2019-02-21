package com.sima.leetcode;

/**
 * Created by qisima on 2/21/2019 11:49 AM
 */
public class L867_TransposeMatrix {
    public int[][] transpose(int[][] A){
        int[][] res = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }
}
