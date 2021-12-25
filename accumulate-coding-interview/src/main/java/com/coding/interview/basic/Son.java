package com.coding.interview.basic;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/23 8:20 下午
 * @description:
 */
public class Son extends Parent {

    public Son() {
        System.out.println("子类构造方法中调用父类变量:size=" + size);
    }
}
