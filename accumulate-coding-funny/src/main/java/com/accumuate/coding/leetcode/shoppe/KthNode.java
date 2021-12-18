package com.accumuate.coding.leetcode.shoppe;

import com.accumuate.coding.leetcode.BaseArray;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/18 8:53 上午
 * @Description: 给定一棵二叉树proot，找到第k小的节点值
 */
public class KthNode extends BaseArray {


    public static int treeSize(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + treeSize(root.getLeft()) + treeSize(root.getRight());
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = getTreeNode();
        int size = treeSize(treeNode);
        System.out.println(size);
    }

    int lLen = 0;
    int rLen = 0;

    public int KthNode(TreeNode proot, int k) {
        // write code here
        if (null == proot) {
            return -1;
        }
        TreeNode tmp = proot;
        if (tmp.getLeft() != null) {
            lLen += 1;
            KthNode(tmp.getLeft(), k);
        }
        if (lLen == k) {
            return tmp.getVal();
        }
        if (tmp.getRight() != null) {
            rLen += 1;
            KthNode(tmp.getRight(), k);
        }
        if (rLen + lLen + 1 == k) {
            return tmp.getVal();
        }
        return -1;
    }

    public int midOrder(TreeNode root) {
        midOrder(root.getLeft());
        return 0;
    }


}
