package com.design.pattern.behavioral.interpreter.bus;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  8:49
 * @Description: 终结符表达式（TerminalExpression）类，它用集合（Set）类来保存满足条件的城市或人，
 * 并实现抽象表达式接口中的解释方法 interpret(passenger)，用来判断被分析的字符串是否是集合中的终结符。
 */
public class TerminalExpression implements Expression {

    private Set<String> passengers = new HashSet<>();

    public TerminalExpression(String[] data) {
        passengers.addAll(Arrays.asList(data));
    }

    /**
     * 判断当前乘客是否满足免费条件
     * @param passenger
     * @return
     */
    @Override
    public boolean interpret(String passenger) {
        if (passengers.contains(passenger)) {
            return true;
        }
        return false;
    }
}
