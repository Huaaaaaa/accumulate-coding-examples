package com.design.pattern.behavioral.visitor.solutionvisitor;

/**
 * @Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo: 定义一个抽象元素，提供接受一个抽象访问者的接口
 * Time 9:14
 */
public abstract class VResourceFile {

    private String filePath;


    public VResourceFile(String filePath) {
        this.filePath = filePath;
    }

    abstract void accept(Visitor visitor);
}
