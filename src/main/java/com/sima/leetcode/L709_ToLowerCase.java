package com.sima.leetcode;

/**
 * Created by qisima on 1/7/2019 7:31 PM
 */
public class L709_ToLowerCase {
    /*
    * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
    * */
    public String toLowerCase(String str){
        char[] arr = str.toCharArray();
        for (int i = 0;  i < arr.length; i++){
            if (arr[i] >= 'A' && arr[i] <= 'Z'){
                arr[i] = (char)(arr[i] - 'A' + 'a');
            }
        }
        return String.valueOf(arr);
    }
}
