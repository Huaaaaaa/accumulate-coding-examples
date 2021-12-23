package com.accumuate.coding.leetcode.linked;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/23 4:57 下午
 * @description:
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class ListNodeSum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode head = l3;
        int inc = 0;
        //先构造新数的头节点
        if (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (sum >= 10) {
                l3.val = sum - 10;
                inc = 1;
            } else {
                l3.val = sum;
            }
        }


        while (l1.next != null || l2.next != null) {
            int sum = 0;
            int nextVal = 0;

            if (l1.next != null && l2.next != null) {
                //两个链表都不为空时相加
                sum = l1.next.val + l2.next.val + inc;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l2.next != null && l1.next == null) {
                //第二个链表不为空时相加
                sum = l2.next.val + inc;
                l2 = l2.next;
            } else if (l2.next == null && l1.next != null) {
                //第一个链表部位空时相加
                sum = l1.next.val + inc;
                l1 = l1.next;
            }

            //如果和大于10，进行进位，并用sum-10做为当前位的和
            if (sum >= 10) {
                nextVal = sum - 10;
                //进位
                inc = 1;
            } else {
                //当和不大于10时，之前的进位要重置
                inc = 0;
                nextVal = sum;
            }
            ListNode ln = new ListNode(nextVal);
            l3.next = ln;
            l3 = ln;
        }
        //最后，还要判断进位是否不为0，可能最后相加的和还要进位
        if (inc != 0) {
            l3.next = new ListNode(inc);
        }
        return head;
    }


    class ListNode {
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
