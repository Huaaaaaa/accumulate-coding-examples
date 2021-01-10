package com.design.pattern.behavioral.visitor.solution3;

import com.design.pattern.behavioral.visitor.solution1.PptFile;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo: 定义访问者，访问者提供具体元素的具体访问方法
 * Time 8:43
 */
public class Extractor3 {

    public void extract2txt(PdfFile3 pdfFile3) {
        System.out.println("Extract pdf to txt...");
    }

    public void extract2txt(PptFile3 pptFile3) {
        System.out.println("Extract ppt to txt...");
    }

    public void extract2txt(WordFile3 wordFile3) {
        System.out.println("Extract word to txt...");
    }
}
