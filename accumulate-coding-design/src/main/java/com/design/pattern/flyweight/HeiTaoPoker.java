package com.design.pattern.flyweight;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo: 具体享元黑桃
 * Time 13:05
 */
public class HeiTaoPoker extends AbstractPoker {

    @Override
    public String playCard(int number) {
        setNumber(number);
        setStyle("黑桃");
        return getCardPath();
    }
}
