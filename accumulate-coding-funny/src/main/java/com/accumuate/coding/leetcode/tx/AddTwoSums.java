package com.accumuate.coding.leetcode.tx;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/23 5:30 下午
 * @description: 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 */
public class AddTwoSums {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-1);
        ListNode listNode1 = head1;
        ListNode listNode2 = head2;
        for (int i = 0; i < 5; i++) {
            listNode1.next = new ListNode(i + 1);
            listNode2.next = new ListNode(i + 2);
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
        AddTwoSums addTwoSums = new AddTwoSums();
        ListNode listNode = addTwoSums.addTwoSums(head1.next, head2.next);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public ListNode addTwoSums(ListNode l1, ListNode l2) {
        ListNode head3 = null, tail3 = null;
        if (null == l1 && null == l2) {
            return head3;
        }

        int inc = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int val = n1 + n2 + inc;
            if (head3 == null) {
                head3 = tail3 = new ListNode(val % 10);
            } else {
                tail3.next = new ListNode(val % 10);
                tail3 = tail3.next;
            }
            inc = val / 10;
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (inc == 1) {
            tail3.next = new ListNode(inc);
        }

        return head3;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
