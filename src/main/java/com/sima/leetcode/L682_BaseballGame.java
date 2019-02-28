package com.sima.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qisima on 2/28/2019 3:57 PM
 */
public class L682_BaseballGame {
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();
        for (String str : ops){
            switch (str){
                case "C":
                    list.remove(list.size()-1);
                    break;
                case "D":
                    list.add(list.get(list.size()-1)*2);
                    break;
                case "+":
                    list.add(list.get(list.size()-1)+list.get(list.size()-2));
                    break;
                default:
                    list.add(Integer.parseInt(str));
                    break;
            }
        }
        int res = 0;
        for (int num : list){
            res += num;
        }
        return res;
    }
}
