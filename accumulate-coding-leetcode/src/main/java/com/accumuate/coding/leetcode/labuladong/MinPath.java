package com.accumuate.coding.leetcode.labuladong;

import com.accumuate.coding.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: cyhua
 * @createTime: 2021/5/31
 * @description: 计算二叉树的最短路径
 */
public class MinPath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode lLeft = new TreeNode(4);
        TreeNode lRight = new TreeNode(5);
        TreeNode llLeft = new TreeNode(8);
        TreeNode lllLeft = new TreeNode(10);
        TreeNode rLeft = new TreeNode(6);
        TreeNode rRight = new TreeNode(7);
        TreeNode rrRight = new TreeNode(9);
        root.setLeftChild(left);
        root.setRightChild(right);
        left.setLeftChild(lLeft);
        left.setRightChild(lRight);
        lLeft.setLeftChild(llLeft);
        lllLeft.setLeftChild(lllLeft);
        right.setLeftChild(rLeft);
        right.setRightChild(rRight);
        rRight.setRightChild(rrRight);
        int depth = minPath(root);
        System.out.println("该二叉树的最小高度是：" + depth);


    }

    public static int minPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode currNode = q.poll();
                TreeNode leftChild = currNode.getLeftChild();
                TreeNode rightChild = currNode.getRightChild();
                if (leftChild == null && rightChild == null) {
                    return depth;
                }
                if (leftChild != null) {
                    q.offer(leftChild);
                }
                if (rightChild != null) {
                    q.offer(rightChild);
                }
            }
            depth++;
        }
        return depth;
    }

}
