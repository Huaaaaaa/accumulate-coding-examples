package com.accumulate.coding.basic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * @Author: Huaaaaaa
 * Date:  2020/11/28
 * Todo: 通过反射的方式设置Person的head属性
 * Time 11:00
 */
public class SetAndGetField {

    /*public static void main(String[] args) throws Exception {
        PersonReflect personReflect = new PersonReflect();
        PersonAnnotation personAnnotation = new PersonAnnotation();
        setFieldByReflect(personReflect);
        setFieldByAnnotation(personAnnotation);
    }*/

    /**
     * 通过发射的方式设置并获取属性
     *
     * @throws Exception
     */
    private static void setFieldByReflect(PersonReflect personReflect) throws Exception {
        //获取Person的Class对象,这样就能对当前类中的属性和方法为所欲为
        Class<? extends PersonReflect> clazz = personReflect.getClass();
        //new创建Head对象
        Head head = new Head();
        System.out.println("setFieldByReflect new：" + head.hashCode());
        //获取Person的head属性
        Field headField = clazz.getDeclaredField("head");
        //设置访问权限
        headField.setAccessible(true);
        //获取属性名
        String name = headField.getName();
        //获取set方法名:setName,需将属性的首字母转大写
        name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        String methodName = "set" + name;
        //获取方法
        Method setPersonMethod = clazz.getMethod(methodName, Head.class);
        setPersonMethod.setAccessible(true);
        setPersonMethod.invoke(personReflect, head);
        System.out.println("setFieldByReflect 反射：" + personReflect.getHead().hashCode());
    }


    /**
     * 通过注解的方式设置属性
     *
     * @param personAnnotation
     */
    private static void setFieldByAnnotation(PersonAnnotation personAnnotation) {
        Stream.of(personAnnotation.getClass().getDeclaredFields()).forEach(field -> {
            //获取属性的注解
            AutoWiredField autoWiredField = field.getAnnotation(AutoWiredField.class);
            if (autoWiredField != null) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                try {
                    Object o = type.newInstance();
                    field.set(personAnnotation, o);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("setFieldByAnnotation annotation：" + personAnnotation.getHead().hashCode());

    }

}
