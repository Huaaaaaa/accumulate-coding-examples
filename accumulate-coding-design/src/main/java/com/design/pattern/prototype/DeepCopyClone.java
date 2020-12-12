package com.design.pattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo:
 * Time 20:08
 */
public class DeepCopyClone {

    public static void main(String[] args) {
        cloneDeepCopy();
    }

    private static void cloneDeepCopy() {
        System.out.println("使用clone方法实现深拷贝");
        CloneSon son = getSon();
        CloneOriginPeople p1 = new CloneOriginPeople("张飒", 20, 300L, 5000000.00, son);
        Long startTime = System.currentTimeMillis();
        CloneOriginPeople p2 = (CloneOriginPeople) p1.clone();
        CloneOriginPeople p3 = (CloneOriginPeople) p1.clone();
        CloneOriginPeople p4 = (CloneOriginPeople) p1.clone();
        CloneOriginPeople p5 = (CloneOriginPeople) p1.clone();
        System.out.println("timeUsed=" + (System.currentTimeMillis() - startTime));//0
        System.out.println("p1=" + p1.toString() + "=== p1.hashCode=" + p1.hashCode() + "=== p1.son.hashCode=" + p1.getSon().hashCode());
        System.out.println("p2=" + p2.toString() + "=== p2.hashCode=" + p2.hashCode() + "=== p2.son.hashCode=" + p2.getSon().hashCode());
        System.out.println("p3=" + p3.toString() + "=== p3.hashCode=" + p3.hashCode() + "=== p3.son.hashCode=" + p3.getSon().hashCode());
        System.out.println("p4=" + p4.toString() + "=== p4.hashCode=" + p4.hashCode() + "=== p4.son.hashCode=" + p4.getSon().hashCode());
        System.out.println("p5=" + p5.toString() + "=== p5.hashCode=" + p5.hashCode() + "=== p5.son.hashCode=" + p5.getSon().hashCode());
        System.out.println("p1" + (p1 == p2 ? "等于" : "不等于") + "p2" + "----" + "p1.son" + (p1.getSon() == p2.getSon() ? "等于" : "不等于") + "p2.son");
    }

    private static CloneSon getSon() {
        CloneSon son = new CloneSon("张飒儿子", 2, 20000l);
        return son;
    }
}

@Data
@AllArgsConstructor
class CloneOriginPeople implements Cloneable {
    private String name;

    private Integer age;

    private Long idNo;

    private Double deposit;

    private CloneSon son;

    @Override
    protected Object clone() {

        Object people = null;
        try {
            //基本类型clone
            people = super.clone();
            CloneOriginPeople p = (CloneOriginPeople) people;
            //引用类型的clone，如果不加这行，则son成员就是浅拷贝
            p.setSon((CloneSon) son.clone());
        } catch (Exception e) {
            System.out.println(e);
        }
        return people;
    }
}

@Data
@AllArgsConstructor
class CloneSon implements Cloneable {
    private String name;

    private Integer age;

    private Long idNo;

    @Override
    protected Object clone() {

        CloneSon son = null;
        try {
            //基本类型clone
            son = (CloneSon) super.clone();
        } catch (Exception e) {
            System.out.println(e);
        }
        return son;
    }
}