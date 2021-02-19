package com.design.principle.uml.dependence;

import lombok.Data;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 学生
 * Time 16:45
 */
@Data
public class Student {

    /**
     * 学生id
     */
    private String stuNo;

    /**
     * 学生名称
     */
    private String stuName;

    /**
     * 所属班级
     */
    private Integer classId;

    /**
     * 所属年级
     */
    private Integer gradeId;

}
