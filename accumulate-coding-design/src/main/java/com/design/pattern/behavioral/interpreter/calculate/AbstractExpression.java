package com.design.pattern.behavioral.interpreter.calculate;

import java.util.HashMap;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  7:41
 * @Description: 抽象表达式（Abstract Expression）角色：定义解释器的接口，约定解释器的解释操作，主要包含解释方法 interpret()
 */
public abstract class AbstractExpression {

    public abstract int interpret(HashMap<String, Integer> vars);
}