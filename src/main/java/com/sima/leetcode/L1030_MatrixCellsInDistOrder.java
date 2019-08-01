package com.sima.leetcode;

/**
 * Created by qisima on 7/31/2019 5:26 PM
 */
public class L1030_MatrixCellsInDistOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R*C][2];
        int idx = 0, delta = 0;
        while (idx < R*C){
            for (int i = 0; i <= delta; i++) {
                int j = delta -i;
                if (r0+i < R){
                    if (c0+j < C){
                        res[idx++] = new int[]{r0+i, c0+j};
                    }
                    if (j != 0 && c0-j >= 0){
                        res[idx++] = new int[]{r0+i, c0-j};
                    }
                }
                if (i != 0 && r0-i >= 0){
                    if (c0+j < C){
                        res[idx++] = new int[]{r0-i, c0+j};
                    }
                    if (j != 0 && c0-j >= 0){
                        res[idx++] = new int[]{r0-i, c0-j};
                    }
                }
            }
            delta++;
        }
        return res;
    }

    public static void main(String[] args){
        new L1030_MatrixCellsInDistOrder().allCellsDistOrder(1, 2, 0, 0);
    }
}
