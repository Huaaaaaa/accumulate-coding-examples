package com.design.pattern.behavioral.interpreter.bus;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  8:55
 * @Description: 非终结符表达式（FreeConditionExpression）类，它也是抽象表达式的子类，
 * 它包含满足条件的城市的终结符表达式对象和满足条件的人员的终结符表达式对象，并实现 interpret(String passenger) 方法，
 * 用来判断被分析的字符串是否是满足条件的城市中的满足条件的人员。
 */
public class FreeConditionExpression implements Expression {

    /**
     * 满足条件的城市
     */
    private Expression city;

    /**
     * 满足条件的人
     */
    private Expression person;

    public FreeConditionExpression(Expression city, Expression person) {
        this.city = city;
        this.person = person;
    }

    @Override
    public boolean interpret(String passenger) {
        String[] vars = passenger.split("的");
        return city.interpret(vars[0]) && person.interpret(vars[1]);
    }
}
