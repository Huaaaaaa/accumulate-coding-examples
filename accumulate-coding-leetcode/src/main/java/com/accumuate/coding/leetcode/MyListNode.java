package com.accumuate.coding.leetcode;

/**
 * @author: huayingcao
 * @createTime: 2021/12/11 1:55 下午
 * @description:
 */
public class MyListNode {

    int val;

    MyListNode next = null;

    public MyListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public MyListNode getNext() {
        return next;
    }

    public void setNext(MyListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "MyListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
