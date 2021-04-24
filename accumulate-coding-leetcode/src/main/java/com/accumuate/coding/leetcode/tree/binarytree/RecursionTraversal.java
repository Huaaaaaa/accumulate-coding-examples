package com.accumuate.coding.leetcode.tree.binarytree;


import com.accumuate.coding.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: cyhua
 * @createTime: 2021/4/18
 * @description: 递归方法遍历二叉树
 */
public class RecursionTraversal {

    public static List<Integer> preOrderResult = new ArrayList<>();
    public static List<Integer> inOrderResult = new ArrayList<>();
    public static List<Integer> afterOrderResult = new ArrayList<>();


    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.setData(2);
        TreeNode left = new TreeNode();
        left.setData(4);
        TreeNode right = new TreeNode();
        right.setData(1);
        root.setLeftChild(left);
        root.setRightChild(right);
        preOrderResult = preOrder(root);
        //2 4 1
        System.out.println("Preorder:"+preOrderResult);
        inOrderResult = inOrder(root);
        //4 2 1
        System.out.println("Inorder:"+inOrderResult);
        afterOrderResult = afterOrder(root);
        //4 1 2
        System.out.println("AfterOrder:"+afterOrderResult);


    }

    /**
     * 先序遍历
     * @param treeNode
     * @return
     */
    public static  List<Integer> preOrder(TreeNode treeNode){
        preOrderResult.add(treeNode.getData());
        if(treeNode.getLeftChild()!=null){
            preOrder(treeNode.getLeftChild());
        }
        if(treeNode.getRightChild()!=null){
            preOrder(treeNode.getRightChild());
        }
        return  preOrderResult;
    }
    /**
     * 中序遍历
     * @param treeNode
     * @return
     */
    public static  List<Integer> inOrder(TreeNode treeNode){
        if(treeNode.getLeftChild()!=null){
            inOrder(treeNode.getLeftChild());
        }
        inOrderResult.add(treeNode.getData());
        if(treeNode.getRightChild()!=null){
            inOrder(treeNode.getRightChild());
        }
        return  inOrderResult;
    }
    /**
     * 后序遍历
     * @param treeNode
     * @return
     */
    public static  List<Integer> afterOrder(TreeNode treeNode){
        if(treeNode.getLeftChild()!=null){
            afterOrder(treeNode.getLeftChild());
        }
        if(treeNode.getRightChild()!=null){
            afterOrder(treeNode.getRightChild());
        }
        afterOrderResult.add(treeNode.getData());
        return  afterOrderResult;
    }
}
