package com.design.pattern.structrual.flyweight;

import org.springframework.util.StringUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo: 享元工程角色
 * Time 13:08
 */
public class PokerFactory {

    private static Map<String, File> pokerMap = new HashMap<>();

    public static File getPokerCard(String style, int number) {
        String key = style + number;
        if (pokerMap.containsKey(key) || StringUtils.isEmpty(pokerMap.get(key))) {
            AbstractPoker poker;
            switch (style) {
                case "黑桃":
                    poker = new HeiTaoPoker();
                    break;
                case "红桃":
                    poker = new HongTaoPoker();
                    break;
                case "方块":
                    poker = new FangKuaiPoker();
                    break;
                case "梅花":
                    poker = new MeiHuaPoker();
                    break;
                default:
                    poker = new JokerPoker();
                    break;
            }

            pokerMap.put(key, new File(poker.playCard(number)));

        }
        return pokerMap.get(key);
    }
}
