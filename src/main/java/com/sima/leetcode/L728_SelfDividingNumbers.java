package com.sima.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qisima on 2/18/2019 5:08 PM
 *
 * A self-dividing number is a number that is divisible by every digit it contains.
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 *
 * Example:
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 */
public class L728_SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)){
                list.add(i);
            }
        }

        return list;
    }

    private boolean isSelfDividingNumber(int number){
        if (number == 0)return false;
        int tmp = number;
        while (tmp != 0){
            int digit = tmp % 10;
            if (digit == 0 || number % digit != 0)return false;
            tmp /= 10;
        }
        return true;
    }
}
