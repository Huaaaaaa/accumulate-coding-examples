package com.design.pattern.structrual.flyweight;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo: 具体享元梅花扑克
 * Time 12:49
 */
public class MeiHuaPoker extends AbstractPoker {

    @Override
    public String playCard(int number) {
        super.setNumber(number);
        super.setStyle("梅花");
        return getCardPath();
    }
}
