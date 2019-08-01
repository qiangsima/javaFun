package com.sima.leetcode;

/**
 * Created by qisima on 7/31/2019 4:58 PM
 */
public class L1122_RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        int[] cnts = new int[1001];
        for (int item : arr1) {
            cnts[item]++;
        }
        int idx = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (cnts[arr2[i]] != 0){
                res[idx++] = arr2[i];
                cnts[arr2[i]]--;
            }
        }
        for (int i = 0; i < cnts.length; i++) {
            while (cnts[i] != 0){
                res[idx++] = i;
                cnts[i]--;
            }
        }
        return res;
    }
}
