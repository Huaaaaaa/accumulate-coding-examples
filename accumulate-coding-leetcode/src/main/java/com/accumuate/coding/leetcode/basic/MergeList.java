package com.accumuate.coding.leetcode.basic;

import com.accumuate.coding.leetcode.BaseArray;
import com.accumuate.coding.leetcode.MyListNode;
import org.springframework.util.CollectionUtils;

/**
 * @author: huayingcao
 * @createTime: 2021/12/11 1:33 下午
 * @description:
 */
public class MergeList extends BaseArray {

    public static void main(String[] args) {
        MyListNode[] listNode = getListNode();
        MyListNode merge = Merge(listNode[0], listNode[1]);
        System.out.println(CollectionUtils.arrayToList(merge));
    }

    public static MyListNode merge(MyListNode list1, MyListNode list2) {
        while (list2.getNext() != null && list1.getNext() != null) {
            if (list1.getVal() <= list2.getVal()) {
                MyListNode list2tmp = list2.getNext();
                MyListNode list1tmp = list1.getNext();
                list1.setNext(list2);
                list2.setNext(list1tmp);
                merge(list1tmp, list2tmp);
            } else {
                MyListNode list2tmp = list2.getNext();
                MyListNode list1tmp = list1.getNext();
                list2.setNext(list1);
                list1.setNext(list2tmp);
                merge(list1tmp, list2tmp);
            }
        }
        return list1;
    }

    public static MyListNode Merge(MyListNode list1, MyListNode list2) {
        // 一般需要创建一个变量来做链表操作，例如temp1和temp2还有新链表的list_new
        MyListNode head = new MyListNode(-1);
        MyListNode list_new = head;
        MyListNode temp1 = list1;
        MyListNode temp2 = list2;
        if (list1 == null && list2 == null) return null;
        while (temp1 != null && temp2 != null) {
            if (temp1.getVal() <= temp2.getVal()) {
                //引入的这些变量不用再进行下一个节点的指向动作，因为这个链表不像头插法本身就没有动
                list_new.setNext(temp1);
                temp1 = temp1.getNext();
            } else {
                list_new.setNext(temp2);
                temp2 = temp2.getNext();
            }
            list_new = list_new.getNext();
        }
        if (temp1 == null) {
            list_new.setNext(temp2);
        }
        if (temp2 == null) {
            list_new.setNext(temp1);
        }
        return head.getNext();
    }


}
