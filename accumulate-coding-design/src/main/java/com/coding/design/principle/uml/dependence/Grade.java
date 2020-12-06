package com.coding.design.principle.uml.dependence;

import lombok.Data;

import java.util.List;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 年级
 * Time 16:44
 */
@Data
public class Grade {

    /**
     * 年级id
     */
    private Integer gradeId;

    /**
     * 年级名称
     */
    private String name;

    /**
     * 该年级下的所有班级：年级和班级是一对多的关联关系
     */
    private List<Class> classList;


}
