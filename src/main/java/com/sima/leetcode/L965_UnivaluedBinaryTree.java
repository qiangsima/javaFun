package com.sima.leetcode;

import com.sima.leetcode.util.TreeNode;

/**
 * Created by qisima on 2/20/2019 4:41 PM
 *
 * A binary tree is univalued if every node in the tree has the same value.
 * Return true if and only if the given tree is univalued.
 */
public class L965_UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)return true;
        return isUnivalTree(root.left, root.val) && isUnivalTree(root.right, root.val);
    }

    private boolean isUnivalTree(TreeNode root, int val){
        if (root == null)return true;
        return root.val == val && isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
    }
}
