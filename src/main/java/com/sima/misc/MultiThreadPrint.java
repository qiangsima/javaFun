package com.sima.misc;

import java.util.concurrent.Semaphore;

/**
 * Created by qisima on 3/18/2019 12:43 PM
 */
public class MultiThreadPrint {
    static Semaphore semaphoreA = new Semaphore(1);
    static Semaphore semaphoreB = new Semaphore(0);
    static Semaphore semaphoreC = new Semaphore(0);

    public static void print(char ch, Semaphore cur, Semaphore next)  {
        try {
            cur.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(ch);
        next.release();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                print('A', semaphoreA, semaphoreB);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                print('B', semaphoreB, semaphoreC);
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                print('C', semaphoreC, semaphoreA);
            }
        });

        for (int i = 0; i < 5; i++) {
            t1.run();
            t2.run();
            t3.run();
        }

        System.out.println();
    }
}
