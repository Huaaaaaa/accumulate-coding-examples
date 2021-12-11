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
        TreeNode left = new TreeNode(array[1]);
        TreeNode right = new TreeNode(array[2]);
        root.setLeftChild(left);
        root.setRightChild(right);
        return root;
    }
}
