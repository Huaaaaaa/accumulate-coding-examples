package com.accumuate.coding.leetcode.basic;

import com.accumuate.coding.leetcode.BaseArray;

import java.util.Arrays;

/**
 * @author: huayingcao
 * @createTime: 2021/12/11 2:43 下午
 * @description:
 */
public class BinaryTreeThreeOrder extends BaseArray {

    private int[] preList;
    private int[] middleList;
    private int[] postList;

    public static void main(String[] args) {
        BaseArray.TreeNode treeNode = getTreeNode();
        BinaryTreeThreeOrder binaryTreeThreeOrder = new BinaryTreeThreeOrder();
        int[][] res = binaryTreeThreeOrder.threeOrders(treeNode);
        Arrays.stream(res).forEach(s -> Arrays.stream(s).forEach(value -> System.out.println(value)));

    }

    public int size(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            return 1 + size(treeNode.getLeft()) + size(treeNode.getRight());
        }
    }

    public int[][] threeOrders(TreeNode root) {
        int size = size(root);
        preList = new int[size];
        middleList = new int[size];
        postList = new int[size];
        preOrder(root);
        middleOrder(root);
        postOrder(root);
        return new int[][]{preList, middleList, postList};
    }

    int pre, middle, post = 0;

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preList[pre++] = root.getVal();
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void middleOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        middleOrder(root.getLeft());
        middleList[middle++] = root.getVal();
        middleOrder(root.getRight());
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.getLeft());
        postOrder(root.getRight());
        postList[post++] = root.getVal();
    }
}
