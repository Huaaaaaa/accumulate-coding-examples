package com.accumuate.coding.leetcode.linked;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/6 12:22 下午
 * @description:
 */
public class MergeTwoList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode target = new ListNode(-1);
        ListNode pre = target;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null ? list2 : list1;
        return target.next;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
