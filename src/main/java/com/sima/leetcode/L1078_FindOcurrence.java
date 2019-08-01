package com.sima.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qisima on 7/31/2019 5:09 PM
 */
public class L1078_FindOcurrence {
    public String[] findOcurrences(String text, String first, String second){
        List<String> res = new ArrayList<>();
        String[] arr = text.split(" ");
        for (int i = 0; i < arr.length - 2; i++) {
            if ((first+second).equals(arr[i]+arr[i+1])){
                res.add(arr[i+2]);
            }
        }
        return res.toArray(new String[0]);
    }
}
