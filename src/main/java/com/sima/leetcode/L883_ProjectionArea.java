package com.sima.leetcode;

/**
 * Created by qisima on 2/21/2019 11:06 AM
 */
public class L883_ProjectionArea {
    public int projectionArea(int[][] grid){
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0){
                    res++;
                    if (grid[i][j] > max){
                        max = grid[i][j];
                    }
                }
            }
            res += max;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] > max){
                    max = grid[j][i];
                }
            }
            res += max;
        }
        return res;
    }
}
