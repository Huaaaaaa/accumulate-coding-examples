package com.design.pattern.behavioral.visitor.solution2;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo: 定义extract类，重载extract2txt方法
 * Time 8:29
 */
public class Extractor {

    public void extract2txt(PdfFile2 pdfFile2) {
        System.out.println("Extract pdf to ext...");
    }

    public void extract2txt(WordFile2 wordFile2) {
        System.out.println("Extract word to ext...");
    }

    public void extract2txt(PptFile2 pptFile2) {
        System.out.println("Extract PPT to ext...");
    }
}
