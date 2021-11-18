package com.accumulate.coding.basic.juc;

import java.util.*;

/**
 * @author: cyhua
 * @createTime: 2021/11/16
 * @description:
 */
public class SetTest {

    public static void main(String[] args) {
        SetTest setTest = new SetTest();
        setTest.testTreeSet();
    }

    public void testHashSet() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("hs1");
        hashSet.add("hs2");
        System.out.println("testHashSet add hashSet=" + hashSet.stream().iterator().next());

        hashSet.remove("hs1");
        System.out.println("testHashSet remove hashSet=" + hashSet.stream().iterator().next());

        String first = hashSet.stream().findFirst().get();
        System.out.println("testHashSet first hashSet=" + first);

        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void testTreeSet() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("zhaolei");
        treeSet.add("dabing");
        treeSet.add("liutong");
        treeSet.add("yangshitou");
        treeSet.add("pushu");
        treeSet.add("yiyangqianxi");
        System.out.println("testTreeSet treeSet ="+treeSet);

        TreeSet<String> treeSetOrder = new TreeSet<>((o1, o2) -> o2.compareTo(o1));
        treeSetOrder.add("zhaolei");
        treeSetOrder.add("dabing");
        treeSetOrder.add("liutong");
        treeSetOrder.add("yangshitou");
        treeSetOrder.add("pushu");
        treeSetOrder.add("yiyangqianxi");
        System.out.println("testTreeSet treeSetOrder="+treeSetOrder);
    }

    public void testLinkedHashSet() {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("hs1");
        linkedHashSet.add("hs2");
        System.out.println("testLinkedHashSet add linkedHashSet=" + linkedHashSet.stream().iterator().next());

        linkedHashSet.remove("hs1");
        System.out.println("testLinkedHashSet remove linkedHashSet=" + linkedHashSet.stream().iterator().next());

        String first = linkedHashSet.stream().findFirst().get();
        System.out.println("testLinkedHashSet first hashSet=" + first);

        Iterator<String> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
