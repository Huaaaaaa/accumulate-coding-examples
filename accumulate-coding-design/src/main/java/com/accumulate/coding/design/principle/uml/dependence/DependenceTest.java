package com.accumulate.coding.design.principle.uml.dependence;

import com.accumulate.coding.common.utils.JsonUtil;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo:
 * Time 17:22
 */
public class DependenceTest {

    public static void main(String[] args) {
        SchoolService ss = new SchoolService();
        System.out.println(JsonUtil.toJsonString(ss.getGrades()));
    }
}
