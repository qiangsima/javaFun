package com.sima.leetcode;

import com.sima.leetcode.util.TreeNode;

/**
 * Created by qisima on 2/28/2019 4:09 PM
 */
public class L669_TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);
        TreeNode left = trimBST(root.left, L, R);
        TreeNode right = trimBST(root.right, L, R);
        root.left = left;
        root.right = right;
        return root;
    }
}
