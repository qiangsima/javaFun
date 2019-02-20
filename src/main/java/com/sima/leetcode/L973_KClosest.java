package com.sima.leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by qisima on 2/20/2019 5:00 PM
 *
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 * Example:
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 */
public class L973_KClosest {
    public int[][] kClosest(int[][] points, int K){
        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            list.add(new Point(points[i]));
        }
        Collections.sort(list);
        int[][] res = new int[K][];
        for (int i = 0; i < K; i++) {
            res[i] = list.get(i).p;
        }

        return res;
    }

    class Point implements Comparable<Point>{
        int[] p;

        public Point(int[] p) {
            this.p = p;
        }

        @Override
        public int compareTo(Point o) {
            return p[0]*p[0] + p[1]*p[1] - o.p[0]*o.p[0] - o.p[1]*o.p[1];
        }
    }
}
