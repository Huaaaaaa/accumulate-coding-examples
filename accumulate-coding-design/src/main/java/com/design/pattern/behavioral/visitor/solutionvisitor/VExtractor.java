package com.design.pattern.behavioral.visitor.solutionvisitor;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo: 定义一个具体的访问者，实现抽象访问者
 * Time 9:21
 */
public class VExtractor implements Visitor {

    /**
     * 提供pdf文件转txt的功能
     *
     * @param vPdfFile
     */
    @Override
    public void visit(VPdfFile vPdfFile) {
        System.out.println("Extract pdf to txt...");
    }

    /**
     * 提供ppt文件转txt的功能
     *
     * @param vPptFile
     */
    @Override
    public void visit(VPptFile vPptFile) {
        System.out.println("Extract ppt to txt...");
    }

    /**
     * 提供word文件转txt的功能
     *
     * @param vWordFile
     */
    @Override
    public void visit(VWordFile vWordFile) {
        System.out.println("Extract word to txt...");
    }
}
