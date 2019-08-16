package com.sima.leetcode;

/**
 * Created by qisima on 8/15/2019 5:57 PM
 */
public class L1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] arr = new int[text1.length()][text2.length()];
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        arr[0][0] = arr1[0] == arr2[0]? 1 : 0;
        for (int i = 1; i < arr2.length; i++) {
            arr[0][i] = arr[0][i-1] == 1 || arr1[0] == arr2[i] ? 1 : 0;
        }
        for (int i = 1; i < arr1.length; i++) {
            arr[i][0] = arr[i-1][0] == 1 || arr1[i] == arr2[0] ? 1 : 0;
        }
        for (int i = 1; i < arr1.length; i++) {
            for (int j = 1; j < arr2.length; j++) {
                int res = Math.max(arr[i][j-1], arr[i-1][j]);
                if (arr1[i] == arr2[j]){
                    res = Math.max(arr[i-1][j-1] + 1, res);
                }
                arr[i][j] = res;
            }
        }
        return arr[arr1.length - 1][arr2.length - 1];
    }
}
