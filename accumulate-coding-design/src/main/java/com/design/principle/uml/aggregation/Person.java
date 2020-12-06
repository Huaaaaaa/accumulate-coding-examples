package com.design.principle.uml.aggregation;

import lombok.Data;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo:
 * Time 17:33
 */
@Data
public class Person {

    /**
     * 腿:人与腿是整体与部分的关系，而且可以分离，所以是聚合关系
     */
    private Leg leg;

    /**
     * 脚：人与脚是整体与部分的关系，而且可以分离，所以是聚合关系
     */
    private Foot foot;
}
