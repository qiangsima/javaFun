package com.sima.leetcode;

import com.sima.leetcode.util.TreeNode;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by qisima on 2/14/2019 4:20 PM
 *
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */
public class L872_LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2){
        LinkedList<Integer> list1 = new LinkedList();
        LinkedList<Integer> list2 = new LinkedList();
        getLeafValues(root1, list1);
        getLeafValues(root2, list2);
        if (list1.size() != list2.size())return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i))return false;
        }

        return true;
    }

    private void getLeafValues(TreeNode root, LinkedList<Integer> list){
        if (root == null)return;
        if (root.left == null && root.right == null){
            list.add(root.val);
            return;
        }
        getLeafValues(root.left, list);
        getLeafValues(root.right, list);
    }
}
