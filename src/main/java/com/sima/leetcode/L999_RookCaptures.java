package com.sima.leetcode;

/**
 * Created by qisima on 2/27/2019 6:36 PM
 */
public class L999_RookCaptures {
    public int numRookCaptures(char[][] board) {
        int left = 0,right = 0, up = 0, down = 0;
        int i = 0, j = 0;
        boolean flag = false;
        for (; i < board.length; i++){
            j = 0;
            for (; j < board[i].length; j++) {
                if (board[i][j] == 'R'){
                    flag = true;
                    break;
                }
            }
            if (flag)break;
        }
        int idx = i-1;
        while (idx >= 0 && up == 0){
            if (board[idx][j] == 'p'){
                up = 1;
            }else if (board[idx][j] == 'B'){
                break;
            }
            idx--;
        }
        idx = i+1;
        while (idx < board.length && down == 0){
            if (board[idx][j] == 'p'){
                down = 1;
            }else if (board[idx][j] == 'B'){
                break;
            }
            idx++;
        }
        idx = j-1;
        while (idx >= 0 && left == 0){
            if (board[i][idx] == 'p'){
                left = 1;
            }else if (board[i][idx] == 'B'){
                break;
            }
            idx--;
        }
        idx = j+1;
        while (idx < board[i].length && right == 0){
            if (board[i][idx] == 'p'){
                right = 1;
            }else if (board[i][idx] == 'B'){
                break;
            }
            idx++;
        }
        return left+right+up+down;
    }
}
