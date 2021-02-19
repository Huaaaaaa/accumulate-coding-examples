package com.design.pattern.behavioral.visitor.solution3;

import com.design.pattern.behavioral.visitor.solution2.PdfFile2;
import com.design.pattern.behavioral.visitor.solution2.PptFile2;
import com.design.pattern.behavioral.visitor.solution2.WordFile2;

/**
 * @Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo: 新增压缩功能，提供访问者
 * Time 9:07
 */
public class Compressor {

    public void compress(PdfFile3 pdfFile3) {
        System.out.println("Compress pdf to zip...");
    }

    public void compress(WordFile3 wordFile3) {
        System.out.println("Compress word to zip...");
    }

    public void compress(PptFile3 pptFile3) {
        System.out.println("Compress PPT to zip...");
    }
}
