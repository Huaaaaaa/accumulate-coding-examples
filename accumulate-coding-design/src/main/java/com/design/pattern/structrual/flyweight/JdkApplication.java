package com.design.pattern.structrual.flyweight;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo: 享元模式在jdk中的应用:Integer
 * Time 14:36
 */
public class JdkApplication {

    public static void main(String[] args) {
        Integer a = -128;
        Integer b = 127;
        Integer c = 128;

        Integer a1 = new Integer(-128);
        Integer b1 = new Integer(127);
        Integer c1 = new Integer(128);

        int a11 = a1.intValue();
        int b11 = b1.intValue();
        int c11 = c1.intValue();

        Integer a111 = Integer.valueOf(-128);
        Integer b111 = Integer.valueOf(127);
        Integer c111 = Integer.valueOf(128);

        Integer a1111= Integer.valueOf(a11);
        Integer b1111 = Integer.valueOf(b11);
        Integer c1111 = Integer.valueOf(c11);

        System.out.println(a == a1);//false
        System.out.println(b == b1);//false
        System.out.println(c == c1);//false

        /**
         * 基本类型和其包装类型进行比较时，包装类首先会被自动拆箱成基本类型
         */
        System.out.println(a == a11);//true
        System.out.println(b == b11);//true
        System.out.println(c == c11);//true

        System.out.println(a11 == a1);//true
        System.out.println(b11 == b1);//true
        System.out.println(c11 == c1);//true

        System.out.println(a111 == a1111);//true
        System.out.println(b111 == b1111);//true
        System.out.println(c111 == c1111);//false 使用IntegerValue方法时使用了享元模式，所以-128~127之间的数字是指向同一块内存空间



    }
}
