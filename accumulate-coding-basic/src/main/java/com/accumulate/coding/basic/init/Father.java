package com.accumulate.coding.basic.init;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/11/21
 * @description:
 */
public class Father {

    private String fTest = test();

    private static String fsMethod = method();

    static {
        System.out.println("father static code");
    }


    Father() {
        System.out.println("father constructor");
    }

    {
        System.out.println("father non-static code");
    }


    public String test() {
        System.out.println("father test");
        return "father test";
    }

    public static String method() {
        System.out.println("father static method");
        return "father static method";
    }
}
