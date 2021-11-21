package com.accumulate.coding.basic.base;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/11/15
 * @description:
 */
public class MathTest {

    public static String name = "java";

    public static void main(String[] args) {
        //round();
        System.out.println("name=" + name);
        name = "2";
        System.out.println("name=" + name);
    }

    public static void round() {
        System.out.println("正数输出");
        System.out.println("11.25:" + Math.round(11.25));//11
        System.out.println("11.5:" + Math.round(11.5));//12
        System.out.println("11.54:" + Math.round(11.54));//12
        System.out.println("11.55:" + Math.round(11.55));//12
        System.out.println("11.56:" + Math.round(11.56));//12
        System.out.println("负数输出");
        System.out.println("-11.25:" + Math.round(-11.25));//-11
        System.out.println("-11.5:" + Math.round(-11.5));//-11
        System.out.println("-11.54:" + Math.round(-11.54));//-12
        System.out.println("-11.55:" + Math.round(-11.55));//-12
        System.out.println("-11.56:" + Math.round(-11.56));//-12
    }

    public static void shortAdd() {
        short s1 = 1;
        s1 = (short) (s1 + 1);
        System.out.println("s1=" + s1);
        short s2 = 2;
        s2 += 1;//s2=short(s2+1)
        System.out.println("s2=" + s2);
    }


    public void commonMethod() {
        shortAdd();
    }

}
