package com.design.pattern.behavioral.visitor.solution2;

import com.design.pattern.behavioral.visitor.solution1.PdfFile;
import com.design.pattern.behavioral.visitor.solution1.PptFile;
import com.design.pattern.behavioral.visitor.solution1.ResourceFile;
import com.design.pattern.behavioral.visitor.solution1.WordFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/10
 * Todo: 通过方法重载实现，丹会报编译时异常
 * Time 8:18
 */
public class ToolApplication2 {

    public static void main(String[] args) {
        /**
         * 通过重载抽象类中的extract2txt方法，传入具体的Resource对象，执行其方法
         * 问题：extract.extract2txt(resourceFile);报错，即ResourceFile2中没有extract2txt方法
         * 分析：
         * 在上面代码的第 31～34 行中，resourceFiles 包含的对象的声明类型都是 ResourceFile，
         * 而我们并没有在 Extractor 类中定义参数类型是 ResourceFile 的 extract2txt() 重载函数，所以在编译阶段就通过不了，
         * 更别说在运行时根据对象的实际类型执行不同的重载函数了。
         * 原因：
         * ●多态是一种动态绑定，可以在运行时获取对象的实际类型，来运行实际类型对应的方法。
         * ●函数重载是一种静态绑定，在编译时并不能获取对象的实际类型，而是根据声明类型执行声明类型对应的方法。
         */
        Extractor extractor = new Extractor();
        List<ResourceFile2> resourceFiles = getResources();
        for (ResourceFile2 resourceFile : resourceFiles) {
//            extractor.extract2txt(resourceFile);
        }
    }

    private static List<ResourceFile2> getResources() {

        ArrayList<ResourceFile2> resourceFiles = new ArrayList<>();
        resourceFiles.add(new PdfFile2("E://a.pdf"));
        resourceFiles.add(new WordFile2("E://b.word"));
        resourceFiles.add(new PptFile2("E://c.ppt"));
        return resourceFiles;


    }
}
