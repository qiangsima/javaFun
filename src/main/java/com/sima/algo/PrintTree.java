package com.sima.algo;

import java.util.*;

/**
 * 按之字打印二叉树
 * Created by sima on 2017/05/08.
 */

public class PrintTree {
    public static  ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null)return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pRoot);
        TreeNode pivot = new TreeNode(Integer.MIN_VALUE), cur = new TreeNode(0);
        queue.offer(pivot);
        boolean flag = false;
        while (!queue.isEmpty()){
            ArrayList<Integer> tmpList = new ArrayList<Integer>();
            if (flag){//从左至右
                while (cur != pivot){
                    cur = queue.poll();
                    if (cur != pivot){
                        if (cur.left != null){
                            queue.offer(cur.left);
                        }
                        if (cur.right != null){
                            queue.offer(cur.right);
                        }
                        tmpList.add(cur.val);
                    }else{
                        if (!queue.isEmpty()){
                            queue.offer(pivot);
                        }

                    }
                }
            }else{//从右至左
                Stack<TreeNode> stack = new Stack<>();
                while (cur != pivot){
                    cur = queue.poll();
                    if (cur != pivot){
                        if (cur.left != null){
                            queue.offer(cur.left);
                        }
                        if (cur.right != null){
                            queue.offer(cur.right);
                        }
                        stack.push(cur);
                    }else{
                        if (!queue.isEmpty()){
                            queue.offer(pivot);
                        }
                    }
                }
                while (!stack.isEmpty()){
                    tmpList.add(stack.pop().val);
                }
            }
            flag = true ^ flag;
            list.add(tmpList);
            cur = new TreeNode(0);// watch out
        }
        return list;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        List list = print(root);
    }
}
