package com.design.pattern.behavioral.templatemethod;

/**
 * @Author: Huaaaaaa
 * Date:  2021/1/5
 * Todo:
 * Time 11:02
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("开始制作红豆豆浆");
        SoyBeanMilkMaker readSoyBeanMilk = new ReadSoyBeanMilk();
        readSoyBeanMilk.makeSoyBeanMilk();
        System.out.println("\r\n 开始制作纯豆浆");
        SoyBeanMilkMaker pureSoyMilk = new PureSoyMilk();
        pureSoyMilk.makeSoyBeanMilk();
        System.out.println("\r\n 开始制作黑芝麻豆浆");
        SoyBeanMilkMaker blackSesameSoyMilk = new BlackSesameSoyMilk();
        blackSesameSoyMilk.makeSoyBeanMilk();
    }
}
