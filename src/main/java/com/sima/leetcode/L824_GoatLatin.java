package com.sima.leetcode;

/**
 * Created by qisima on 4/30/2019 2:58 PM
 */
public class L824_GoatLatin {
    public String toGoatLatin(String S) {
        String[] arr = S.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            res.append(toGoatLatinWord(arr[i], i));
        }
        return res.toString();
    }

    private String toGoatLatinWord(String word, int idx){
        StringBuilder sb = new StringBuilder();
        if (idx != 0){
            sb.append(" ");
        }
        if (isVowel(word.charAt(0))){
            sb.append(word).append("ma");
        } else {
            sb.append(word.substring(1)).append(word.charAt(0));
        }
        for (int i = 0; i <= idx ; i++) {
            sb.append('a');
        }
        return sb.toString();
    }

    private Boolean isVowel(char ch) {
        switch (ch){
            case 'A':
            case 'a':
            case 'E':
            case 'e':
            case 'I':
            case 'i':
            case 'O':
            case 'o':
            case 'U':
            case 'u':
                return true;
            default:
                return false;
        }
    }

}
