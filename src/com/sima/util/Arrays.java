package com.sima.util;

import java.util.Random;

/**
 * Created by sima on 2017/4/25.
 */
public class Arrays {
    public static void heapSort(int[] arr){
        if (arr == null || arr.length <= 1)return;
        heapSort(arr, arr.length);
    }

    public static void heapSort(int[] arr, int length) {
        for (int i = length/2; i >= 0 ; i--) {
            percolateDown(arr, i, length);
        }
        for (int i = 0; i < length; i++){
            swap(arr, 0, length-1-i);
            percolateDown(arr, 0, length-1-i);
        }
    }

    private static void percolateDown(int[] arr, int hole, int length) {
        int tmp = arr[hole], child = 2*hole;
        for (; 2*hole+1 < length; hole = child){
            child = 2*hole+1;
            if (child+1 < length && arr[child+1] < arr[child])child++;
            if (arr[child] < tmp){
                arr[hole] = arr[child];
            }
        }
        arr[hole] = tmp;
    }

    public static void mergeSort(int[] arr){
        if (arr == null || arr.length <= 1)return;
        mergeSort(arr, 0, arr.length-1);
    }

    public static void mergeSort(int[] arr, int s, int e) {
        if (s < e){
            int m = (s + e) >> 1;
            mergeSort(arr, s, m);
            mergeSort(arr, m+1, e);
            merge(arr, s, m, e);
        }
    }

    private static void merge(int[] arr, int s, int m, int e) {
        int[] tmp = new int[e-s+1];
        int k = 0, j = m+1, i = s;
        while (i <= m && j <= e){
            if (arr[i] < arr[j]){
                tmp[k++] = arr[i++];
            }else{
                tmp[k++] = arr[j++];
            }
        }
        while (i <= m){
            tmp[k++] = arr[i++];
        }
        while (j <= e){
            tmp[k++] = arr[j++];
        }
        k = 0;
        while (k < tmp.length){
            arr[s+k] = tmp[k++];
        }
    }

    public static void quickSort(int[] arr){
        if (arr == null || arr.length <= 1)return;
        quickSort(arr, 0, arr.length-1);
    }
    public static void quickSort(int[] arr, int s, int e){
        if (s >= e)return;
        int i = s, j = e-1, x = arr[e];
        while (true){
            while (i < j && arr[j] >= x){
                j--;
            }
            while (i <= j && arr[i] < x){
                i++;
            }
            if (i < j){
                swap(arr, i, j);
            }else{
                break;
            }
        }
        swap(arr, i, e);
        quickSort(arr, s, i-1);
        quickSort(arr, i+1, e);
    }
    private static void swap(int[] arr, int idx, int idy){
        int tmp = arr[idx];
        arr[idx] = arr[idy];
        arr[idy] = tmp;
    }
    public static void main(String[] args){
        int n = 10;
        Random rand = new Random(47);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(20);
        }
        System.out.println(java.util.Arrays.toString(arr));
        heapSort(arr);
        System.out.println(java.util.Arrays.toString(arr));
    }
}
