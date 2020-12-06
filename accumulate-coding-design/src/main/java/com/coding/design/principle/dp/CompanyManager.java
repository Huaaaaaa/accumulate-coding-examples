package com.coding.design.principle.dp;

import com.coding.design.vo.Department;

import java.util.List;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 企业管理类
 * Time 11:36
 */
public class CompanyManager {

    private DepManager depManager = new DepManager();

    /**
     * 获取企业下的所有部门及人员
     *
     * @return
     */
    public List<Department> getEmployee() {
        //dm对getEmployee来说不是直接朋友，违背了迪米特法则
        //改进方法：将非直接朋友dm改成直接朋友depManager，直接调用实例方法即可
//        DepManager dm = new DepManager();
        return depManager.getDepartment();
    }
}
