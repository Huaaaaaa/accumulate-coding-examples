package com.design.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 企业类
 * Time 11:20
 */
public class Company implements Serializable {


    private static final long serialVersionUID = 1990235500400375259L;

    private List<Department> departments;

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Company{" +
                "departments=" + departments +
                '}';
    }
}
