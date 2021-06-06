package com.accumulate.coding.basic.jvm;

/**
 * @author: cyhua
 * @createTime: 2021/6/7
 * @description:
 */
public class Accumulate {

    public static void main(String[] args) {
        Accumulate accumulate = new Accumulate();
        int price = accumulate.price();
        System.out.println("price="+price);
    }


    public int price(){
        int a = 3;
        int b = 10;
        int c = a*(a+b);
        return c;
    }
}
