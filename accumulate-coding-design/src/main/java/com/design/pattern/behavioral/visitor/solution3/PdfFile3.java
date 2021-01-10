package com.design.pattern.behavioral.visitor.solution3;

import com.design.pattern.behavioral.visitor.solution2.ResourceFile2;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo: 具体元素：pdf文件
 * Time 8:27
 */
public class PdfFile3 extends ResourceFile3 {

    public PdfFile3(String filePath) {
        super(filePath);
    }

    /**
     * 重写accept方法，给访问者的extract2txt方法传入当前类PdfFile3（具体）
     *
     * @param extractor3
     */
    @Override
    void accept(Extractor3 extractor3) {
        extractor3.extract2txt(this);
    }

    @Override
    void accept(Compressor compressor) {
        compressor.compress(this);
    }


}
