package com.sima.leetcode;

import java.util.Arrays;

/**
 * Created by qisima on 7/31/2019 4:50 PM
 */
public class L1051_HeightChecker {
    public int heightChecker(int[] heights) {
        int[] arr = Arrays.copyOf(heights, heights.length);
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != heights[i]){
                res++;
            }
        }
        return res;
    }
}
