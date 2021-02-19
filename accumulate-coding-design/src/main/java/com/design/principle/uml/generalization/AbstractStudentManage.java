package com.design.principle.uml.generalization;

import com.design.principle.uml.dependence.Student;

import java.util.List;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 一个学生管理抽象类
 * Time 17:26
 */
public abstract class AbstractStudentManage {

    public abstract Integer addStudent(List<Student> students);

    public abstract Integer delStudent(List<String> stuNo);
}
