package com.sima.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qisima on 3/1/2019 2:06 PM
 */
public class L575_DistributeCandies {
    public int distributeCandies(int[] candies){
        Set<Integer> set = new HashSet<>();
        for (int can : candies){
            set.add(can);
        }
        return Math.min(set.size(), candies.length/2);
    }
}
