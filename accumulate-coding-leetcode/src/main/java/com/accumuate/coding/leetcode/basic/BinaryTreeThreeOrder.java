package com.accumuate.coding.leetcode.basic;

import com.accumuate.coding.leetcode.BaseArray;
import com.accumuate.coding.leetcode.tree.TreeNode;
import org.springframework.util.CollectionUtils;

import java.util.Vector;

/**
 * @author: huayingcao
 * @createTime: 2021/12/11 2:43 下午
 * @description:
 */
public class BinaryTreeThreeOrder extends BaseArray {

    private Vector<Integer> preList = new Vector<Integer>();
    private Vector<Integer> middleList = new Vector<Integer>();
    private Vector<Integer> postList = new Vector<Integer>();

    public static void main(String[] args) {
        TreeNode treeNode = getTreeNode();
        BinaryTreeThreeOrder binaryTreeThreeOrder = new BinaryTreeThreeOrder();
        Vector<Vector<Integer>> res = binaryTreeThreeOrder.threeOrders(treeNode);
        System.out.println(res);

    }

    public Vector<Vector<Integer>> threeOrders(TreeNode root) {
        preOrder(root);
        middleOrder(root);
        postOrder(root);
        Vector<Vector<Integer>> res = new Vector();
        res.add(preList);
        res.add(middleList);
        res.add(postList);
        return res;
    }

    int pre, middle, post = 0;

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preList.add(root.getData());
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());
    }

    public void middleOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        middleOrder(root.getLeftChild());
        middleList.add(root.getData());
        middleOrder(root.getRightChild());
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.getLeftChild());
        postOrder(root.getRightChild());
        postList.add(root.getData());
    }
}
