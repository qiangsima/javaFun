package com.sima.dataStructure;

/**
 * Created by sima on 2017/4/18.
 */
public class AvlTreeNode{
    public AvlTreeNode left;
    public AvlTreeNode right;
    public int val;
    public int height;

    public AvlTreeNode(int val, int height) {
        this.val = val;
        this.height = height;
    }
}
