package com.accumulate.coding.basic.jvm;

import com.accumulate.coding.basic.common.User;

/**
 * @author: cyhua
 * @createTime: 2021/11/12
 * @description:
 */
public class Memory {

    //常量
    public static final int initData = 666;

    //静态变量
    public static User user = new User();

    public int add() {
        int a = 1;
        int b = 2;
        int c = a + b;
        return c;
    }

    public static void main(String[] args) {
        Memory memory = new Memory();
        int add = memory.add();
        System.out.println(add);
    }
}
