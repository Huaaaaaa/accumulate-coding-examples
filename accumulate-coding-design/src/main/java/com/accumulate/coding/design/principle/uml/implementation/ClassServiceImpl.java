package com.accumulate.coding.design.principle.uml.implementation;

import com.accumulate.coding.design.principle.uml.dependence.Student;

import java.util.List;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: ClassServiceImpl实现ClassService接口，他们属于实现关系，即面向接口编程
 * Time 17:32
 */
public class ClassServiceImpl implements ClassService {

    @Override
    public int addStudent(Integer classId, List<Student> students) {
        return 0;
    }

    @Override
    public int delStudent(Integer classId, List<Student> students) {
        return 0;
    }
}
