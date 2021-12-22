package com.coding.interview.tx;

/**
 * @author: me
 * @createTime: 2021/12/20 9:09 下午
 * @description:
 */
public class LinkListTest {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node tmp = head;
        for (int i = 2; i <= 9; i++) {
            tmp.next = new Node(i);
            tmp = tmp.next;
        }

        Node node = reLink(head);
        while (node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println(node.val);


    }

    public static Node reLink(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node evenNode = new Node(node.val);
        Node oddNode = new Node(node.next.val);
        Node evenTmp = evenNode, oddTmp = oddNode;
        int index = 3;
        Node first = node.next.next;
        while (first != null) {
            if (index % 2 != 0) {
                evenTmp.next = new Node(first.val);
                evenTmp = evenTmp.next;
            } else {
                oddTmp.next = new Node(first.val);
                oddTmp = oddTmp.next;
            }
            first = first.next;
            index++;
        }
        Node tail = evenNode;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = oddNode;
        return evenNode;
    }


    static class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }
}
