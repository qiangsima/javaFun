package main.java.com.sima.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sima on 2017/4/18.
 */
public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    public BinarySearchTree(int[] arr) {
        for (int i : arr){
            this.insert(this.root, i);
        }
    }

    public boolean insert(TreeNode root, int val){
        if (root == null){
            this.root = new TreeNode(val);
            return true;
        }
        if (root.val == val){
            return false;
        }
        if (root.val < val){
            if (root.right == null){
                root.right = new TreeNode(val);
                return true;
            }
            return insert(root.right, val);
        }
        if (root.left == null){
            root.left = new TreeNode(val);
            return true;
        }
        return insert(root.left, val);
    }
    //包含某个节点
    public boolean contains(TreeNode root, int val){
        if (root == null)return false;
        if (root.val == val)return true;
        if (root.val < val)return contains(root.right, val);
        return contains(root.left, val);
    }
    //删除节点
    public TreeNode remove(int val){
        return remove(this.root, val);
    }
    public TreeNode remove(TreeNode root, int val){
        if (root == null)return root;
        if (root.val < val)return remove(root.right, val);
        if (root.val > val)return remove(root.left, val);
        TreeNode ret = new TreeNode(root.val);
        if (root.left != null && root.right != null){//左右子树都不为空
            //找出右子树中最小的值
            int minRight = findMin(root.right);
            root.val = minRight;
            remove(root.right, minRight);
        }else{
            if (root.left != null)
                copy(root, root.left);
            else
                copy(root, root.right);
        }
        return ret;
    }
    public TreeNode find(TreeNode root, int val){
        if (root == null)return null;
        if (root.val == val)return root;
        if (root.val < val)return find(root.right, val);
        return find(root.left, val);
    }
    //最小值
    public int findMin(TreeNode root){
        if (root == null)return Integer.MAX_VALUE;
        while (root.left != null)root = root.left;
        return root.val;
    }
    //复制两个结点
    private void copy(TreeNode des, TreeNode src){
        if (des == null)return;
        if (src == null){
            des.val = Integer.MAX_VALUE;
            des.left = null;
            des.right = null;
        }else{
            des.val = src.val;
            des.left = src.left;
            des.right = src.right;
        }
    }
    //打印二叉搜索树
    public String toString(){
        if (root == null)return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
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
    public static void main(String[] args){
        int[] arr = {23,14,5,3,4,8,9,12,25,65,46,9,29};
        BinarySearchTree bst = new BinarySearchTree(arr);
        bst.remove(8);
        System.out.println(bst.toString());
    }
}
