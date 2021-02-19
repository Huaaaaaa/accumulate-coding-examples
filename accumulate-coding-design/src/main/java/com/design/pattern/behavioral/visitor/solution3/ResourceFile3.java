package com.design.pattern.behavioral.visitor.solution3;

/**
 * @Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo: 定义一个抽象元素，提供接收访问者方法
 * Time 8:27
 */
public abstract class ResourceFile3 {

    private String filePath;

    public ResourceFile3(String filePath) {
        this.filePath = filePath;
    }

    abstract void accept(Extractor3 extractor3);

    abstract void accept(Compressor compressor);
}
