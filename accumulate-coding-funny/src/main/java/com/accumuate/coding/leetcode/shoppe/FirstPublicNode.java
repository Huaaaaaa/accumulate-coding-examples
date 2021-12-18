package com.accumuate.coding.leetcode.shoppe;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/17 9:50 下午
 * @Description:
 */
public class FirstPublicNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode lNode = pHead1;
        ListNode rNode = pHead2;
        while(lNode!=rNode){
            if(lNode==null){
                lNode = pHead2;
            }else{
                lNode = lNode.next;
            }

            if(rNode==null){
                rNode = pHead1;
            }else{
                rNode = rNode.next;
            }
        }

        return lNode;
    }

    class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
