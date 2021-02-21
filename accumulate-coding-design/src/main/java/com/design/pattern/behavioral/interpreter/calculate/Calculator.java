package com.design.pattern.behavioral.interpreter.calculate;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  8:03
 * @Description: 计算器
 */
public class Calculator {

    private AbstractExpression expression;

    /**
     * 传入一个a+b-c的表达式进行运算
     *
     * @param expression
     */
    public Calculator(String expression) {
        Stack<AbstractExpression> stack = new Stack<>();
        //将表达式转成字符数组：[a,+,b,-,c]
        char[] chars = expression.toCharArray();

        //定义左和右表达式
        AbstractExpression left = null;
        AbstractExpression right = null;

        for (int i = 0; i < chars.length; i++) {
            char var = chars[i];
            switch (var) {
                case '+':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(chars[++i]));
                    stack.push(new AddSymbolExpression(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(chars[++i]));
                    stack.push(new SubSymbolExpression(left, right));
                    break;
                default:
                    //当当前字符为变量时，直接入栈
                    stack.push(new VarExpression(String.valueOf(var)));
                    break;
            }
        }
        this.expression = stack.pop();
    }


    public int run(HashMap<String, Integer> var) {
        return this.expression.interpret(var);
    }
}
