package com.sima.leetcode;

/**
 * Created by qisima on 2/28/2019 2:47 PM
 *
 * Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.
 * If there aren't two consecutive 1's, return 0.
 */
public class L868_BinaryGap {
    public int binaryGap(int N){
        int max = 0;
        StringBuilder sb = new StringBuilder();
        while (N != 0){
            sb.append(N%2);
            N /= 2;
        }
        char[] arr = sb.reverse().toString().toCharArray();
        int i = 0, j = 1;
        while (j < arr.length){
            while (j < arr.length && arr[j] != '1')j++;
            if (arr[j] == '1' && j-i > max){
                max = j-i;
            }
            i = j;
            j++;
        }
        return max;
    }
}
