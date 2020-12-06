package com.accumulate.coding.design.principle.dp;

import com.accumulate.coding.common.utils.JsonUtil;
import com.accumulate.coding.design.vo.Department;

import java.util.List;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo:
 * Time 12:32
 */
public class DmTest {

    public static void main(String[] args) {
        CompanyManager cm = new CompanyManager();
        List<Department> depList = cm.getEmployee();
        System.out.println(JsonUtil.toJsonString(depList));
    }
}
