package com.sima.algo;

import java.util.*;

/**
 * Created by sima on 2017/05/22.
 * 获取数据流中的中位数
 */
public class MediumOfStream {
    int N = 0;  //
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    public void insert(int num){
        N++;
        if (N%2 == 0){//当前是偶数，则添加到minHeap
            if (!maxHeap.isEmpty() && num < maxHeap.peek()){
                int tmp = maxHeap.poll();
                maxHeap.offer(num);
                minHeap.offer(tmp);
            }else{
                minHeap.offer(num);
            }
        }else{//当前是奇数，则添加到maxHeap，保证两个heap元素个数相差不超过1
            if (!minHeap.isEmpty() && num > minHeap.peek()){
                int tmp = minHeap.poll();
                minHeap.offer(num);
                maxHeap.offer(tmp);
            }else {
                maxHeap.offer(num);
            }
        }
    }
    public double getMedium(){
        if (N%2 == 0){
            return (double)(minHeap.peek()+maxHeap.peek())/2;
        }else{
            return 1.0*maxHeap.peek();
        }
    }

    public static void main(String[] args){
        Random rand = new Random(47);
        Scanner in = new Scanner(System.in);
        while (true){
            MediumOfStream main = new MediumOfStream();
            System.out.println("please enter the number of the test case:");
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(100);
                main.insert(arr[i]);
            }
            System.out.println("test case is: " + Arrays.toString(arr));
            System.out.println("the medium is: " + main.getMedium());
        }
    }
}
