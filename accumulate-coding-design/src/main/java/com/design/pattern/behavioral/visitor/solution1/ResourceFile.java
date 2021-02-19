package com.design.pattern.behavioral.visitor.solution1;

/**
 * @Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo:
 * Time 8:12
 */
public abstract class ResourceFile {

    protected String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    abstract void extract2txt();
}
