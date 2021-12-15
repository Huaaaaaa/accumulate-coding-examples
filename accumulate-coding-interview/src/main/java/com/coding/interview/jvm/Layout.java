package com.coding.interview.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/15 6:41 上午
 * @Description: 面试题：new Object()占用了多少内存？
 */
public class Layout {

    public static void main(String[] args) {
        Object o = new Object();
        ReadObject readObject = new ReadObject();
        System.out.println(ClassLayout.parseInstance(readObject).toPrintable());
    }
}
