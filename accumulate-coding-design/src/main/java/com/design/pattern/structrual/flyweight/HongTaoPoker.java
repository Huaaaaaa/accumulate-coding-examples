package com.design.pattern.structrual.flyweight;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo: 具体享元红桃
 * Time 13:06
 */
public class HongTaoPoker extends AbstractPoker {

    @Override
    public String playCard(int number) {
        setNumber(number);
        setStyle("红桃");
        return getCardPath();
    }
}
