package com.design.pattern.structrual.flyweight;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo: 具体享元方块扑克
 * Time 13:00
 */
public class FangKuaiPoker extends AbstractPoker {




    @Override
    public String playCard(int number) {
        setNumber(number);
        setStyle("方块");
        return getCardPath();
    }
}
