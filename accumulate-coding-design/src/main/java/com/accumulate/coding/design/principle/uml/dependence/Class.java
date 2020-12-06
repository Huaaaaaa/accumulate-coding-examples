package com.accumulate.coding.design.principle.uml.dependence;

import lombok.Data;

import javax.annotation.security.DenyAll;
import java.util.List;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 班级
 * Time 16:44
 */
@Data
public class Class {

    /**
     * 班级id
     */
    private Integer classId;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 所属年级
     */
    private Integer gradeId;

    /**
     * 该班级下的所有学生：班级和学生是一对多的关联关系
     */
    private List<Student> studentList;
}
