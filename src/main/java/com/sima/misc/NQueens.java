package com.sima.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by qisima on 7/31/2019 2:04 PM
 */
public class NQueens {
    // Place k queens in a n*n board
    public List<List<Integer>> placeQueens(int k, int n){
        if (k == 0)return new ArrayList<List<Integer>>();
        List<List<Integer>> list = placeQueens(k-1, n);
        List res = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            if (list.size() == 0){
                List tmpList = new ArrayList<Integer>();
                tmpList.add(i);
                res.add(tmpList);
            }else {
                for (int j = 0; j < list.size(); j++) {
                    List<Integer> tmpList = new ArrayList<Integer>(list.get(j));
                    if (isSafe(k-1, i, tmpList)) {
                        tmpList.add(i);
                        res.add(tmpList);
                    }
                }
            }
        }
        return res;
    }

    private boolean isSafe(int r, int c, List<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            if (isCheck(r, c, i, list.get(i))){
                return false;
            }
        }
        return true;
    }

    private boolean isCheck(int r1, int c1, int r2, int c2) {
        if (r1 == r2 || c1 == c2 || r2-r1 == c2-c1 || r2-r1 == c1-c2)return true;
        return false;
    }

    public static void main(String[] args){
        List<List<Integer>> res = new NQueens().placeQueens(8, 8);
        for (List<Integer> list: res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
