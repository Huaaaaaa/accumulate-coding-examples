package com.accumulate.coding.tool.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName BasicSource
 * @Description TODO
 * @Author huayingcao2
 * @Date 2020/8/17  16:43
 */

public class BasicSourceVo implements Serializable {


    private static final long serialVersionUID = 1729780558902388296L;

    private String name;

    private String sex;

    private int age;

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

    public BasicSourceVo() {
    }

    public BasicSourceVo(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return "BasicSourceVo{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
