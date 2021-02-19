package com.design.pattern.behavioral.visitor.solution1;

/**
 * @Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo:
 * Time 8:16
 */
public class PptFile extends ResourceFile {

    public PptFile(String filePath) {
        super(filePath);
    }

    @Override
    void extract2txt() {
        System.out.println("Extract ppt to txt...");
    }
}
