package com.sima.leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by qisima on 4/30/2019 4:44 PM
 */
public class L888_FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B){
        int sum1 = 0, sum2 = 0;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            sum1 += a;
        }
        for (int b : B) {
            sum2 += b;
            set.add(b);
        }
        int eva = (sum1 + sum2) / 2;
        int gap = sum1 - eva;
        for (int num : A) {
            if (set.contains(num-gap)){
                return new int[]{num, num-gap};
            }
        }
        return new int[]{A[0], B[0]};
    }
}
