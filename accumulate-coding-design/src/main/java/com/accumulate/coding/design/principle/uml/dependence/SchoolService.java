package com.accumulate.coding.design.principle.uml.dependence;

import java.util.List;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 学校服务类
 * Time 16:54
 */
public class SchoolService {

    /**
     * 学校服务类通过方法返回类型的方式依赖了年级服务类
     *
     * @return
     */
    public List<Grade> getGrades() {
        //学校服务类通过局部方法的方式依赖了年级服务类
        GradeService gradeService = new GradeService();
        return gradeService.getGrades();
    }
}
