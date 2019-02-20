package com.sima.leetcode;

import com.sima.leetcode.util.TreeNode;

/**
 * Created by qisima on 2/20/2019 4:51 PM
 */
public class L700_SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (root.val < val){
            return searchBST(root.right, val);
        }
        return searchBST(root.left, val);
    }
}
