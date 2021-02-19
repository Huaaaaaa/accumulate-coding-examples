package com.design.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 企业部门类
 * Time 11:19
 */
public class Department implements Serializable {


    private static final long serialVersionUID = 4378775156722909523L;

    /**
     * 部门id
     */
    private Integer idNo;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 企业员工
     */
    List<Employee> employeeList;

    public Integer getIdNo() {
        return idNo;
    }

    public void setIdNo(Integer idNo) {
        this.idNo = idNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "idNo=" + idNo +
                ", name='" + name + '\'' +
                ", employeeList='" + employeeList.toString() + '\'' +
                '}';
    }
}
