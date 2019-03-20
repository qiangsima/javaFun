package com.sima.leetcode;

import com.sima.leetcode.util.TreeNode;

/**
 * Created by qisima on 3/19/2019 3:33 PM
 */
public class L104_MaxDepth {
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
