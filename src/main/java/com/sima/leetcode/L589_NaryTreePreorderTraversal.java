package com.sima.leetcode;

import com.sima.leetcode.util.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qisima on 2/20/2019 5:55 PM
 */
public class L589_NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
    private void preorder(Node root, List<Integer> list){
        if (root == null) return;
        list.add(root.val);
        for (Node n : root.children){
            preorder(n, list);
        }
    }
}
