package com.sima.leetcode;

import com.sima.leetcode.util.Node;

/**
 * Created by qisima on 2/21/2019 11:18 AM
 */
public class L559_MaxDepthOfNaryTree {
    public int maxDepth(Node root){
         if (root == null) return 0;
         int max = 0;
         for (Node n : root.children){
             int depth = maxDepth(n);
             if (depth > max){
                 max = depth;
             }
         }
         return 1 + max;
    }
}
