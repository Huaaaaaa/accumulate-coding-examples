package com.design.pattern.behavioral.visitor.solution3;

import com.design.pattern.behavioral.visitor.solution2.ResourceFile2;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo: 具体元素：word文件
 * Time 8:28
 */
public class WordFile3 extends ResourceFile3 {

    public WordFile3(String filePath) {
        super(filePath);
    }

    /**
     * 重写accept方法，给访问者的extract2txt方法传入当前类WordFile3（具体）
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
