package com.sima.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by qisima on 3/20/2019 8:17 AM
 */
public class L762_CountPrimeSetBits {
    public int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};

    public int countPrimeSetBits(int L, int R){
        int cnt = 0;
        for (int i = L; i <= R; i++) {
            if (isPrime(i))cnt++;
        }
        return cnt;
    }

    private boolean isPrime(int num){
        int cnt = 0;
        while (num > 0){
            if (num%2==1)cnt++;
            num /=2;
        }
        return Arrays.binarySearch(primes, cnt) >= 0;
    }

    public static void main(String[] args){
        int l = 842, r = 888;
        System.out.println(new L762_CountPrimeSetBits().countPrimeSetBits(l, r));
    }
}
