package com.design.principle.dpagainst;

import com.accumulate.coding.common.utils.JsonUtil;
import com.design.vo.Department;

import java.util.List;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo:
 * Time 12:32
 */
public class DmAgainstTest {

    public static void main(String[] args) {
        CompanyManager cm = new CompanyManager();
        List<Department> depList = cm.getEmployee();
        System.out.println(JsonUtil.toJsonString(depList));
    }
}
