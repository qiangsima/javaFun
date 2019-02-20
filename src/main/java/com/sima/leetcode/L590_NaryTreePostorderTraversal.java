package com.sima.leetcode;

import com.sima.leetcode.util.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qisima on 2/20/2019 6:03 PM
 */
public class L590_NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root){
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }
    private void postorder(Node root, List<Integer> list){
        if (root == null)return;
        for (Node n : root.children){
            postorder(n, list);
        }
        list.add(root.val);
    }
}
