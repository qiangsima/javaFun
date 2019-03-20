package com.sima.leetcode;

/**
 * Created by qisima on 3/19/2019 5:25 PM
 */
public class L788_RotatedDigits {
    public int rotatedDigits(int N){
        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (isValid(i))cnt++;
        }
        return cnt;
    }
    private boolean isValid(int num){
        String s = String.valueOf(num);
        boolean flag = false;
        for (char ch : s.toCharArray()){
            if (ch == '3' || ch == '4' || ch == '7')return false;
            if (ch == '2' || ch == '5' || ch == '6' || ch == '9')flag = true;
        }
        return flag;
    }
}
