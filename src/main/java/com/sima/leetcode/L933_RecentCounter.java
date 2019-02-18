package com.sima.leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by qisima on 2/18/2019 5:31 PM
 *
 * Write a class RecentCounter to count recent requests.
 * It has only one method: ping(int t), where t represents some time in milliseconds.
 * Return the number of pings that have been made from 3000 milliseconds ago until now.
 * Any ping with time in [t - 3000, t] will count, including the current ping.
 * It is guaranteed that every call to ping uses a strictly larger value of t than before.
 *
 * Note:
 * - Each test case will have at most 10000 calls to ping.
 * - Each test case will call ping with strictly increasing values of t.
 * - Each call to ping will have 1 <= t <= 10^9.
 */
public class L933_RecentCounter {
    ArrayList<Integer> list;
    public L933_RecentCounter() {
        list = new ArrayList<Integer>();
    }

    public int ping(int t) {
        list.add(t);
        if (t <= 3000) return list.size();
        int idx = Collections.binarySearch(list, t-3000);
        if (idx < 0)idx = -idx;
        return list.size() - idx;
    }
}
