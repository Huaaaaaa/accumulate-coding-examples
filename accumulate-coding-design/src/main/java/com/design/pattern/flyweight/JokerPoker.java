package com.design.pattern.flyweight;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo:
 * Time 13:55
 */
public class JokerPoker extends AbstractPoker {

    @Override
    public String playCard(int number) {
        setNumber(number);
        setStyle("王");
        return getCardPath();
    }
}
