package com.design.pattern.behavioral.visitor.solution1;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo:
 * Time 8:16
 */
public class WordFile extends ResourceFile{

    public WordFile(String filePath) {
        super(filePath);
    }

    @Override
    void extract2txt() {
        System.out.println("Extract word to txt...");
    }
}
