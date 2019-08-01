package com.sima.leetcode;

import java.util.*;

/**
 * Created by qisima on 7/31/2019 5:59 PM
 */
public class L1047_RemoveDuplicates {
    public String removeDuplicates(String S){
        char[] arr = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : arr) {
            if (!stack.isEmpty() && stack.peek() == ch){
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
