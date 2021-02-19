package com.design.principle.uml.dependence;

import com.accumulate.coding.common.utils.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 学生服务类
 * Time 16:54
 */
public class StudentService {

    /**
     * 获取某个班级的学生:学生服务类通过方法参数依赖了班级类
     *
     * @param classes
     * @return
     */
    public List<Student> getStudents(Class classes) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            student.setStuNo(classes.getGradeId().toString() + classes.getClassId() + i);
            student.setStuName("学生" + i);
            student.setClassId(classes.getClassId());
            student.setGradeId(classes.getGradeId());
            students.add(student);
        }
        System.out.println("studentList=" + JsonUtil.toJsonString(students));
        return students;
    }
}
