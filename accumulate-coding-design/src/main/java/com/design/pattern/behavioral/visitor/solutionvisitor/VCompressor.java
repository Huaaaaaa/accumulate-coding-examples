package com.design.pattern.behavioral.visitor.solutionvisitor;

/**
 * @Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo: 新增压缩功能时，提供压缩功能的访问者，在该访问者中提供对每种元素的具体压缩方法
 * Time 9:31
 */
public class VCompressor implements Visitor {
    /**
     * 提供pdf文件的压缩功能
     *
     * @param vPdfFile
     */
    @Override
    public void visit(VPdfFile vPdfFile) {
        System.out.println("Compress pdf to zip...");
    }

    /**
     * 提供ppt文件的压缩功能
     *
     * @param vPptFile
     */
    @Override
    public void visit(VPptFile vPptFile) {
        System.out.println("Compress ppt to zip...");
    }

    /**
     * 提供word文件的压缩功能
     *
     * @param vWordFile
     */
    @Override
    public void visit(VWordFile vWordFile) {
        System.out.println("Compress word to zip...");
    }
}
