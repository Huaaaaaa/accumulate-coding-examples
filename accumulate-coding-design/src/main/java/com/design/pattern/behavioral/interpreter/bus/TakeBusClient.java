package com.design.pattern.behavioral.interpreter.bus;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  9:05
 * @Description:
 */
public class TakeBusClient {

    public static void main(String[] args) {
        Context bus = new Context();
        bus.swipeCard("北京的老人");
        bus.swipeCard("北京的年轻人");
        bus.swipeCard("深圳的妇女");
        bus.swipeCard("天津的儿童");
        bus.swipeCard("山东的儿童");
    }
}
