package com.design.pattern.behavioral.interpreter.calculate;

import java.util.HashMap;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  7:57
 * @Description: 加法表达式
 */
public class AddSymbolExpression extends SymbolExpression{


    public AddSymbolExpression(AbstractExpression leftExpression, AbstractExpression rightExpression) {
        super(leftExpression, rightExpression);
    }


    /**
     * 重写interpret方法，实现加法运算
     * @param vars
     * @return
     */
    @Override
    public int interpret(HashMap<String, Integer> vars) {
        return super.leftExpression.interpret(vars)+super.rightExpression.interpret(vars);
    }
}
