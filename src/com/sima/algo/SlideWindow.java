package com.sima.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sima on 2017/05/22.
 * 找出数组滑动窗口中的所有最大值
 */
public class SlideWindow {
    public List<Integer> getMaxInSlideWindow(int[] arr, int size){
        List<Integer> list = new ArrayList<>();
        if (arr == null || arr.length < size){
            return list;
        }
        int idx = 0, max = arr[0];
        for (int i = 0; i < size; i++) {
            if (arr[i] > max){
                idx = i;
                max = arr[i];
            }
        }
        list.add(max);
        for (int i = size; i < arr.length; i++) {
            if (max > arr[i]){
                if (i-idx < size){
                    list.add(max);
                }else{
                    int tmpIdx = i, tmpMax = arr[i];
                    for (int j = i-size+1; j <= i; j++) {
                        if (arr[j] > tmpMax){
                            tmpMax = arr[j];
                            tmpIdx = j;
                        }
                    }
                    max = tmpMax;
                    idx = tmpIdx;
                    list.add(max);
                }
            }else{
                idx = i;
                max = arr[i];
                list.add(max);
            }
        }
        return list;
    }
    public static void main(String[] args){
        SlideWindow main = new SlideWindow();
        int[] arr = {2,3,4,2,6,2,5,1};
        System.out.println(Arrays.toString(main.getMaxInSlideWindow(arr, 3).toArray()));
    }
}
