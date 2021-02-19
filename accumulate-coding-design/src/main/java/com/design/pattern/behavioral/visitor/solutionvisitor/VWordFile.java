package com.design.pattern.behavioral.visitor.solutionvisitor;

/**
 * @Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo: 定义一个具体元素VWordFile，实现抽象元素中的方法
 * Time 9:17
 */
public class VWordFile extends VResourceFile{

    public VWordFile(String filePath) {
        super(filePath);
    }

    /**
     * 接受访问者，并将自身作为参数传给访问方法
     * @param visitor
     */
    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
