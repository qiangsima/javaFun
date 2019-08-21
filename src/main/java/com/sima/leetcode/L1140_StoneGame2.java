package com.sima.leetcode;

import java.util.Arrays;

/**
 * Created by qisima on 8/21/2019 6:30 PM
 */
public class L1140_StoneGame2 {
    public int stoneGameII(int[] piles) {
        int[] sums = new int[piles.length];
        int sum = 0;
        for (int i = piles.length - 1; i >= 0; i--) {
            sum += piles[i];
            sums[i] = sum;
        }
        int[][] dict = new int[piles.length][piles.length];

        return helper(0, 1, sums, dict);
    }

    private int helper(int idx, int m, int[] sums, int[][] dict) {
        if (dict[idx][m] > 0){
            return dict[idx][m];
        } else if (2*m + idx >= sums.length){
            dict[idx][m] = sums[idx];
        } else {
            int max = 0;
            for (int i = 1; i <= 2*m; i++) {
                max = Math.max(sums[idx]- helper(idx+i, Math.max(m, i), sums, dict), max);
            }
            dict[idx][m] = max;
        }
        return dict[idx][m];
    }
}
