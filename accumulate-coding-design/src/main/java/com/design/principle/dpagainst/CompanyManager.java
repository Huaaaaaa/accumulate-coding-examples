package com.design.principle.dpagainst;

import com.design.vo.Department;

import java.util.List;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 企业管理类
 * Time 11:36
 */
public class CompanyManager {

    /**
     * 获取企业下的所有部门及人员
     *
     * @return
     */
    public List<Department> getEmployee() {
        //dm对getEmployee来说不是直接朋友，违背了迪米特法则
        DepManager dm = new DepManager();
        return dm.getDepartment();
    }
}
