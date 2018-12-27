package com.sima.leetcode;

import java.util.Arrays;

public class L869_ReorderedPowerOf2 {
    /**
     * Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.
     * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
     *
     * Note:
     * 1 <= N <= 10^9
     * */
    public boolean reorderedPowerOf2(int N){
        int[] arr = new int[]{1,2,4,8,16,32,64,128,256,512,1024,
                2048,4096,8192,16384,32768,65536,131072,262144,
                524288,1048576,2097152,4194304,8388608,16777216,
                33554432,67108864,134217728,268435456,536870912};

        String target = int2OrderedString(N);
        for (int num : arr){
            if (target.equals(int2OrderedString(num))){
                return true;
            }
        }
        return false;
    }

    public String int2OrderedString(int N){
        String tmp = String.valueOf(N);
        char[] arr = tmp.toCharArray();
        Arrays.sort(arr);

        return new String(arr);
    }

    public static void main(String[] args){
        L869_ReorderedPowerOf2 solution = new L869_ReorderedPowerOf2();

        int[] arr = new int[]{1, 10, 16, 24, 46, 245792};
        for (int num : arr){
            System.out.println(num + " : " + solution.reorderedPowerOf2(num));
            System.out.println();
        }
    }
}
