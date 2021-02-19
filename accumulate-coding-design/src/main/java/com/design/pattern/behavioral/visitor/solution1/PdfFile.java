package com.design.pattern.behavioral.visitor.solution1;

/**
 * @Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo:
 * Time 8:13
 */
public class PdfFile extends ResourceFile {


    public PdfFile(String filePath) {
        super(filePath);
    }

    @Override
    void extract2txt() {
        System.out.println("Extract pdf to txt...");
    }
}
