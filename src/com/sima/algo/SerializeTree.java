package com.sima.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sima on 2017/05/08.
 */
public class SerializeTree {
    String Serialize(TreeNode proot) {
        if (proot == null)return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(proot);
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
    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0)return null;
        String[] arr = str.split(",");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.offer(root);
        int idx = 1;
        while (idx < arr.length && !queue.isEmpty()){
            TreeNode tmp = queue.poll();
            if (!"null".equals(arr[idx])){
                tmp.left = new TreeNode(Integer.parseInt(arr[idx]));
                queue.offer(tmp.left);
            }
            idx++;
            if (!"null".equals(arr[idx])){
                tmp.right = new TreeNode(Integer.parseInt(arr[idx]));
                queue.offer(tmp.right);
            }
            idx++;
        }
        return root;
    }
}
