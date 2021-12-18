package com.accumuate.coding.leetcode;

import com.accumuate.coding.leetcode.tree.TreeNode;

import java.util.List;
import java.util.Scanner;

/**
 * @author: huayingcao
 * @createTime: 2021/12/11 1:15 下午
 * @description:
 */
public class BaseArray {

    protected static String[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input");
        String src = scanner.nextLine();
        String[] srcString = src.split(" ");
        return srcString;
    }

    protected static int[] getArray() {
        String[] srcString = inputArray();
        int length = srcString.length;
        int[] data = new int[length];
        for (int i = 0; i < length; i++) {
            data[i] = Integer.parseInt(srcString[i]);
        }
        return data;
    }

    protected static MyListNode[] getListNode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input");
        String src = scanner.nextLine();
        String left = src.substring(0, src.indexOf(","));
        String right = src.substring(src.indexOf(",") + 1);
        String[] leftArray = left.split(" ");
        String[] rightArray = right.split(" ");
        MyListNode leftListNode = getListNode(leftArray);
        MyListNode rightListNode = getListNode(rightArray);
        return new MyListNode[]{leftListNode, rightListNode};
    }

    public static MyListNode getListNode(String[] data) {
        int i = 0;
        MyListNode head = new MyListNode(Integer.parseInt(data[i++]));
        MyListNode curr = head;

        while (i < data.length) {
            MyListNode next = new MyListNode(Integer.parseInt(data[i]));
            curr.setNext(next);
            curr = next;
            i++;
        }
        return head;
    }

    public static TreeNode getTreeNode() {
        int[] array = getArray();
        TreeNode root = new TreeNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            TreeNode node = new TreeNode(array[i]);
            insertTree(root, node);
        }
        System.out.println(root);
        return root;
    }

    public static void insertTree(TreeNode root, TreeNode newNode) {
        if (root.val < newNode.val) {
            if (root.right != null) {
                insertTree(root.right, newNode);
            } else {
                root.right = newNode;
            }
        } else if (root.val > newNode.val) {
            if (root.left != null) {
                insertTree(root.left, newNode);
            } else {
                root.left = newNode;
            }
        }
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
