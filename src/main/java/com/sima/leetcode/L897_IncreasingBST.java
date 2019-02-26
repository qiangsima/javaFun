package com.sima.leetcode;

import com.sima.leetcode.util.TreeNode;

/**
 * Created by qisima on 2/26/2019 8:14 PM
 */
public class L897_IncreasingBST {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null)return root;
        TreeNode right = increasingBST(root.right);
        root.right = right;
        TreeNode left = increasingBST(root.left);
        root.left = null;
        if (left == null){
            return root;
        }
        TreeNode cur = left;
        while (cur.right != null){
            cur = cur.right;
        }
        cur.right = root;
        return left;
    }
}
