package com.accumulate.coding.tool.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName BasicDesVo
 * @Description TODO
 * @Author huayingcao2
 * @Date 2020/8/17  16:45
 */
public class BasicDesVo implements Serializable {


    private static final long serialVersionUID = -3969907587778994674L;

    private String name;

    private String sex;

    private int age;

    public BasicDesVo() {
    }


    public BasicDesVo(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BasicDesVo{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}