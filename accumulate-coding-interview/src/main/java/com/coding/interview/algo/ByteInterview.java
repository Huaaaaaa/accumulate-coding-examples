package com.coding.interview.algo;

import java.util.*;

/**
 * @description:
 */
public class ByteInterview {

    public static void main(String[] args) {
        ByteInterview test = new ByteInterview();
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        for (int i = 0; i < 10; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }

        ListNode listNode = test.removeRepeatEle(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode removeRepeatEle(ListNode head) {
        ListNode node = new ListNode(0);
        ListNode tmp = node;
        Set<Integer> exist = new HashSet<>();
        while (head != null) {
            boolean add = exist.add(head.val);
            if (!add) {
                head = head.next;
                continue;
            }
            tmp.next = new ListNode(head.val);
            tmp = tmp.next;
            head = head.next;
        }
        return node.next;
    }


    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }
    }

}
