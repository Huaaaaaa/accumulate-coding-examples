package com.accumuate.coding.leetcode.dec.nine;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: cyhua
 * @createTime: 2021/12/9
 * @description:
 */
public class ReverseLinkNode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        String[] nextArray = next.split(",");
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode curr = head;
        for (String nextEle : nextArray) {
            ListNode nextNode = new ListNode(Integer.parseInt(nextEle));
            nextNode.next = null;
            curr.next = nextNode;
            curr = nextNode;
        }
        ListNode listNode = reverseList(head);
        while (null != listNode.next) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static ListNode reverse(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        //把链表节点全部摘掉放到栈中
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty())
            return null;
        ListNode node = stack.pop();
        ListNode dummy = node;
        //栈中的结点全部出栈，然后重新连成一个新的链表
        while (!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        //最后一个结点就是反转前的头结点，一定要让他的next
        //等于空，否则会构成环
        node.next = null;
        return dummy;
    }


    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        ListNode addNode(ListNode node) {
            if (this.next == null) {
                this.next = node;
            } else {
                addNode(node);
            }
            return this;
        }
    }

}
