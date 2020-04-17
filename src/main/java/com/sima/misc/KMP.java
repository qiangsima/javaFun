package main.java.com.sima.misc;

/**
 * Created by qisima on 4/15/2020 7:10 PM
 */
public class KMP {
    public static int kmp(String txt, String pat){
        if (pat.length() == 0){
            return 0;
        }

        if (txt.length() == 0){
            return -1;
        }

        char[] arr = pat.toCharArray();
        int[][] dp = new int[arr.length][256];
        dp[0][arr[0]-'a'] = 1;
        int pre = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < 256; j++) {
                if (arr[i] - 'a' == j){
                    dp[i][j] = i+1;
                } else {
                    dp[i][j] = dp[pre][j];
                }
            }

            pre = dp[pre][arr[i]];
        }

        int state = 0;
        for (int i = 0; i < txt.length(); i++) {
            state = dp[state][txt.charAt(i)-'a'];
            if (state == arr.length){
                return i-arr.length+1;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        String txt = "aaaaaaaaaaaaaaaaaab";
        String pat = "aaab";
        System.out.println(txt.indexOf(pat));
        System.out.println(kmp(txt, pat));
    }
}
