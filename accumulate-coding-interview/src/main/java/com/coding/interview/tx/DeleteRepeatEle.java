package com.coding.interview.tx;

import java.util.HashSet;

/**
 * @description: 删除两个链表中相同元素
 * 删除两个有序链表中所有相同元素，比如
 * 链表1: 3-> 5 -> 10 ->25
 * 链表2: 1 -> 5 ->5 -> 10 -> 35
 * 链表中5 和10 是两个链表的公有元素，因此需要从两个链表中删除。删除后链表如下所示：
 * 链表1:   3 -> 25
 * 链表2：1 -> 35
 * 样例1:
 * [输入]
 * 3-> 5 -> 10 ->25  , 1 -> 5 -> 10 -> 35
 * [输出]
 * 3 -> 25,1 -> 35
 */
public class DeleteRepeatEle {
    public static void main(String[] args) {
        DeleteRepeatEle testing = new DeleteRepeatEle();
        ListNode listNode11 = new ListNode(3);
        ListNode listNode12 = new ListNode(5);
        ListNode listNode13 = new ListNode(10);
        ListNode listNode14 = new ListNode(25);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(5);
        ListNode listNode222 = new ListNode(5);
        ListNode listNode23 = new ListNode(10);
        ListNode listNode24 = new ListNode(35);
        listNode21.next = listNode22;
        listNode22.next = listNode222;
        listNode222.next = listNode23;
        listNode23.next = listNode24;
        testing.deleteRepeatEle(listNode11, listNode21);
    }

    public void deleteSameEle(ListNode listNode1, ListNode listNode2) {
        ListNode node1Tmp = new ListNode(-1);
        ListNode node2Tmp = new ListNode(-1);
        node1Tmp.next = listNode1;
        node2Tmp.next = listNode2;
        retry:
        while (node1Tmp.next != null) {
            ListNode node1Next = node1Tmp.next;
            while (node2Tmp.next != null) {
                ListNode node2Next = node2Tmp.next;
                if (node1Next.val == node2Next.val) {
                    node1Tmp.next = node1Next.next;
                    node2Tmp.next = node2Next.next;
                    continue retry;
                } else {
                    node2Tmp = node2Next.next;
                }
            }
            node1Tmp = node1Tmp.next;
        }
        while (node1Tmp != null) {
            System.out.println("listNode1=" + node1Tmp.val);
            node1Tmp = node1Tmp.next;
        }
        while (node2Tmp != null) {
            System.out.println("listNode2=" + node2Tmp.val);
            node2Tmp = node2Tmp.next;
        }

    }


    public void deleteRepeatEle(ListNode listNode1, ListNode listNode2) {
        //先定义一个头结点
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-1);
        //再定义一个临时结点，将头结点赋值给临时结点
        ListNode node1Tmp = head1;
        ListNode node2Tmp = head2;
        HashSet<Integer> set = new HashSet<>();
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val > listNode2.val) {
                if (!set.contains(listNode2.val)) {
                    node2Tmp.next = new ListNode(listNode2.val);
                    node2Tmp = node2Tmp.next;
                }
                listNode2 = listNode2.next;
            } else if (listNode1.val < listNode2.val) {
                if (!set.contains(listNode1.val)) {
                    node1Tmp.next = new ListNode(listNode1.val);
                    node1Tmp = node1Tmp.next;
                }
                listNode1 = listNode1.next;
            } else {
                set.add(listNode1.val);
                listNode1 = listNode1.next;
                listNode2 = listNode2.next;
            }
        }

        while (listNode1 != null) {
            if (!set.contains(listNode1.val)) {
                node1Tmp.next = new ListNode(listNode1.val);
                node1Tmp = node1Tmp.next;
            }
            listNode1 = listNode1.next;
        }
        while (listNode2 != null) {
            if (!set.contains(listNode2.val)) {
                node2Tmp.next = new ListNode(listNode2.val);
                node2Tmp = node2Tmp.next;
            }
            listNode2 = listNode2.next;
        }
        head1 = head1.next;
        head2 = head2.next;
        while (head1 != null) {
            System.out.println("listNode1=" + head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
            System.out.println("listNode2=" + head2.val);
            head2 = head2.next;
        }
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
