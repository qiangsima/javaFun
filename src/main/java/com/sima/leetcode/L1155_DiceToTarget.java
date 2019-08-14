package com.sima.leetcode;

import java.util.Arrays;

/**
 * Created by qisima on 8/13/2019 6:22 PM
 */
public class L1155_DiceToTarget {
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dict = new int[d+1][];
        for (int i = 0; i < dict.length; i++) {
            dict[i] = new int[target+1];
            Arrays.fill(dict[i], 0);
        }

        for (int i = 1; i <= f && i <= target; i++) {
            dict[1][i] = 1;
        }

        for (int i = 2; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                int res = 0;
                for (int k = 1; k <= f && k <= j; j++) {
                    res += dict[i-1][j-k];
                    res %= 1000000007;
                }
                dict[i][j] = res;
            }
        }
        return dict[d][target];
    }
}
