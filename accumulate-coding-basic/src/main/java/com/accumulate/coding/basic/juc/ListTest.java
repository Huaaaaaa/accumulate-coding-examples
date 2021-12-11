package com.accumulate.coding.basic.juc;

import net.bytebuddy.dynamic.scaffold.MethodGraph;

import java.util.*;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/11/11
 * @description:
 */
public class ListTest {

    public static void main(String[] args) {
        ListTest listTest = new ListTest();
        listTest.testArrayList();
        listTest.testLinkedList();
        listTest.testVector();
    }

    public void testArrayList() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("admin");
        arrayList.remove(0);
        String s = arrayList.get(0);
        System.out.println(arrayList.size());
        System.out.println(s);
        List<String> strings = Collections.synchronizedList(arrayList);
    }

    public void testLinkedList() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("hello");
        linkedList.add("world");
        linkedList.remove(0);

        String s1 = linkedList.get(0);
        System.out.println(linkedList.size());
        System.out.println(s1);
    }

    public void testVector() {
        Vector<String> vector = new Vector<>();
        vector.add("hello");
        vector.add("world");
        vector.remove(2);
        vector.remove(1);
        System.out.println(vector);
    }


    public void testArray() {
        String[] strings = {"hello"};
        strings[1] = "jjj";
        System.out.println(strings);
    }
}
