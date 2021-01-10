package com.design.pattern.behavioral.visitor.solutionvisitor;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo: 定义一个抽象访问者接口，提供不同元素的访问方法
 * Time 9:16
 */
public interface Visitor {

    /**
     * 提供pdf文件的访问方法
     *
     * @param vPdfFile
     */
    void visit(VPdfFile vPdfFile);

    /**
     * 提供ppt文件的访问方法
     *
     * @param vPptFile
     */
    void visit(VPptFile vPptFile);

    /**
     * 提供word的访问方法
     *
     * @param vWordFile
     */
    void visit(VWordFile vWordFile);
}
