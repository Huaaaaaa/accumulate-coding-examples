package com.design.pattern.behavioral.interpreter.calculate;

import java.util.HashMap;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  7:47
 * @Description: 终结符表达式（Terminal Expression）角色：是抽象表达式的子类，用来实现文法中与终结符相关的操作，文法中的每一个终结符都有一个具体终结表达式与之相对应。
 */
public class VarExpression extends AbstractExpression{

    /**
     * 变量值：a=10,b=5,c=6
     */
    private String var;

    public VarExpression(String var) {
        this.var = var;
    }

    /**
     * 在终结符表达式中，获取终结符的值
     * @param vars
     * @return
     */
    @Override
    public int interpret(HashMap<String, Integer> vars) {
        return vars.get(var);
    }
}
