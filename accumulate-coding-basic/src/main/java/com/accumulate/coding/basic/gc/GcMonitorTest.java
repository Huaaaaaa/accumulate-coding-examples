package com.accumulate.coding.basic.gc;

import java.util.ArrayList;

/**
 * @author: cyhua
 * @createTime: 2021/12/10
 * @description:
 */
public class GcMonitorTest {

    public static void main(String[] args) {
        while (true){
            ArrayList<String> data = new ArrayList<>();
            data.add("hello gc,hello java!");
        }
    }
}
