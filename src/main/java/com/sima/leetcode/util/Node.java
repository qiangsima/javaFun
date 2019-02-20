package com.sima.leetcode.util;

import java.util.List;

/**
 * Created by qisima on 2/20/2019 5:54 PM
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
