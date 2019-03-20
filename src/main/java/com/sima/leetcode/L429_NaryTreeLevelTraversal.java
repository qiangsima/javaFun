package com.sima.leetcode;

import com.sima.leetcode.util.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qisima on 3/19/2019 4:27 PM
 */
public class L429_NaryTreeLevelTraversal {
    public List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)return res;
        List<Node> list = new LinkedList<>(){{add(root);}};
        while (list.size() > 0){
            List<Integer> valueList = new LinkedList<>();
            List<Node> childList = new LinkedList<>();
            for (Node node : list){
                valueList.add(node.val);
                if (node.children != null && node.children.size() > 0){
                    childList.addAll(node.children);
                }
            }
            res.add(valueList);
            list = childList;
        }
        return res;
    }

    public static void main(String[] args){
        Node n5 = new Node(5, null);
        Node n6 = new Node(6, null);
        Node n3 = new Node(3, new LinkedList<>(){{add(n5); add(n6);}});
        Node n2 = new Node(2, null);
        Node n4 = new Node(4, null);
        Node root = new Node(1, new LinkedList<>(){{add(n3); add(n2); add(n4);}});
        List res = new L429_NaryTreeLevelTraversal().levelOrder(root);
    }
}
