package com.accumulate.coding.design.principle.uml.implementation;

import com.accumulate.coding.design.principle.uml.dependence.Student;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo:
 * Time 17:30
 */
public interface ClassService {

    int addStudent(Integer classId, List<Student> students);

    int delStudent(Integer classId, List<Student> students);
}
