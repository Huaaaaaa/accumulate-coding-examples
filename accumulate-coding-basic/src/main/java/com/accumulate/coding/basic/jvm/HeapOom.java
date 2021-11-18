package com.accumulate.coding.basic.jvm;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: cyhua
 * @createTime: 2021/11/12
 * @description:
 */
public class HeapOom {

    public static void main(String[] args) {
        List<String> bigObjList = new LinkedList<>();
        int count = 1;
        while (true) {
            System.out.println("第"+(count++)+"个对象");
            bigObjList.add("hello");
        }
    }
}
