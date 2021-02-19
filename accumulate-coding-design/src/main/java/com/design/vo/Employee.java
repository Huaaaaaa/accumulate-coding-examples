package com.design.vo;

import java.io.Serializable;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo: 企业员工类
 * Time 11:15
 */
public class Employee implements Serializable {

    private static final long serialVersionUID = -2107239778807444970L;
    /**
     * 员工ID
     */
    private Integer idNo;
    /**
     * 员工名称
     */
    private String name;

    /**
     * 所属部门Id
     */
    private Integer depId;

    /**
     * 所属部门名称
     */
    private String depName;

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

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idNo=" + idNo +
                ", name='" + name + '\'' +
                ", depId=" + depId +
                ", depName='" + depName + '\'' +
                '}';
    }
}
