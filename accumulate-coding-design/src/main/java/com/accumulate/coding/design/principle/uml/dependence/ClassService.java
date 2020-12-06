package com.accumulate.coding.design.principle.uml.dependence;

import com.accumulate.coding.common.utils.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 班级服务类
 * Time 16:54
 */
public class ClassService {

    /**
     * 班级服务类通过成员变量的方法依赖了学生服务类
     */
    private StudentService studentService;

    /**
     * 获取某个年级下的班级
     *
     * @param grade 班级服务类通过方法参数的方式依赖了年级类
     * @return
     */
    public List<Class> getClasses(Grade grade) {
        List<Class> classList = new ArrayList<>();
        //违背了迪米特原则，但是一般的实现中直接通过依赖注入，无需new
        studentService = new StudentService();
        for (int i = 0; i < 6; i++) {
            Class classes = new Class();
            classes.setClassId(i);
            classes.setClassName(grade.getGradeId() + "年级" + i + "班");
            classes.setGradeId(grade.getGradeId());
            classes.setStudentList(studentService.getStudents(classes));
            classList.add(classes);
        }
        System.out.println("classList=" + JsonUtil.toJsonString(classList));
        return classList;
    }

}
