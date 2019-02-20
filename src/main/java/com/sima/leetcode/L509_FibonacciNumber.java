package com.sima.leetcode;

import java.util.ArrayList;

/**
 * Created by qisima on 2/20/2019 5:43 PM
 */
public class L509_FibonacciNumber {
    ArrayList<Integer> list = new ArrayList<>(){{add(0); add(1);}};
    public int fib(int N){
        if (N < list.size()){
            return list.get(N);
        } else {
            int s = list.size();
            while (s <= N){
                list.add(list.get(s-1) + list.get(s-2));
                s++;
            }
            return list.get(N);
        }
    }
}
