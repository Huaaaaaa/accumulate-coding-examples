package com.accumulate.coding.basic.base;

import com.accumulate.coding.basic.common.User;

import java.util.HashSet;

/**
 * @author: cyhua
 * @createTime: 2021/11/15
 * @description:
 */
public class HashCodeTest {

    public static void main(String[] args) {
        /*Classic classic1 = new Classic("java1");
        Classic classic2 = new Classic("java1");
        System.out.println("classic1-hashCode:" + classic1.hashCode() + ";classic1-hashCode:" + classic1.hashCode());
        System.out.println(classic1.equals(classic2));
        User teacher = new User();
        teacher.setName("张可");
        classic1.getTeacher(teacher);
        System.out.println("name=" + teacher.getName() + "age=" + teacher.getAge());

        String s1 = "java";
        String s2 = "java";
        System.out.println("s1-hashCode:" + s1.hashCode() + ";s2-hashCode:" + s2.hashCode());
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
        System.out.println(s1 == s2.intern());


        HashSet<String> person = new HashSet<>();
        person.add("张三");
        person.add("李四");
        person.add("张三");
        System.out.println(person.toString());

        testStringAndArray();*/
        autoBox();

    }


    private static void testStringAndArray() {
        String[] names = new String[]{"hello", "world"};
        String msg = "hello world";
        System.out.println("arrayLength:" + names.length + ";strLength:" + msg.length());
    }

    private static void autoBox() {
        Integer a = 128;
        Integer b = 128;
        boolean res = a == b;
        System.out.println("autoBox res=" + res);
        int a1 = 128;
        int b1 = 128;
        boolean res1 = a1 == b1;
        System.out.println("autoBox res1=" + res1);

    }
}
