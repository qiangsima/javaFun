package main.java.com.sima.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sima on 2017/4/18.
 */
public class AvlTree {
    AvlTreeNode root;

    public AvlTree(int[] arr) {
        for (int i : arr){
            this.insert(this.root, i);
        }
    }

    public int getHeight(AvlTreeNode root){
        if (root == null)return -1;
        return root.height;
    }
    public void insert(int val){
        insert(root, val);
    }

    private void insert(AvlTreeNode root, int val) {
        if (root == null){
            this.root = new AvlTreeNode(val, 0);//根节点高度定义为0
            return;
        }else if (root.val < val){
            if (root.right == null){
                root.right = new AvlTreeNode(val,0);
            }else {
                insert(root.right, val);
            }
            if (getHeight(root.right) - getHeight(root.left) == 2){
                if (root.right.val < val){
                    rotateWithRightChild(root);
                }else if (root.val > val){
                    doubleWithRightChild(root);
                }
            }
        }else if (root.val > val){
            if (root.left == null){
                root.left = new AvlTreeNode(val,0);
            }else{
                insert(root.left, val);
            }
            if (getHeight(root.left) - getHeight(root.right) == 2){
                if (root.left.val < val){
                    doubleWithLeftChild(root);
                }else if (root.left.val > val){
                    rotateWithLeftChild(root);
                }
            }
        }
        root.height = Math.max(getHeight(root.left), getHeight(root.right))+1;
    }

    private void doubleWithLeftChild(AvlTreeNode root) {
        rotateWithRightChild(root.left);
        rotateWithLeftChild(root);
    }

    //左旋转
    private void rotateWithLeftChild(AvlTreeNode root) {
        AvlTreeNode k1 = root.left;
        root.left = k1.right;
        k1.right = root;
        root.height = Math.max(getHeight(root.left), getHeight(root.right))+1;
        k1.height = Math.max(getHeight(k1.left), getHeight(k1.right))+1;
        swap(root, k1);
    }

    //右双旋转
    private void doubleWithRightChild(AvlTreeNode root) {
        rotateWithLeftChild(root.right);
        rotateWithRightChild(root);
    }

    //右单旋转
    private void rotateWithRightChild(AvlTreeNode root) {
        AvlTreeNode k2 = root.right;
        root.right = k2.left;
        k2.left = root;
        root.height = Math.max(getHeight(root.left), getHeight(root.right))+1;
        k2.height = Math.max(getHeight(k2.left), getHeight(k2.right))+1;
        swap(root, k2);
    }
    //注意：高度大的节点在后面
    private void swap(AvlTreeNode des, AvlTreeNode src){
        //交换高度
        int tmpHeight = src.height;
        src.height = des.height;
        des.height = tmpHeight;
        //交换值
        int tmpVal = src.val;
        src.val = des.val;
        des.val = tmpVal;
        //交换左右子树
        AvlTreeNode tmpNode = src.left;
        src.left = des.left;
        if (tmpNode == des){
            des.left = src;
        }else{
            des.left = tmpNode;
        }

        tmpNode = src.right;
        src.right = des.right;
        if (tmpNode == des){
            des.right = src;
        }else{
            des.right = tmpNode;
        }
    }
    public String toString(){
        if (root == null)return "";
        Queue<AvlTreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()){
            AvlTreeNode root = queue.poll();
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
        AvlTree avl = new AvlTree(arr);
        System.out.println(bst.toString());
        System.out.println(avl.toString());
    }
}
