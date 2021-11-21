package com.accumulate.coding.basic.base;

import com.accumulate.coding.basic.common.User;

import java.util.HashSet;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/11/15
 * @description:
 */
public class Classic {

    private String name;

    private HashSet<String> studentName;


    public Classic(String name) {
        this.name = name;
    }

    public void getTeacher(User user) {
        user.setName(name + "的班主任" + user.getName());
        user.setAge(30);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<String> getStudentName() {
        return studentName;
    }

    public void setStudentName(HashSet<String> studentName) {
        this.studentName = studentName;
    }

    @Override
    public int hashCode() {
        return 1024;
    }

    public boolean equals(Classic classic) {
        return this.name.equals(classic.name);
    }


}
