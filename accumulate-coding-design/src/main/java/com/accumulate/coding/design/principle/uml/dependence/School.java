package com.accumulate.coding.design.principle.uml.dependence;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 学校
 * Time 16:43
 */
@Data
public class School {

    /**
     * 学校编码：学校和id是一对一的关联关系
     */
    private Integer schoolId;

    /**
     * 学校名称：学校和名称也是一对一的关联关系
     */
    private String schoolName;

    /**
     * 学校的年级：学校和年级是一对多的关联关系
     */
    private List<Grade> grades;
}
