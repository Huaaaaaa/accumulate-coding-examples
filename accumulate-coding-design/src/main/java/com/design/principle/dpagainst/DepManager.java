package com.design.principle.dpagainst;

import com.design.vo.Department;
import com.design.vo.Employee;
import lombok.var;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 部门管理类
 * Time 12:07
 */
public class DepManager {

    /**
     * 获取部门接口
     * @return
     */
    public List<Department> getDepartment() {
        //em对getDepartment来说不是直接朋友，违背了迪米特法则
        EmployeeManager em = new EmployeeManager();
        List<Employee> employeeList = em.getDepEmployee();
        List<Department> departmentList = new ArrayList<>();
        for (var i = 0; i < 5; i++) {
            Department department = new Department();
            List<Employee> employees;
            String depName = "dep" + i;
            int depId = i;
            department.setIdNo(depId);
            department.setName(depName);
            employees = employeeList.stream().filter(employee -> employee.getDepId() == depId).collect(Collectors.toList());
            department.setEmployeeList(employees);
            departmentList.add(department);
        }
        return departmentList;
    }

}
