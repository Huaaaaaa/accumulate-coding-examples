package com.accumulate.coding.basic.init;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/11/21
 * @description:
 */
public class Son extends Father {

    private String sTest = test();

    private static String ssMethod = method();

    static {
        System.out.println("son static code");
    }

    Son() {
        System.out.println("son constructor");
    }

    {
        System.out.println("son non-static code");
    }


    public String test() {
        System.out.println("son test");
        return "son test";
    }

    public static String method() {
        System.out.println("son static method");
        return "son static method";
    }


    public static void main(String[] args) {
        /*
          一、先执行类的初始化：调用clinit()方法
          1.父类静态变量赋值和静态代码块按顺序执行
          2.子类静态变量赋值和静态代码块按顺序执行
          二、类的初始化：调用init()方法
          1.子类调用Super()方法
            ①父类中的非静态变量赋值和非静态代码块按顺序执行
            ②父类中的静态代码块
            ③父类中的构造方法
            注意：如果父类中的某个非静态方法被重写，则直接调用子类中重写的方法
          2.子类中的非静态变量赋值和非静态代码块按顺序执行
          3.子类中的构造方法最后执行
         */
        System.out.println("---类初始化结束---");
        System.out.println("---实例son1初始化开始---");
        Son son1 = new Son();
        System.out.println("---实例son1初始化结束---");
        System.out.println("---实例son2初始化开始---");
        Son son2 = new Son();
        System.out.println("---实例son2初始化结束---");
    }
}
