package com.design.principle.uml.dependence;

import com.accumulate.coding.common.utils.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 年级服务类
 * Time 16:54
 */
public class GradeService {

    /**
     * 年级服务通过成员变量的方法依赖了班级服务
     */
    private ClassService classService;

    /**
     * 获取班级
     *
     * @return
     */
    public List<Grade> getGrades() {
        //违背了迪米特原则，但是一般的实现中直接通过依赖注入，无需new
        classService = new ClassService();
        List<Grade> grades = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Grade grade = new Grade();
            grade.setGradeId(i);
            grade.setName(i + "年级");
            grade.setClassList(classService.getClasses(grade));
            grades.add(grade);
        }
        System.out.println("gradeList=" + JsonUtil.toJsonString(grades));
        return grades;
    }
}
