package com.accumulate.coding.basic.jvm;

/**
 * @author: cyhua
 * @createTime: 2021/11/12
 * @description:
 */
public class StackOverFlow {

    private int number = 1;

    public void selfAdd() {
        number++;
        System.out.println(number);
        selfAdd();
    }

    public static void main(String[] args) {
        StackOverFlow stackOverFlow = new StackOverFlow();
        stackOverFlow.selfAdd();
    }
}
