package com.design.pattern.flyweight;

import lombok.Data;
import org.springframework.core.ParameterizedTypeReference;

import java.io.File;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo: 抽象享元角色
 * Time 12:47
 */
@Data
public abstract class AbstractPoker {

    private String defaultPath = "E:\\res\\";

    /**
     * 扑克序号
     */
    private int number;

    /**
     * 扑克花色
     */
    private String style;

    /**
     * 打牌
     *
     * @param number
     * @param color
     */
    abstract String playCard(int number);

    public void getCard() {
        System.out.println(style + number);
    }

    /**
     * 返回普=扑克牌的路径
     *
     * @return
     */
    public String getCardPath() {
        getCard();
        return defaultPath + style + File.separator + number + ".jpg";
    }

}
