package com.accumuate.coding.leetcode.basic;

import apple.laf.JRSUIUtils;
import com.accumuate.coding.leetcode.BaseArray;
import com.accumuate.coding.leetcode.tree.TreeNode;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Vector;

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
        TreeNode treeNode = getTreeNode();
        BinaryTreeThreeOrder binaryTreeThreeOrder = new BinaryTreeThreeOrder();
        int[][] res = binaryTreeThreeOrder.threeOrders(treeNode);
        Arrays.stream(res).forEach(s-> Arrays.stream(s).forEach(value -> System.out.println(value)));

    }

    public int size(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            return 1 + size(treeNode.getLeftChild()) + size(treeNode.getRightChild());
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
        preList[pre++] = root.getData();
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());
    }

    public void middleOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        middleOrder(root.getLeftChild());
        middleList[middle++] = root.getData();
        middleOrder(root.getRightChild());
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.getLeftChild());
        postOrder(root.getRightChild());
        postList[post++] = root.getData();
    }
}
