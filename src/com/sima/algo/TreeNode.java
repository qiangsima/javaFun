package com.sima.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sima on 2017/05/08.
 */
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
    /*
    * 通过字符串构建二叉树
    * 如：8,6,10,5,null,7,null,9
    * */
    /*public TreeNode buildTreeFormString(String[] arr, int idx){
        if (idx > arr.length)return null;


    }*/
    public String toString(){
        if (this == null)return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(this);
        while (!queue.isEmpty()){
            TreeNode root = queue.poll();
            if (root == null){
                sb.append(",null");
            }else{
                sb.append(",").append(root.val);
                queue.offer(root.left);
                queue.offer(root.right);
            }
        }
        return sb.substring(1);
    }
}
