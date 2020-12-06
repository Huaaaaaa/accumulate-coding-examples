package com.coding.design.principle.dp;

import com.coding.design.vo.Department;
import com.coding.design.vo.Employee;
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

    private EmployeeManager employeeManager = new EmployeeManager();

    /**
     * 获取部门接口
     *
     * @return
     */
    public List<Department> getDepartment() {
        //改进方法：将原来的非直接朋友改为直接朋友，方法内不需要做new直接朋友的操作，拿到其实例对象直接使用即可
//        EmployeeManager em = new EmployeeManager();
        List<Employee> employeeList = employeeManager.getDepEmployee();
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
