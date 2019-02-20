package com.sima.leetcode;

/**
 * Created by qisima on 2/20/2019 4:27 PM
 *
 * We have an array A of integers, and an array queries of queries.
 * For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.
 * (Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)
 * Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
 *
 * Example:
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * Output: [8,6,2,4]
 * Explanation:
 * At the beginning, the array is [1,2,3,4].
 * After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
 * After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
 * After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
 * After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 */
public class L985_SumEvenAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries){
        int[] res = new int[queries.length];
        int evenSum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2 == 0){
                evenSum += A[i];
            }
        }
        for (int i = 0; i < res.length; i++) {
            if (A[queries[i][1]]%2 == 0){
                evenSum -= A[queries[i][1]];
            }
            A[queries[i][1]] += queries[i][0];
            if (A[queries[i][1]]%2 == 0){
                evenSum += A[queries[i][1]];
            }
            res[i] = evenSum;
        }

        return res;
    }
}
