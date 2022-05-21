package com.coding.interview;

public class Testing {

    public TreeNode publicParent(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == n1 || root == n2) {
            return root;
        }
        TreeNode treeNode = publicParent(root.left, n1, n2);
        if (treeNode != null) {
            return treeNode;
        }
        treeNode = publicParent(root.right, n1, n2);
        if (treeNode != null) {
            return treeNode;
        }
        return root;
    }


    class TreeNode {

        TreeNode left;

        TreeNode right;

        public TreeNode() {
        }

    }
}
