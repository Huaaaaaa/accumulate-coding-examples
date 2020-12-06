package com.accumulate.coding.design.principle.dpagainst;

import com.accumulate.coding.design.vo.Employee;
import lombok.var;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 员工管理类
 * Time 12:08
 */
public class EmployeeManager {


    /**
     * 获取各部门员工
     * @return
     */
    public List<Employee> getDepEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            var employee = new Employee();
            employee.setDepId(i);
            employee.setDepName("dep" + i);
            for (int j = 0; j < 10; j++) {
                employee.setIdNo(j);
                employee.setName("employee" + j);
                employeeList.add(employee);
            }
        }
        return employeeList;
    }
}
