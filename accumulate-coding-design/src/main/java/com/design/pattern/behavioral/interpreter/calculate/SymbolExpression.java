package com.design.pattern.behavioral.interpreter.calculate;

import java.util.HashMap;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  7:51
 * @Description: 非终结符表达式（Nonterminal Expression）角色：也是抽象表达式的子类，用来实现文法中与非终结符相关的操作，
 * 文法中的每条规则都对应于一个非终结符表达式。
 */
public class SymbolExpression extends AbstractExpression{

    /**
     * 运算符表达式左边的表达式
     */
    protected AbstractExpression leftExpression;

    /**
     * 运算符表达式右边的表达式
     */
    protected AbstractExpression rightExpression;

    public SymbolExpression(AbstractExpression leftExpression, AbstractExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    /**
     * 增加一个默认实现
     * @param vars
     * @return
     */
    @Override
    public int interpret(HashMap<String, Integer> vars) {
        return 0;
    }
}
