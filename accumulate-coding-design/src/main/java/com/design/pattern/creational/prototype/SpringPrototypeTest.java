package com.design.pattern.creational.prototype;

import com.accumulate.coding.common.utils.JsonUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo:
 * Time 21:44
 */
public class SpringPrototypeTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("common.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(JsonUtil.toJsonString(student));

    }
}
