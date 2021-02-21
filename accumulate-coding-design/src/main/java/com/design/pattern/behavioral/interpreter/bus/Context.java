package com.design.pattern.behavioral.interpreter.bus;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/21  9:03
 * @Description: 个环境（Context）类，它包含解释器需要的数据，完成对终结符表达式的初始化，并定义一个方法
 */
public class Context {

    private String[] citys = {"北京", "天津", "河北"};
    private String[] persons = {"老人", "妇女", "儿童"};
    private Expression cityPerson;

    public Context() {
        Expression city = new TerminalExpression(citys);
        Expression person = new TerminalExpression(persons);
        cityPerson = new FreeConditionExpression(city, person);
    }

    public void swipeCard(String info) {
        boolean ok = cityPerson.interpret(info);
        if (ok) System.out.println("您是" + info + "，您本次乘车免费！");
        else System.out.println(info + "，您不是免费人员，本次乘车扣费2元！");
    }
}
