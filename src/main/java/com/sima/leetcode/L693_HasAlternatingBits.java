package com.sima.leetcode;

/**
 * Created by qisima on 4/30/2019 2:42 PM
 */
public class L693_HasAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        if (n < 2) return true;
        int last = n % 2;
        while (n >= 1){
            n >>= 1;
            int tmp = (n%2) & 1;
            if (tmp == last)return false;
            last = tmp;
        }
        return true;
    }
}
