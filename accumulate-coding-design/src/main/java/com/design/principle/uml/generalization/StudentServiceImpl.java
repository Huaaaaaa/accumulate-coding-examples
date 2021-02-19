package com.design.principle.uml.generalization;

import com.design.principle.uml.dependence.Student;

import java.util.List;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: StudentServiceImpl与AbstractStudentManage是泛化（继承）关系
 * Time 17:28
 */
public class StudentServiceImpl extends AbstractStudentManage {

    @Override
    public Integer addStudent(List<Student> students) {
        return students.size();
    }

    @Override
    public Integer delStudent(List<String> stuNo) {
        return stuNo.size();
    }
}
