package com.design.pattern.behavioral.interpreter.bus;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  8:49
 * @Description: 抽象表达式（Expression）接口，它包含了解释方法 interpret(String passenger)。
 */
public interface Expression {

    boolean interpret(String passenger);
}
