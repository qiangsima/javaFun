package com.sima.leetcode;

/**
 * Created by qisima on 2/18/2019 4:52 PM
 *
 * Let's call an array A a mountain if the following properties hold:
 *   - A.length >= 3
 *   - There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 *
 * Example:
 * Input: [0,1,0]
 * Output: 1
 */
public class L852_PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        return peakIndexInMountainArray(A, 0, A.length-1);
    }

    private int peakIndexInMountainArray(int[] arr, int lo, int hi) {
        if (lo >= hi) return lo;
        int mid = (lo + hi) / 2;
        if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
            return mid;
        } else if (arr[mid] < arr[mid+1]){
            return peakIndexInMountainArray(arr, mid+1, hi);
        } else {
            return peakIndexInMountainArray(arr, lo, mid-1);
        }
    }
}
