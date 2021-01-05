package com.design.pattern.creational.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo: 原型模式实现
 * Time 19:40
 */
public class ProtoTypeClient {

    public static void main(String[] args) {
        traditionMethod();
        protoTypeMethod();
    }

    /**
     * 传统方式实现5个一样的People
     */
    private static void traditionMethod() {
        System.out.println("传统方法实现创建多个相同的对象");
        People son = getOriginPeople();
        Long startTime = System.currentTimeMillis();
        People p1 = new People("张飒", 20, 300L, 5000000.00, son);
        People p2 = new People("张飒", 20, 300L, 5000000.00, son);
        People p3 = new People("张飒", 20, 300L, 5000000.00, son);
        People p4 = new People("张飒", 20, 300L, 5000000.00, son);
        People p5 = new People("张飒", 20, 300L, 5000000.00, son);
        System.out.println("timeUsed=" + (System.currentTimeMillis() - startTime));//25
        System.out.println("p1=" + p1.toString() + "=== p1.hashCode=" + p1.hashCode() + "=== p1.son.hashCode=" + p1.getSon().hashCode());
        System.out.println("p2=" + p2.toString() + "=== p2.hashCode=" + p2.hashCode() + "=== p2.son.hashCode=" + p2.getSon().hashCode());
        System.out.println("p3=" + p3.toString() + "=== p3.hashCode=" + p3.hashCode() + "=== p3.son.hashCode=" + p3.getSon().hashCode());
        System.out.println("p4=" + p4.toString() + "=== p4.hashCode=" + p4.hashCode() + "=== p4.son.hashCode=" + p4.getSon().hashCode());
        System.out.println("p5=" + p5.toString() + "=== p5.hashCode=" + p5.hashCode() + "=== p5.son.hashCode=" + p5.getSon().hashCode());
        System.out.println("p1" + (p1 == p2 ? "等于" : "不等于") + "p2" + "----" + "p1.son" + (p1.getSon() == p2.getSon() ? "等于" : "不等于") + "p2.son");
    }

    /**
     * 使用原型模式：需要实现Cloneable接口，并重写clone方法
     * 基本类型：值赋值，深拷贝
     * 引用类型：地址值赋值，都是指向原始对象中引用类型的内存地址，浅拷贝
     */
    private static void protoTypeMethod() {
        System.out.println("使用原型模式实现创建多个相同的对象");
        People son = getOriginPeople();
        People p1 = new People("张飒", 20, 300L, 5000000.00, son);
        Long startTime = System.currentTimeMillis();
        People p2 = (People) p1.clone();
        People p3 = (People) p1.clone();
        People p4 = (People) p1.clone();
        People p5 = (People) p1.clone();
        System.out.println("timeUsed=" + (System.currentTimeMillis() - startTime));//0
        System.out.println("p1=" + p1.toString() + "=== p1.hashCode=" + p1.hashCode() + "=== p1.son.hashCode=" + p1.getSon().hashCode());
        System.out.println("p2=" + p2.toString() + "=== p2.hashCode=" + p2.hashCode() + "=== p2.son.hashCode=" + p2.getSon().hashCode());
        System.out.println("p3=" + p3.toString() + "=== p3.hashCode=" + p3.hashCode() + "=== p3.son.hashCode=" + p3.getSon().hashCode());
        System.out.println("p4=" + p4.toString() + "=== p4.hashCode=" + p4.hashCode() + "=== p4.son.hashCode=" + p4.getSon().hashCode());
        System.out.println("p5=" + p5.toString() + "=== p5.hashCode=" + p5.hashCode() + "=== p5.son.hashCode=" + p5.getSon().hashCode());
        System.out.println("p1" + (p1 == p2 ? "等于" : "不等于") + p2 + "----" + "p1.son" + (p1.getSon() == p2.getSon() ? "等于" : "不等于") + "p2.son");
    }

    private static People getOriginPeople() {
        People son = new People("张飒儿子", 2, 20000l, 20.00, null);
        return son;
    }

}

@Data
@AllArgsConstructor
class People implements Cloneable {

    private String name;

    private Integer age;

    private Long idNo;

    private Double deposit;

    //引用类型在原型模式中的浅拷贝证明
    private People son;

    @Override
    protected Object clone() {

        People people = null;
        try {
            people = (People) super.clone();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        // TODO Auto-generated method stub
        return people;
    }


}


