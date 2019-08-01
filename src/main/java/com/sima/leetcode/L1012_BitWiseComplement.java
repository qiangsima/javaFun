package com.sima.leetcode;

/**
 * Created by qisima on 3/20/2019 8:46 AM
 */
public class L1012_BitWiseComplement {
    public int bitwiseComplement(int N) {
        if (N == 0)return 1;
        int n = (int)(Math.log(N)/Math.log(2)) + 1;
        return (int)Math.pow(2, n) - N - 1;
    }
}
