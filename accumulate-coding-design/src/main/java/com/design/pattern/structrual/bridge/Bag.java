package com.design.pattern.structrual.bridge;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/14
 * Todo: 包包类
 * Time 10:41
 */
@Data
public class Bag implements Serializable {


    private static final long serialVersionUID = -8666885484849813726L;

    /**
     * 包包颜色
     */
    private String color;

    /**
     * 包包样式
     */
    private String style;


}
