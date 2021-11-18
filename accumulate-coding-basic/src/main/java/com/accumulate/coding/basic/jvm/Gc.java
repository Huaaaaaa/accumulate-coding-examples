package com.accumulate.coding.basic.jvm;

import java.util.ArrayList;

/**
 * @author: cyhua
 * @createTime: 2021/11/12
 * @description:
 */
public class Gc {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Gc> gcList = new ArrayList<>();
        while (true) {
            gcList.add(new Gc());
            Thread.sleep(10);
        }
    }
}
